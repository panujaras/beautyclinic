package com.panujaras.beautyclinic.models.request

data class RegisterRequest(
    val name: String? = null,
    val address: String? = null,
    val tle: String? = null,
    val email: String? = null,
)
