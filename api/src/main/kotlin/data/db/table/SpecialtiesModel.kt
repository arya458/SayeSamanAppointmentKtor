package com.sayesamanappointmentbookingsystem.data.db.table

import kotlinx.serialization.Serializable

@Serializable
data class SpecialtiesModel(
    val id : Int,
    val sname: String,
    val bookingdailylimit: Int,
)