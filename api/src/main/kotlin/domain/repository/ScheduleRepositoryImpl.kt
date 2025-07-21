package com.sayesamanappointmentbookingsystem.domain.repository

import com.sayesamanappointmentbookingsystem.data.model.ScheduleModel
import com.sayesamanappointmentbookingsystem.database.repository.ScheduleRepository

class ScheduleRepositoryImpl : ScheduleRepository {
    override fun add(item: ScheduleModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun edit(item: ScheduleModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(item: ScheduleModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun all(): List<ScheduleModel> {
        TODO("Not yet implemented")
    }

    override fun getBy(
        scheduleid: Int?,
        woekerid: String?,
        title: String?,
        scheduledate: String?,
        scheduletime: String?,
        nop: Int?
    ): ScheduleModel {
        TODO("Not yet implemented")
    }

}