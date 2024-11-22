package com.elice.gameservice.config

import com.elice.gameservice.web.GlobalInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig(private val globalInterceptor: GlobalInterceptor) : WebMvcConfigurer {
    val excludePaths = mutableListOf(
        "/member"
    )

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(globalInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns(excludePaths)
    }
}