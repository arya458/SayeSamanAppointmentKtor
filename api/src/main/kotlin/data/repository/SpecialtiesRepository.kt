package com.sayesamanappointmentbookingsystem.database.repository

import com.sayesamanappointmentbookingsystem.database.model.SpecialtiesModel

interface SpecialtiesRepository {
    fun add(item: SpecialtiesModel):Boolean
    fun edit(item: SpecialtiesModel):Boolean
    fun delete(item: SpecialtiesModel):Boolean
    fun all():List<SpecialtiesModel>
    fun getBy(
        workerid : String?,
        workeremail: String?,
        workername: String?,
        workerpassword: String?,
        workernic: String?,
        workertel: String?,
        specialties : String?,
    ): SpecialtiesModel
}