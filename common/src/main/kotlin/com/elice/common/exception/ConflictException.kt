package com.elice.common.exception

import com.elice.common.response.BaseResponseStatus

class ConflictException(
    val baseResponseStatus: BaseResponseStatus
) : BaseException(baseResponseStatus)