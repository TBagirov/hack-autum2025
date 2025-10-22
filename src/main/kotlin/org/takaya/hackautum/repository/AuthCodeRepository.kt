package org.takaya.hackautum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.takaya.hackautum.entity.AuthCodeEntity
import org.takaya.hackautum.entity.UserEntity
import java.util.UUID

interface AuthCodeRepository : JpaRepository<AuthCodeEntity, UUID> {

    fun findAuthCodeEntitiesByUserEntity(userEntity: UserEntity): List<AuthCodeEntity>
    fun deleteAuthCodeEntitiesByUserEntity(userEntity: UserEntity)
}
