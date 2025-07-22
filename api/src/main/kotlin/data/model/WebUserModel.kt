package com.sayesamanappointmentbookingsystem.database.model

import kotlinx.serialization.Serializable

@Serializable
data class WebUserModel(
    val email : String,
    val usertype: String,
    )