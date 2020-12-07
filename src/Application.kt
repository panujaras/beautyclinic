package com.panujaras.beautyclinic

import com.panujaras.beautyclinic.route.hello
import com.panujaras.beautyclinic.route.login
import com.panujaras.beautyclinic.route.register
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)

    install(ContentNegotiation) {
        gson {
        }
    }

    install(Routing){
        hello()
        login()
        register()
    }

}

