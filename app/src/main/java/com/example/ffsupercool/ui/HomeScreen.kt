package com.example.ffsupercool.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ffsupercool.data.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ffsupercool.HomeUiState


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    com.example.ffsupercool.ui.HomeScreenContent(
        uiState = uiState,
        onRemoveTeam = { team -> homeViewModel.removeTeam(team) }
    )
}

@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    onRemoveTeam: (FollowedTeam) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            com.example.ffsupercool.ui.Header(leagueName = uiState.leagueName)
        },
        bottomBar = { BottomNav("home") }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                Text(
                    text = "ÉQUIPES SUIVIES",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(uiState.followedTeams) { team ->
                com.example.ffsupercool.ui.FollowedTeamItem(
                    team = team,
                    onRemoveClick = { onRemoveTeam(team) }
                )
            }

            item { HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp)) }

            item {
                Text(
                    text = "MATCHS",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            items(uiState.allMatches) { match ->
                com.example.ffsupercool.ui.MatchCardSimple(match)
            }
        }
    }
}

@Composable
fun Header(leagueName: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Accueil", style = MaterialTheme.typography.headlineMedium)
        Text(text = leagueName, color = Color.Gray)
    }
}

@Composable
fun MatchCardSimple(match: Match) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = match.sport, color = match.sportColor, fontSize = 12.sp)
                if (match.status == MatchStatus.FINISHED) {
                    Text(text = "${match.scoreA} - ${match.scoreB}", fontWeight = FontWeight.Bold)
                } else {
                    Text(text = "À venir", color = Color.Blue)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${match.teamA} vs ${match.teamB}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = match.venue, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}

@Composable
fun FollowedTeamItem(
    team: FollowedTeam,
    onRemoveClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = team.team, style = MaterialTheme.typography.bodyLarge)
                Text(text = "${team.sport} · ${team.category}", style = MaterialTheme.typography.bodySmall)
            }
            IconButton(onClick = onRemoveClick) {
                Icon(Icons.Default.Close, contentDescription = "Supprimer")
            }

        }
    }
}