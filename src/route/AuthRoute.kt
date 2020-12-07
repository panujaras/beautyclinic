package com.panujaras.beautyclinic.route

import com.panujaras.beautyclinic.models.request.LoginRequest
import com.panujaras.beautyclinic.models.request.RegisterRequest
import com.panujaras.beautyclinic.models.response.BaseResponse
import com.panujaras.beautyclinic.models.response.LoginResponse
import com.panujaras.beautyclinic.models.response.RegisterResponse
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

fun Route.login() {

    post("/api/auth/login") {
        val login = call.receive<LoginRequest>()
        val response = LoginResponse()

        when {
            login.username.isNullOrBlank() -> response.message = "username null"
            login.password.isNullOrBlank() -> response.message = "password null"
            login.username.length < 4 -> response.message = "please enter username >= 4"
            login.password.length < 4 -> response.message = "please enter password >= 4"
            else -> {
                response.success = true
                response.message = "Login success"
            }
        }

        call.respond(response)
    }
}

fun Route.register() {
    post("/api/auth/register") {
        val register = call.receive<RegisterRequest>()
        val response = RegisterResponse()

        when {
            register.name.isNullOrBlank() -> response.message = "name null"
            register.address.isNullOrBlank() -> response.message = "address null"
            register.tle.isNullOrBlank() -> response.message = "tle null"
            register.email.isNullOrBlank() -> response.message = "email null"
            register.tle.length != 10 -> response.message = "please enter tle >= 10"
            register.tle.subSequence(0, 2) !in arrayOf("06", "08", "09") -> response.message = "telephone incorrect"
            // email
            else -> {
                response.success = true
                response.message = "register success"
            }
        }
        call.respond(response)
    }
}
