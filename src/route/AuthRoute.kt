package com.panujaras.beautyclinic.route

import com.panujaras.beautyclinic.models.request.LoginRequest
import com.panujaras.beautyclinic.models.response.BaseResponse
import com.panujaras.beautyclinic.models.response.LoginResponse
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.hello() {

    get("/api/auth/hello") {
        val username = call.parameters["username"]
        val password = call.parameters["password"]
        val response = BaseResponse(true, "hello $username, $password")
        call.respond(response)
    }

}

fun Route.login(){

    post("/api/auth/login") {
        val login = call.receive<LoginRequest>()

        val data = "${login.username}, ${login.password}"
        val response = LoginResponse(data)

        call.respond(response)
    }

}
