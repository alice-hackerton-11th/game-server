package com.elice.gameservice.domain.game.model

data class GameMemberInfo(
    val memberId: Long,
    var isTurn: Boolean,
    var isFinished: Boolean
)
