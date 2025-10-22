package org.takaya.hackautum.util.exception

class UserNotFoundException(message: String = "User not found") : AuthenticationException(message)
