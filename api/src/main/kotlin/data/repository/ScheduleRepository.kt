package com.sayesamanappointmentbookingsystem.database.repository

import com.sayesamanappointmentbookingsystem.data.model.ScheduleModel

interface ScheduleRepository {
    fun add(item: ScheduleModel):Boolean
    fun edit(item: ScheduleModel):Boolean
    fun delete(item: ScheduleModel):Boolean
    fun all():List<ScheduleModel>
    fun getBy(
        scheduleid : Int?,
        woekerid : String?,
        title: String?,
        scheduledate: String?,
        scheduletime: String?,
        nop: Int?,
    ): ScheduleModel
}