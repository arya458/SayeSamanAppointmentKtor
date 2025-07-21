package com.sayesamanappointmentbookingsystem.domain.repository

import com.sayesamanappointmentbookingsystem.database.model.WebUserModel
import com.sayesamanappointmentbookingsystem.database.repository.WebUserRepository

class WebUserRepositoryImpl : WebUserRepository {
    override fun add(item: WebUserModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(item: WebUserModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun getBy(email: String, usertype: String): WebUserModel {
        TODO("Not yet implemented")
    }

}