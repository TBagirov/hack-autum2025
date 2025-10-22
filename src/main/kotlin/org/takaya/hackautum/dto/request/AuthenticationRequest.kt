package org.takaya.hackautum.dto.request

data class AuthenticationRequest(
    val login: String,
    val password: String,
)
