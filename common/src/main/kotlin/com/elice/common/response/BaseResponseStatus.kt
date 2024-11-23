package com.elice.common.response

enum class BaseResponseStatus(
    val isSuccess: Boolean,
    val code: Int,
    val message: String
) {
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    AUTHENTICATION_ERROR(false, 4001, "인증 실패입니다."),

    NOT_FOUND_ROOM(false, 4100, "존재하지 않는 방입니다."),
    NOT_FOUND_ROOM_USER(false, 4101, "방에 멤버가 존재하지 않습니다."),
    NOT_FOUND_GAME_STATE(false, 4102, "게임 진행 상태가 존재하지 않습니다."),

    EXCEED_MEMBER_LIMIT(false, 4300, "제한 인원보다 많습니다."),
}