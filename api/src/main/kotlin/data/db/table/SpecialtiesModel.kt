package com.sayesamanappointmentbookingsystem.data.db.table

import com.sayesamanappointmentbookingsystem.database.model.SpecialtiesModel
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

// 1. Correct Table Definition for Specialties
object SpecialtiesTable : IntIdTable("Specialties") { // Table name in the database
    val sname: Column<String> = varchar("sname", 50)
    val bookingdailylimit: Column<Int> = integer("bookingdailylimit").default(0)
}

// 2. Correct DAO Definition for Specialties
class SpecialtiesDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SpecialtiesDAO>(SpecialtiesTable)

    // Delegate properties to the columns defined in SpecialtiesTable
    var sname by SpecialtiesTable.sname
    var bookingdailylimit by SpecialtiesTable.bookingdailylimit
}

// 4. Correct Mapping Function
fun SpecialtiesDAO.toModel(): SpecialtiesModel = SpecialtiesModel(
    id = id.value, // Access the actual Int value of the EntityID
    sname = sname,
    bookingdailylimit = bookingdailylimit
)