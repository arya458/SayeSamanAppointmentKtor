package com.sayesamanappointmentbookingsystem.database.repository

import com.sayesamanappointmentbookingsystem.database.model.AppointmentModel
import com.sayesamanappointmentbookingsystem.database.model.coworker.CoworkerModel
import com.sayesamanappointmentbookingsystem.database.model.coworker.CoworkerShowModel

interface CoworkerRepository {
    fun add(item: CoworkerModel):Boolean
    fun edit(item: CoworkerShowModel):Boolean
    fun delete(item: CoworkerShowModel):Boolean
    fun all():List<CoworkerShowModel>
    fun getBy(
        appoid : Int?,
        cid : Int?,
        apponum: Int?,
        scheduleid : Int?,
        appodate: Long?,
    ): CoworkerShowModel

    fun login(user:String,pass:String)
    fun changePass(user:String,pass:String,againPass:String)
}