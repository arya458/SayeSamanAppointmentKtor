package com.sayesamanappointmentbookingsystem.domain.repository

import com.sayesamanappointmentbookingsystem.database.model.SpecialtiesModel
import com.sayesamanappointmentbookingsystem.database.repository.SpecialtiesRepository

class SpecialtiesRepositoryImpl : SpecialtiesRepository {
    override fun add(item: SpecialtiesModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun edit(item: SpecialtiesModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(item: SpecialtiesModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun all(): List<SpecialtiesModel> {
        TODO("Not yet implemented")
    }

    override fun getBy(
        workerid: String?,
        workeremail: String?,
        workername: String?,
        workerpassword: String?,
        workernic: String?,
        workertel: String?,
        specialties: String?
    ): SpecialtiesModel {
        TODO("Not yet implemented")
    }
}