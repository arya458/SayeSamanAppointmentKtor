package com.sayesamanappointmentbookingsystem.data.db.table

import com.sayesamanappointmentbookingsystem.data.model.AppointmentModel
import com.sayesamanappointmentbookingsystem.data.model.CoworkerModel
import com.sayesamanappointmentbookingsystem.data.model.ScheduleModel
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.dao.id.IntIdTable


// 1. Correct Table Definition for Doctor
object CoworkerTable : IntIdTable("coworker") { // Table name in the database
    val coworkeremail: Column<String?> = varchar("coworkeremail", 255).nullable() // Assuming nullable based on schema
    val coworkername: Column<String?> = varchar("coworkername", 255).nullable()
    val coworkerpassword: Column<String?> = varchar("coworkerpassword", 255).nullable()
    val coworkeraddress: Column<String?> = varchar("coworkeraddress", 255).nullable()
    val coworkernic: Column<String?> = varchar("coworkernic", 15).nullable()
    val coworkerdob: Column<String?> = varchar("coworkerdob", 15).nullable()
    val coworkertel: Column<String?> = varchar("coworkertel", 15).nullable()
    val specialties: Column<Int?> = integer("specialties").nullable() // int(2) maps to Exposed's integer()
}

// 2. Correct DAO Definition for Doctor
class CoworkerDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CoworkerDAO>(CoworkerTable)

    // Delegate properties to the columns defined in DoctorTable
    var coworkeremail by CoworkerTable.coworkeremail
    var coworkername by CoworkerTable.coworkername
    var coworkerpassword by CoworkerTable.coworkerpassword
    var coworkeraddress by CoworkerTable.coworkeraddress
    var coworkernic by CoworkerTable.coworkernic
    var coworkerdob by CoworkerTable.coworkerdob
    var coworkertel by CoworkerTable.coworkertel
    var specialties by CoworkerTable.specialties
}

fun CoworkerDAO.toModel(): CoworkerModel = CoworkerModel(
    coworkerid = id.value, // Access the actual Int value of the EntityID
    coworkeremail = coworkeremail,
    coworkername = coworkername,
    coworkerpassword = coworkerpassword,
    coworkeraddress =coworkeraddress,
    coworkernic = coworkernic,
    coworkerdob = coworkerdob,
    coworkertel = coworkertel,
    specialties = specialties
)