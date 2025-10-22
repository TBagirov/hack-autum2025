package org.takaya.hackautum.dto.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "DTO для создании новой роли")
data class RoleRequest(

    @Schema(description = "название роли")
    val roleName: String,
)
