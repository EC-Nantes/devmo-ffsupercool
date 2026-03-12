package com.example.ffsupercool.ui

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
            onClick = { },
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
            onClick = { },
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
            onClick = { },
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