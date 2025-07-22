package com.sayesamanappointmentbookingsystem.data.repository

import com.sayesamanappointmentbookingsystem.data.model.CoworkerModel
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

    fun login(user:String,pass:String):Boolean
    fun changePass(user:String,pass:String,againPass:String):Boolean
}