package com.sayesamanappointmentbookingsystem.domain.repository

import com.sayesamanappointmentbookingsystem.data.model.CoworkerModel
import com.sayesamanappointmentbookingsystem.database.model.coworker.CoworkerShowModel
import com.sayesamanappointmentbookingsystem.data.repository.CoworkerRepository

class CoworkerRepositoryImpl : CoworkerRepository {
    override fun add(item: CoworkerModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun edit(item: CoworkerShowModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(item: CoworkerShowModel): Boolean {
        TODO("Not yet implemented")
    }

    override fun all(): List<CoworkerShowModel> {
        TODO("Not yet implemented")
    }

    override fun getBy(appoid: Int?, cid: Int?, apponum: Int?, scheduleid: Int?, appodate: Long?): CoworkerShowModel {
        TODO("Not yet implemented")
    }

    override fun login(user: String, pass: String) {
        TODO("Not yet implemented")
    }

    override fun changePass(user: String, pass: String, againPass: String) {
        TODO("Not yet implemented")
    }

}