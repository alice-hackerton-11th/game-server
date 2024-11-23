package com.elice.gameservice.infrastructure.game.store

import com.elice.gameservice.domain.game.model.GameState
import com.elice.gameservice.domain.game.store.GameStore
import com.elice.gameservice.infrastructure.game.repository.GameStateRepository
import org.springframework.stereotype.Component

@Component
class GameStoreImpl(
    private val gameStateRepository: GameStateRepository
) : GameStore {
    override fun saveGameState(gameState: GameState): GameState {
        return gameStateRepository.save(gameState.roomId, gameState)
    }
}