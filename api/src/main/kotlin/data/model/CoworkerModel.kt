package com.sayesamanappointmentbookingsystem.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CoworkerModel(
    val coworkerid : Int?,
    val coworkeremail: String?,
    val coworkername: String?,
    val coworkerpassword: String?,
    val coworkeraddress: String?,
    val coworkernic: String?,
    val coworkerdob: String?,
    val coworkertel: String?,
    val specialties: Int?,
)