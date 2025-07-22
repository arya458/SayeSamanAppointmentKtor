package com.sayesamanappointmentbookingsystem.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ScheduleModel(
    val scheduleid : Int,
    val coworkerid : String?,
    val title: String?,
    val scheduledate: String?,
    val nop: Int?,
)