package com.panujaras.beautyclinic.route

import com.panujaras.beautyclinic.models.BaseResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.hello() {

    get("/api/auth/hello") {
        val response = BaseResponse(true, "hello")
        call.respond(response)
    }

}
