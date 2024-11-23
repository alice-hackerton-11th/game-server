package com.elice.gameservice.domain.game.store

import com.elice.gameservice.domain.game.model.GameState

interface GameStore {
    fun saveGameState(gameState: GameState): GameState
}