package com.sayesamanappointmentbookingsystem.database.repository

import com.sayesamanappointmentbookingsystem.database.model.coworker.CoworkerShowModel

interface AdminRepository {
    fun login(user:String,pass:String)
    fun changePass(user:String,pass:String,againPass:String)

}