package com.sayesamanappointmentbookingsystem.data.db.table


import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

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

// 1. Correct Table Definition for WebUser
object WorkerTable : IntIdTable("Worker") { // Table name in the database
    val email: Column<String> = varchar("email", 191).uniqueIndex() // email should be unique and non-nullable
    val usertype: Column<String?> = char("usertype", 1).nullable() // usertype is nullable
}

// 2. Correct DAO Definition for Worker
class WorkerDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<WorkerDAO>(WorkerTable)

    // Delegate properties to the columns defined in WorkerTable
    var email by WorkerTable.email
    var usertype by WorkerTable.usertype
}

// 4. Correct Mapping Function
fun WorkerDAO.toModel(): WorkerModel = WorkerModel(
    email = email,
    usertype = usertype.toString() // usertype is directly mapped
)