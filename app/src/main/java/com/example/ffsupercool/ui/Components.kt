package com.example.ffsupercool.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ffsupercool.ui.theme.*


@Composable
fun BottomNav(selectedItem: String) {
    NavigationBar(
        containerColor = PurpleGrey40,
        contentColor = Pink80,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Accueil") },
            label = { Text("Accueil") },
            selected = selectedItem == "home",
            onClick = { },//non implémenté car il faut aller sur une autre page pour y accéder
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Purple80,
                selectedTextColor = Purple80,
                unselectedIconColor = Pink80,
                unselectedTextColor = Pink80,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Search, contentDescription = "Recherche") },
            label = { Text("Recherche") },
            selected = selectedItem == "search",
            onClick = { },//non implémenté
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Purple80,
                selectedTextColor = Purple80,
                unselectedIconColor = Pink80,
                unselectedTextColor = Pink80,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Star, contentDescription = "Classements") },
            label = { Text("Classements") },
            selected = selectedItem == "standings",
            onClick = { }, //non implémenté
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Purple80,
                selectedTextColor = Purple80,
                unselectedIconColor = Pink80,
                unselectedTextColor = Pink80,
                indicatorColor = Color.Transparent
            )
        )
    }
}


@Composable
fun MatchCard(match: Match) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBg
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box {
            //barre de couleur sur le côté pour le sport
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(100.dp)
                    .align(Alignment.CenterStart)
                    .background(match.sportColor)
            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Titre de laa box
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = match.sportIcon, fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "${match.sport} · ${match.category}",
                            color = TextGray,
                            fontSize = 12.sp
                        )
                    }

                    // Statut du match (à venir ou score si finis)
                    if (match.status == MatchStatus.FINISHED) {
                        Text(
                            text = "${match.scoreA} – ${match.scoreB}",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    } else {
                        Surface(
                            color = AccentBlue.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "À venir",
                                color = AccentBlue,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // equipes
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = match.teamA,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.End,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = " VS ",
                        modifier = Modifier.padding(horizontal = 12.dp),
                        color = TextGray,
                        fontSize = 14.sp
                    )
                    Text(
                        text = match.teamB,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Start,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // date, lieu
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${match.date} · ${match.time}",
                        color = TextGray,
                        fontSize = 12.sp
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = TextGray,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = match.venue,
                            color = TextGray,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}