package com.example.ffsupercool.ui

import androidx.lifecycle.ViewModel
import com.example.ffsupercool.HomeUiState
import com.example.ffsupercool.data.FollowedTeam
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    /**
     * Supprimer une équipe des favoris
     */
    fun removeTeam(teamToRemove: FollowedTeam) {
        _uiState.update { currentState ->
            currentState.copy(
                followedTeams = currentState.followedTeams.filter { it != teamToRemove }
            )
        }
    }


}