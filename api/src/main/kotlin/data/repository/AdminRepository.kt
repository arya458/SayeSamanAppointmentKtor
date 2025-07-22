package com.sayesamanappointmentbookingsystem.data.repository

import com.sayesamanappointmentbookingsystem.data.model.AdminModel

interface AdminRepository {
    suspend fun login(user:String,pass:String): AdminModel?
    suspend fun changePass(user:String,oldPass:String,newPass:String): AdminModel?
}