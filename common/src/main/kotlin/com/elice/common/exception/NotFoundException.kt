package com.elice.common.exception

import com.elice.common.response.BaseResponseStatus

class NotFoundException(
    val baseResponseStatus: BaseResponseStatus
) : BaseException(baseResponseStatus)