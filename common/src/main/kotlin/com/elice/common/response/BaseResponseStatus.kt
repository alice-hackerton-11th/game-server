package com.elice.common.response

enum class BaseResponseStatus(
    val isSuccess: Boolean,
    val code: Int,
    val message: String
) {
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    AUTHENTICATION_ERROR(false, 4001, "인증 실패입니다.")
}