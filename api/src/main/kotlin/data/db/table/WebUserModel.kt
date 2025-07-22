package com.sayesamanappointmentbookingsystem.data.db.table


import com.sayesamanappointmentbookingsystem.database.model.WebUserModel
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column


// 1. Correct Table Definition for WebUser
object WebUserTable : IntIdTable("WebUser") { // Table name in the database
    val email: Column<String> = varchar("email", 191).uniqueIndex() // email should be unique and non-nullable
    val usertype: Column<String?> = char("usertype", 1).nullable() // usertype is nullable
}

// 2. Correct DAO Definition for WebUser
class WebUserDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<WebUserDAO>(WebUserTable)

    // Delegate properties to the columns defined in WebUserTable
    var email by WebUserTable.email
    var usertype by WebUserTable.usertype
}

// 4. Correct Mapping Function
fun WebUserDAO.toModel(): WebUserModel = WebUserModel(
    email = email,
    usertype = usertype.toString() // usertype is directly mapped
)