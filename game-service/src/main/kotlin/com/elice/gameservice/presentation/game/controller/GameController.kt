package com.elice.gameservice.presentation.game.controller

import com.elice.gameservice.application.game.service.GameService
import com.elice.gameservice.domain.game.model.GameState
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(
    private val gameService: GameService
) {
    @SendTo("/topic/room/{roomId}")
    @MessageMapping("/game-start")
    fun startGame(roomId: Long): GameState {
        return gameService.startGame(roomId)
    }
}