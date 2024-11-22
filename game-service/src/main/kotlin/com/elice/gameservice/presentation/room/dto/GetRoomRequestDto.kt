package com.elice.gameservice.presentation.room.dto

import com.elice.gameservice.domain.room.enums.RoomProgressState

data class GetRoomRequestDto(
    val roomId: Long,
    val subject: String,
    val status: RoomProgressState,
    val memberCount: Long,
    val explanationSecond: Long
)