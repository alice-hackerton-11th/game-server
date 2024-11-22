package com.elice.gameservice.config

import com.elice.gameservice.web.GlobalInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
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

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOriginPattern("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}