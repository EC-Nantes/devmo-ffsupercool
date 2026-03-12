package com.example.ffsupercool.data

import androidx.compose.ui.graphics.Color

data class Match(
    val id: String,
    val sport: String,
    val sportIcon: String,
    val category: String,
    val teamA: String,
    val teamB: String,
    val date: String,
    val time: String,
    val venue: String,
    val status: MatchStatus,
    val scoreA: Int? = null,
    val scoreB: Int? = null,
    val sportColor: Color,
    val championship: String? = null,
    val poule: String? = null
)

enum class MatchStatus {
    UPCOMING, FINISHED
}

