package org.takaya.hackautum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.takaya.hackautum.properties.AuthenticationProperties

@SpringBootApplication
@EnableConfigurationProperties(
    AuthenticationProperties::class
)
class HackAutumApplication

fun main(args: Array<String>) {
    runApplication<HackAutumApplication>(*args)
}
