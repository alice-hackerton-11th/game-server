package com.elice.common.exception

import com.elice.common.response.BaseResponseStatus


open class BaseException(val status: BaseResponseStatus) : RuntimeException(status.message)
