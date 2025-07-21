package com.sayesamanappointmentbookingsystem

import com.sayesamanappointmentbookingsystem.data.repository.AdminRepository
import com.sayesamanappointmentbookingsystem.data.repository.CoworkerRepository
import com.sayesamanappointmentbookingsystem.data.repository.WorkerRepository
import com.sayesamanappointmentbookingsystem.database.configureDatabases
import com.sayesamanappointmentbookingsystem.database.repository.*
import com.sayesamanappointmentbookingsystem.domain.repository.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}


fun Application.configureSerialization(
    adminRepository: AdminRepository,
    appointmentRepository: AppointmentRepository,
    coworkerRepository: CoworkerRepository,
    scheduleRepository: ScheduleRepository,
    webUserRepository: WebUserRepository,
    workerRepository: WorkerRepository
) {

    routing {
        get("/404") {
            call.respondText("404")
        }
        post("/login") {
            try {
                val parameters = call.parameters
                val user = parameters["user"]
                val pass = parameters["pass"]
                val token = parameters["token"]
                val webUser = webUserRepository.getBy(user)

                when (webUser.usertype ?: null) {
                    "admin" -> {
                        val temp = adminRepository.login(user!!, pass!!)
                        if (temp!=null) {
                            //valid
                        } else {
                            call.respondRedirect("/login")
                        }
                    }

                    "worker" -> {
                        if (workerRepository.login(user!!, pass!!)) {
                            //valid
                        } else {
                            call.respondRedirect("/login")
                        }
                    }

                    "coworker" -> {
                        if (coworkerRepository.login(user!!, pass!!)) {
                            //valid
                        } else {
                            call.respondRedirect("/login")
                        }
                    }

                    else -> {
                        call.respondRedirect("/404")
                    }
                }
            } catch (e: Exception) {
                call.respondRedirect("/404")
            }
        }
//        route("/tasks") {
//            get("/by/{id}") {
//                val id = call.parameters["id"]
//                if (id == null) {
//                    call.respondRedirect("/404")
//                    return@get
//                }
//                try {
//
//                    if (tasks.isEmpty()) {
//                        call.respond(HttpStatusCode.NotFound)
//                        return@get
//                    }
//                    call.respond(tasks)
//                } catch (ex: IllegalArgumentException) {
//                    call.respond(HttpStatusCode.BadRequest)
//                }
//            }
//
//            post {
//                try {
//                    val task = call.receive<Task>()
//                    repository.addTask(task)
//                    call.respond(HttpStatusCode.NoContent)
//                } catch (ex: IllegalStateException) {
//                    call.respond(HttpStatusCode.BadRequest)
//                } catch (ex: JsonConvertException) {
//                    call.respond(HttpStatusCode.BadRequest)
//                }
//            }
//        }
    }

}

fun Application.module() {
    val adminRepository: AdminRepository = AdminRepositoryImpl()
    val appointmentRepository: AppointmentRepository = AppointmentRepositoryImpl()
    val coworkerRepository: CoworkerRepository = CoworkerRepositoryImpl()
    val scheduleRepository: ScheduleRepository = ScheduleRepositoryImpl()
    val webUserRepository: WebUserRepository = WebUserRepositoryImpl()
    val workerRepository: WorkerRepository = WorkerRepositoryImpl()



    configureSerialization(
        adminRepository,
        appointmentRepository,
        coworkerRepository,
        scheduleRepository,
        webUserRepository,
        workerRepository
    )
    configureDatabases()
    configureRouting()
}


