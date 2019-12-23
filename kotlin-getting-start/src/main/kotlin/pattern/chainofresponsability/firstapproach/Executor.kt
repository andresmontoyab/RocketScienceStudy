package pattern.chainofresponsability.firstapproach

import pattern.chainofresponsability.firstapproach.handlers.RegistrationHandler

fun main() {
    val registrationHandler:Handler = RegistrationHandler()
    val context:Context = Context()
    println("The chain has started")
    registrationHandler.execute(context)
    println("The chain has ended")
    context.mapToUpdate.forEach { key, value ->
        println("The handler $key has done the $value ")
    }
}