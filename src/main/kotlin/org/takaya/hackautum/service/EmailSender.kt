package org.takaya.hackautum.service

interface EmailSender {
    fun sendPassCodeMessage(to: String, passCode: String)
}
