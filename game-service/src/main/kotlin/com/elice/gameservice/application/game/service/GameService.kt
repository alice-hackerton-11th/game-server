package com.elice.gameservice.application.game.service

import com.elice.common.exception.NotFoundException
import com.elice.common.response.BaseResponseStatus
import com.elice.gameservice.domain.game.model.GameMemberInfo
import com.elice.gameservice.domain.game.model.GameState
import com.elice.gameservice.domain.game.store.GameStore
import com.elice.gameservice.domain.room.store.RoomStore
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class GameService(
    private val gameStore: GameStore,
    private val roomStore: RoomStore
) {
    @Transactional
    fun startGame(roomId: Long): GameState {
        val room = roomStore.findRoomById(roomId) ?: throw NotFoundException(BaseResponseStatus.NOT_FOUND_ROOM)
        val members = roomStore.findAllRoomMember(room).mapIndexed { index, roomMember ->
            GameMemberInfo(memberId = roomMember.memberId, isTurn = index == 0, isFinished = false)
        }
        val gameState = GameState(
            roomId = roomId,
            members = members,
            currentTurnMemberId = members.first().memberId,
            roundId = 1
        )
        return gameStore.saveGameState(gameState)
    }
}