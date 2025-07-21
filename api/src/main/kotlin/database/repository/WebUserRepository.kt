package com.sayesamanappointmentbookingsystem.database.repository

import com.sayesamanappointmentbookingsystem.database.model.SpecialtiesModel
import com.sayesamanappointmentbookingsystem.database.model.WebUserModel

interface WebUserRepository {
    fun add(item: WebUserModel):Boolean
    fun delete(item: WebUserModel):Boolean
    fun getBy(
        email : String? = null,
        usertype: String? = null,
    ): WebUserModel
}