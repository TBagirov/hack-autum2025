package org.takaya.hackautum.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.takaya.hackautum.entity.RoleEntity
import java.util.UUID

@Repository
interface RoleRepository : JpaRepository<RoleEntity, UUID> {
    fun findByName(name: String): RoleEntity?
}
