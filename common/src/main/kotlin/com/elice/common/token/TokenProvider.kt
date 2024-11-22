package com.elice.common.token

import com.auth0.jwt.JWT
import com.auth0.jwt.JWT.decode
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenProvider(
    @Value("\${jwt.secret}") private val jwtSecret: String
) {
    fun verifyToken(jwtToken: String) {
        JWT.require(com.auth0.jwt.algorithms.Algorithm.HMAC512(jwtSecret))
            .build()
            .verify(jwtToken)
    }

    fun decodeToken(jwtToken: String): DecodedJWT {
        return decode(jwtToken)
    }

    fun createAccessToken(id: Long): String {
        return JWT.create()
            .withClaim("id", id)
            .sign(com.auth0.jwt.algorithms.Algorithm.HMAC512(jwtSecret))
    }
}