package com.sayesamanappointmentbookingsystem.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory

fun Application.configureDatabases() {
    // 1. Configure HikariCP (Connection Pool)
    // It's highly recommended to use a connection pool like HikariCP for production.
    // The database URL, user, and password should ideally come from Ktor's application.conf
    val config = HikariConfig().apply {
        jdbcUrl = environment.config.property("storage.jdbcURL").getString()
        username = environment.config.property("storage.user").getString()
        password = environment.config.property("storage.password").getString()
        driverClassName = "com.mysql.cj.jdbc.Driver" // MySQL JDBC Driver class
        maximumPoolSize = 10 // Max number of connections in the pool
        isAutoCommit = false // Exposed manages transactions, so disable auto-commit
        transactionIsolation = "TRANSACTION_REPEATABLE_READ" // Or another appropriate isolation level
        validate()
    }
    val dataSource = HikariDataSource(config)

    // 2. Connect Exposed to the DataSource
    Database.connect(dataSource)

    // 3. Create Tables (Optional, good for development, but manage migrations in production)
    transaction {
        // Example: Create the 'Users' table if it doesn't exist
        // SchemaUtils.create(Users)
        log.info("Database connection established and tables created (if configured).")
    }

    // You can also add a hook to close the data source when the application stops
    environment.monitor.subscribe(ApplicationStopping) {
        dataSource.close()
        log.info("Database connection pool closed.")
    }
}
