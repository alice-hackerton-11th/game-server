package com.elice.gameservice.presentation.game.controller

import com.elice.gameservice.application.game.service.GameService
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(
    private val gameService: GameService,
    private val messagingTemplate: SimpMessagingTemplate
) {
    @MessageMapping("/game-start")
    fun startGame(roomId: String) {
        val gameState = gameService.startGame(roomId.toLong())
        messagingTemplate.convertAndSend("/topic/room/$roomId", gameState)
    }

    @MessageMapping("/next-turn")
    fun nextTurn(roomId: String) {
        val gameState = gameService.updateTurn(roomId.toLong())
        messagingTemplate.convertAndSend("/topic/room/$roomId", gameState)
    }
}