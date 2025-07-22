package com.sayesamanappointmentbookingsystem.data.db.table

import com.sayesamanappointmentbookingsystem.data.model.AppointmentModel
import com.sayesamanappointmentbookingsystem.data.model.CoworkerModel
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.date // For LocalDate support

object AppointmentTable : IntIdTable("appointment") {
    val cid: Column<Int?> = integer("pid").nullable()
    val apponum: Column<Int?> = integer("apponum").nullable()
    val scheduleid: Column<Int?> = integer("scheduleid").nullable()
    val appodate: Column<kotlinx.datetime.LocalDate> = date("appodate")
}

class AppointmentDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AppointmentDAO>(AppointmentTable)

    var cid by AppointmentTable.cid
    var apponum by AppointmentTable.apponum
    var scheduleid by AppointmentTable.scheduleid
    var appodate by AppointmentTable.appodate
}


fun AppointmentDAO.toModel(): AppointmentModel = AppointmentModel(
    cid,
    apponum,
    scheduleid,
    appodate.toString()
)
