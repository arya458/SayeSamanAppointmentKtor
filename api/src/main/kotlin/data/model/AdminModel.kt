package com.sayesamanappointmentbookingsystem.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AdminModel(
    val aemail: String,
    val apassword: String,
)