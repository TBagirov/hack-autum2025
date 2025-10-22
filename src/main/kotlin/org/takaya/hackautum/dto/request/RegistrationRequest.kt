package org.takaya.hackautum.dto.request

data class RegistrationRequest(
    val nickname: String,
    val email: String,
    val password: String,
    val fio: String,
)
