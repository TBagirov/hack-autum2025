package org.takaya.hackautum.config.authentication

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.takaya.hackautum.properties.Role.ADMIN
import org.takaya.hackautum.repository.UserRepository
import org.takaya.hackautum.service.JwtService
import org.takaya.hackautum.util.exception.UserNotFoundException

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val userRepository: UserRepository,
    private val jwtService: JwtService,
) {

    @Bean
    fun userDetailsService() = UserDetailsService { login: String ->
        userRepository.findByEmail(login)
            ?: throw UserNotFoundException("Пользователь не найден")
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun authenticationProvider(): AuthenticationProvider = DaoAuthenticationProvider().apply {
        setUserDetailsService(userDetailsService())
        setPasswordEncoder(passwordEncoder())
    }

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager =
        authenticationConfiguration.authenticationManager

    @Bean
    fun securityFilterChain(http: HttpSecurity, userDetailsService: UserDetailsService): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .addFilterBefore(
                JwtAuthenticationFilter(userDetailsService, jwtService),
                UsernamePasswordAuthenticationFilter::class.java
            )
            .authorizeHttpRequests { authorizationManagerRequestMatcherRegistry ->
                authorizationManagerRequestMatcherRegistry
                    .requestMatchers("/api/auth/admin/user-info").hasAuthority(ADMIN)
                    .requestMatchers(
                        "/api/auth/user-info",
                    )
                    .authenticated()
                    .anyRequest()
                    .permitAll()
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
        return http.build()
    }
}
