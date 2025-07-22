package com.sayesamanappointmentbookingsystem.database.repository

import com.sayesamanappointmentbookingsystem.data.model.AppointmentModel

interface AppointmentRepository {
    fun add(item: AppointmentModel):Boolean
    fun edit(item: AppointmentModel):Boolean
    fun delete(item: AppointmentModel):Boolean
    fun all():List<AppointmentModel>
    fun getBy(
        appoid : Int?,
        cid : Int?,
        apponum: Int?,
        scheduleid : Int?,
        appodate: Long?,
    ): AppointmentModel
}