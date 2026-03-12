package com.example.ffsupercool

import com.example.ffsupercool.ui.theme.*

val listMatches = listOf(
    Match(
        id = "1",
        sport = "Basket",
        sportIcon = "🏀",
        category = "Masculin",
        teamA = "Centrale 1",
        teamB = "IMT Atlantique",
        scoreA = 78,
        scoreB = 72,
        date = "Jeu. 5 mar",
        time = "18h30",
        venue = "Gymnase Centrale",
        status = MatchStatus.FINISHED,
        sportColor = SportBasket,
        championship = "District",
        poule = "Poule 1"
    ),
    Match(
        id = "2",
        sport = "Volley",
        sportIcon = "🏐",
        category = "Féminin",
        teamA = "Audencia 1",
        teamB = "Centrale 2",
        date = "Jeu. 12 mar",
        time = "19h00",
        venue = "Salle Omnisports",
        status = MatchStatus.UPCOMING,
        sportColor = SportVolley,
        championship = "Écoles",
        poule = "Poule 1"
    ),
    Match(
        id = "3",
        sport = "Volley",
        sportIcon = "🏐",
        category = "Féminin",
        teamA = "NSU",
        teamB = "Audencia 1",
        scoreA = 2,
        scoreB = 1,
        date = "Lun. 2 mar",
        time = "14h00",
        venue = "Stade Municipal",
        status = MatchStatus.FINISHED,
        sportColor = SportFootball,
        championship = "District",
        poule = "Poule 2"
    ),
    Match(
        id = "4",
        sport = "Basket",
        sportIcon = "🏀",
        category = "Masculin",
        teamA = "Centrale 1",
        teamB = "Audencia 3",
        date = "Dim. 15 mar",
        time = "17h00",
        venue = "Gymnase Centrale",
        status = MatchStatus.UPCOMING,
        sportColor = SportBasket,
        championship = "Écoles",
        poule = "Poule 2"
    )
)
