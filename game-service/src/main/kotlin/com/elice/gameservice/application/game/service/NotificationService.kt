package com.elice.gameservice.application.game.service

import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val messagingTemplate: SimpMessagingTemplate
) {
    fun sendNotificationToRoom(roomId: Long, message: String) {
        val destination = "/topic/room/$roomId/message"
        messagingTemplate.convertAndSend(destination, message)
    }
}