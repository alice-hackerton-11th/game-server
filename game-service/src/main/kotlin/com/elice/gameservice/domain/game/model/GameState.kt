package com.elice.gameservice.domain.game.model

data class GameState(
    val roomId: Long,
    val members: List<GameMemberInfo>,
    var currentTurnMemberId: Long,
    var roundId: Int
)