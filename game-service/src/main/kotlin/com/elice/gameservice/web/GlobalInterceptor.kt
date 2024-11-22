package com.elice.gameservice.web

import com.elice.common.exception.AuthenticationException
import com.elice.common.response.BaseResponseStatus
import com.elice.common.token.TokenProvider
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class GlobalInterceptor(
    private val tokenProvider: TokenProvider
) : HandlerInterceptor {
    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        val token = request.getHeader("Authorization")?.let { extractToken(it) }

        if (token.isNullOrEmpty()) {
            throw AuthenticationException(BaseResponseStatus.AUTHENTICATION_ERROR)
        }

        try {
            tokenProvider.verifyToken(token)
            val memberId = tokenProvider.decodeToken(token).getClaim("id").asLong()
            request.setAttribute("memberId", memberId)
        } catch (ex: Exception) {
            print(ex)
            throw AuthenticationException(BaseResponseStatus.AUTHENTICATION_ERROR)
        }

        return true
    }

    private fun extractToken(header: String): String? {
        return header.takeIf { it.startsWith("Bearer ") }?.removePrefix("Bearer ")?.trim()
    }
}