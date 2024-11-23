package com.elice.gameservice.domain.game.model

data class GameState(
    val roomId: Long,
    val members: List<GameMemberInfo>,
    var currentTurnMemberId: Long,
    var roundId: Int
) {
    fun currentTurnIndex(): Int {
        return members.indexOfFirst { it.isTurn }
    }

    fun updateRound() {
        roundId++;
        members.forEachIndexed { index, gameMemberInfo ->
            gameMemberInfo.isTurn = index == 0
            gameMemberInfo.isFinished = false
        }
    }

    fun updateTurn() {
        val currentTurnIndex = currentTurnIndex()
        val nextTurnIndex = generateSequence((currentTurnIndex + 1) % members.size) { (it + 1) % members.size }
            .first { members[it].heart > 0 }
        members.forEachIndexed { index, gameMemberInfo ->
            gameMemberInfo.apply {
                isTurn = index == nextTurnIndex
                isFinished = index == currentTurnIndex
            }
        }
        currentTurnMemberId = members[nextTurnIndex].memberId
    }
}