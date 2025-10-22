package org.takaya.hackautum.util

import org.takaya.hackautum.dto.User
import org.takaya.hackautum.dto.response.RoleResponse
import org.takaya.hackautum.entity.RoleEntity
import org.takaya.hackautum.entity.UserEntity

fun UserEntity.toUser() = User(
    id = id.toString(),
    nickname = nickname,
    fio = fio,
    email = email,
    createdAt = createdAt,
    role = role.name,
)

fun RoleEntity.convertToResponseEventDto() = RoleResponse(
    id = this.id!!,
    name = this.name
)
