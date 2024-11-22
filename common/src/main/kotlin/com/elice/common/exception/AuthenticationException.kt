package com.elice.common.exception

import com.elice.common.response.BaseResponseStatus

class AuthenticationException(
    val baseResponseStatus: BaseResponseStatus
) : BaseException(baseResponseStatus)