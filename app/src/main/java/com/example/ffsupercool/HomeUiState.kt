package com.example.ffsupercool

import com.example.ffsupercool.data.FollowedTeam
import com.example.ffsupercool.data.Match
import com.example.ffsupercool.data.listMatches

data class HomeUiState(
    val leagueName: String = "Pays de la Loire",
    val followedTeams: List<FollowedTeam> = listOf(
        FollowedTeam("Basket", "Masculin", "Centrale 1"),
        FollowedTeam("Volley", "Féminin", "Audencia 1")
    ),
    val allMatches: List<Match> = listMatches
)