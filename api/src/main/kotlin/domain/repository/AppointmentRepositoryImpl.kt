package com.sayesamanappointmentbookingsystem.domain.repository

import com.sayesamanappointmentbookingsystem.data.model.AppointmentModel
import com.sayesamanappointmentbookingsystem.database.repository.AppointmentRepository

class AppointmentRepositoryImpl: AppointmentRepository {
    override fun add(item: AppointmentModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun edit(item: AppointmentModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(item: AppointmentModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun all(): List<AppointmentModel> {
        TODO("Not yet implemented")
    }

    override fun getBy(appoid: Int?, cid: Int?, apponum: Int?, scheduleid: Int?, appodate: Long?): AppointmentModel {
        TODO("Not yet implemented")
    }

}