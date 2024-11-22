package com.elice.gameservice.presentation.room.dto

data class CreateRoomRequestDto(
    val subject: String,
    val memberLimit: Int,
    val explanationSecond: Long
)
