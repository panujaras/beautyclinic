package com.panujaras.beautyclinic.models.response

data class BaseResponse(
    var success: Boolean = false,
    var message: String? = null,
)
