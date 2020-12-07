package com.panujaras.beautyclinic.models.response

data class BaseResponse(
    val success: Boolean = false,
    val message: String? = null,
)
