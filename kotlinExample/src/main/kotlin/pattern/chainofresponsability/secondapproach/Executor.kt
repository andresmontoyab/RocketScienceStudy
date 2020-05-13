package pattern.chainofresponsability.secondapproach

import pattern.chainofresponsability.secondapproach.handlers.BuyHandler
import pattern.chainofresponsability.secondapproach.handlers.LoginHandler
import pattern.chainofresponsability.secondapproach.handlers.RegistrationHandler


fun main() {
    val registrationHandler:Handler = RegistrationHandler()
    val loginHandler:Handler = LoginHandler()
    val buyHandler:Handler = BuyHandler()
    val context:Context = Context()
    val handlers = listOf<Handler>(registrationHandler, loginHandler, buyHandler)
    println("The chain has started")
    handlers.forEach {
        handler -> handler.execute(context)
    }
    println("The chain has ended")
    context.mapToUpdate.forEach { key, value ->
        println("The handler $key has done the $value ")
    }
}