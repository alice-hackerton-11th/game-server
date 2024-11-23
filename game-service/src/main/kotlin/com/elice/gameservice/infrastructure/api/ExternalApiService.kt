package com.elice.gameservice.infrastructure.api

import com.elice.common.exception.NotFoundException
import com.elice.common.response.BaseResponseStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ExternalApiService(
    private var restTemplate: RestTemplate
) {
    fun <T> sendPostRequest(url: String, requestPayload: Any, responseType: Class<T>): T {
        return restTemplate.postForObject(url, requestPayload, responseType)
            ?: throw NotFoundException(BaseResponseStatus.NOT_FOUND_API_RESPONSE)
    }
}