package com.elice.gameservice.presentation.member.dto

data class RegisterMemberResponseDto(
    val memberId: Long,
    val accessToken: String
)