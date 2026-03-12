package com.example.ffsupercool.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ffsupercool.data.*

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel())
{
    val uiState by homeViewModel.uiState.collectAsState()

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
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(text = match.sport, color = match.sportColor, fontSize = 12.sp)
                if (match.status == MatchStatus.FINISHED) {
                    Text(text = "${match.scoreA} - ${match.scoreB}", fontWeight = FontWeight.Bold)
                } else {
                    Text(text = "À venir", color = Color.Blue)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${match.teamA} vs ${match.teamB}", style = MaterialTheme.typography.titleMedium)
            Text(text = match.venue, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}