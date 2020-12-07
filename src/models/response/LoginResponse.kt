package com.panujaras.beautyclinic.models.response

data class LoginResponse(
    var success: Boolean = false,
    var message: String? = null,
    var data: String? = null,
)
