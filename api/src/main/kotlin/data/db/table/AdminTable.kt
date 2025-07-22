package com.sayesamanappointmentbookingsystem.data.db.table

import com.sayesamanappointmentbookingsystem.data.model.AdminModel
import com.sayesamanappointmentbookingsystem.data.model.AppointmentModel
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object AdminTable: IntIdTable("admin") {
    val aemail= varchar("aemail",191)
    val apassword= varchar("apassword",255)
}
class AdminDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AdminDAO>(AdminTable)

    var aemail by AdminTable.aemail
    var apassword by AdminTable.apassword
}

fun AdminDAO.toModel(): AdminModel = AdminModel(
    aemail,
    aemail,
)

suspend fun <T> suspendTransaction(block: Transaction.() -> T): T =
    newSuspendedTransaction(Dispatchers.IO, statement = block)

