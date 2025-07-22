package com.sayesamanappointmentbookingsystem.data.repository

import com.sayesamanappointmentbookingsystem.database.model.SpecialtiesModel
import com.sayesamanappointmentbookingsystem.database.model.WorkerModel

interface WorkerRepository {

    fun add(item: WorkerModel):Boolean
    fun edit(item: WorkerModel):Boolean
    fun delete(item: WorkerModel):Boolean
    fun all():List<WorkerModel>
    fun getBy(
        id : Int?,
        sname: String?,
        bookingdailylimit: Int?,
    ): WorkerModel
    fun login(user:String,pass:String):Boolean
    fun changePass(user:String,pass:String,againPass:String):Boolean
}