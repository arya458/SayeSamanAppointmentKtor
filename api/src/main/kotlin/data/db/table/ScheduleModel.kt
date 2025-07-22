package com.sayesamanappointmentbookingsystem.data.db.table

import com.sayesamanappointmentbookingsystem.data.model.ScheduleModel
import kotlinx.datetime.LocalDate
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.date

// 1. Correct Table Definition for Schedule
object ScheduleTable : IntIdTable("schedule") { // Table name in the database
    val coworkerid: Column<String?> = varchar("docid", 255).nullable()
    val title: Column<String?> = varchar("title", 255).nullable()
    val scheduledate: Column<LocalDate?> = date("scheduledate").nullable() // Changed to LocalDate for date type
    val nop: Column<Int?> = integer("nop").nullable() // int(4) maps to Exposed's integer()
}

// 2. Correct DAO Definition for Schedule
class ScheduleDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ScheduleDAO>(ScheduleTable)

    // Delegate properties to the columns defined in ScheduleTable
    var coworkerid by ScheduleTable.coworkerid
    var title by ScheduleTable.title
    var scheduledate by ScheduleTable.scheduledate
    var nop by ScheduleTable.nop
}

// 4. Correct Mapping Function
fun ScheduleDAO.toModel(): ScheduleModel = ScheduleModel(
    scheduleid = id.value, // Access the actual Int value of the EntityID
    coworkerid = coworkerid,
    title = title,
    scheduledate = scheduledate.toString(),
    nop = nop
)