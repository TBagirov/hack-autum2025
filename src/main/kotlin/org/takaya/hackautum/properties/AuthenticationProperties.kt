package org.takaya.hackautum.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.auth")
data class AuthenticationProperties(
    val adminCode: String? = null,
    val adminPassword: String,
    val passwordLifeTime: Long,
    val token: TokenProperties,
) {

    data class TokenProperties(
        val accessLifeTime: Long,
        val refreshLifeTime: Long,
        val secret: String,
    )
}
