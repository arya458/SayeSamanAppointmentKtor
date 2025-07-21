package com.sayesamanappointmentbookingsystem.database.model

import kotlinx.serialization.Serializable
import java.sql.Date

@Serializable
data class AppointmentModel(
    val appoid : Int,
    val cid : Int,
    val apponum: Int,
    val scheduleid : Int,
    val appodate: Long,
)