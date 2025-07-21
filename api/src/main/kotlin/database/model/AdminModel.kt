package com.sayesamanappointmentbookingsystem.database.model

import kotlinx.serialization.Serializable

@Serializable
data class AdminModel(
    val aemail: String,
    val apassword: String,
)