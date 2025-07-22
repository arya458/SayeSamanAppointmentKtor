package com.sayesamanappointmentbookingsystem.data.db.table

import kotlinx.serialization.Serializable

@Serializable
data class WebUserModel(
    val email : String,
    val usertype: String,
    )