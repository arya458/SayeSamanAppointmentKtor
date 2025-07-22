package com.sayesamanappointmentbookingsystem.data.db.table

import kotlinx.serialization.Serializable

@Serializable
data class WorkerModel(
    val workerid : String,
    val workeremail: String,
    val workername: String,
    val workerpassword: String,
    val workernic: String,
    val workertel: String,
    val specialties : String,
    )