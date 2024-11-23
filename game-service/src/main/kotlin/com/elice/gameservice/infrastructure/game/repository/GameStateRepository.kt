package com.elice.gameservice.infrastructure.game.repository

import com.elice.gameservice.domain.game.model.GameState
import org.springframework.stereotype.Repository

@Repository
class GameStateRepository {
    private val gameStateMap: MutableMap<Long, GameState> = mutableMapOf()

    fun save(roomId: Long, gameState: GameState): GameState {
        gameStateMap[roomId] = gameState
        return gameState
    }

    fun findByRoomId(roomId: Long): GameState? {
        return gameStateMap[roomId]
    }

    fun deleteByRoomId(roomId: Long) {
        gameStateMap.remove(roomId)
    }
}