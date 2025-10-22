package org.takaya.hackautum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.takaya.hackautum.entity.UserEntity
import java.util.*

interface UserRepository : JpaRepository<UserEntity, UUID> {
    fun findByEmail(email: String): UserEntity?
    fun findAllByEmail(email: String): List<UserEntity>
}
