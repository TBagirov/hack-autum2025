package org.takaya.hackautum.dto

import java.time.LocalDateTime

data class User(
    val id: String,
    val email: String,
    val nickname: String,
    val fio: String,
    val createdAt: LocalDateTime,
    val role: String
)
