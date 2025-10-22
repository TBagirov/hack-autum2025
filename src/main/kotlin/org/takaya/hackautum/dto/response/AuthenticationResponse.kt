package org.takaya.hackautum.dto.response

import org.takaya.hackautum.dto.User

data class AuthenticationResponse(
    val message: String? = null,
    val token: String? = null,
    val user: User,
)
