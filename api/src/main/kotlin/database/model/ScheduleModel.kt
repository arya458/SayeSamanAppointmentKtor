package com.sayesamanappointmentbookingsystem.database.model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleModel(
    val scheduleid : Int,
    val woekerid : String,
    val title: String,
    val scheduledate: String,
    val scheduletime: String,
    val nop: Int,
)