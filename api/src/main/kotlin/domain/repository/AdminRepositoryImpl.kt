package com.sayesamanappointmentbookingsystem.domain.repository

import com.sayesamanappointmentbookingsystem.data.db.table.AdminDAO
import com.sayesamanappointmentbookingsystem.data.db.table.AdminTable
import com.sayesamanappointmentbookingsystem.data.db.table.adminDAOToModel
import com.sayesamanappointmentbookingsystem.data.db.table.suspendTransaction
import com.sayesamanappointmentbookingsystem.data.repository.AdminRepository
import com.sayesamanappointmentbookingsystem.data.model.AdminModel
import org.jetbrains.exposed.sql.and

class AdminRepositoryImpl : AdminRepository {
    override suspend fun login(user: String, pass: String): AdminModel? { // Add 'suspend' and a return type
        return suspendTransaction { // 'return' the result of the transaction
            AdminDAO
                .find { (AdminTable.aemail eq user) and (AdminTable.apassword eq pass) }
                .limit(1) // Important: We expect at most one user for a unique login
                .singleOrNull() // Get the single matching DAO or null if not found
                ?.let(::adminDAOToModel) // Map the DAO to your model if found, otherwise result is null
        }
    }

    override suspend fun changePass(user: String, oldPass: String, newPass: String): AdminModel? {
        return suspendTransaction {
            // 1. Find the AdminDAO instance that matches the user and old password
            val adminDao = AdminDAO
                .find { (AdminTable.aemail eq user) and (AdminTable.apassword eq oldPass) }
                .limit(1)
                .singleOrNull()

            // 2. If an adminDao is found, update its password
            adminDao?.let { dao ->
                dao.apassword = newPass // Update the password field of the DAO
                // The DAO saves changes automatically when its properties are modified within a transaction
                // No explicit 'dao.save()' or 'dao.update()' call is needed for DAO objects
                // However, if you were using plain Exposed SQL DSL (Table.update), you would commit the change.

                // 3. Convert the updated DAO to your AdminModel and return it
                adminDAOToModel(dao)
            }
            // 4. If adminDao is null (no user found or old password didn't match), the 'let' block is skipped,
            // and 'null' will be implicitly returned.
        }
    }
}