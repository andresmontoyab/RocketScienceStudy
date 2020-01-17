package pattern.chainofresponsability.firstapproach

import pattern.chainofresponsability.firstapproach.handlers.RegistrationHandler

/**
 * Chain Of Responsability Pattern - Behavior pattern
 * 1. Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request
 * 2. Launch-and-leave requests with a single processing pipeline that contains many possible handlers
 */

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