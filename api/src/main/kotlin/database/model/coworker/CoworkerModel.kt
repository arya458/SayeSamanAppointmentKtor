package com.sayesamanappointmentbookingsystem.database.model.coworker

import kotlinx.serialization.Serializable

@Serializable
data class CoworkerModel(
    val cid : Int,
    val cemail: String,
    val cname: String,
    val cpassword: String,
    val caddress: String,
    val cnic: String,
    val cdob: String,
    val ctel: String,
)