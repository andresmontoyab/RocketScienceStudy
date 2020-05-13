package pattern.chainofresponsability.firstapproach.handlers

import pattern.chainofresponsability.firstapproach.Context
import pattern.chainofresponsability.firstapproach.Handler

class RegistrationHandler: Handler {
    override val handlerName: String
        get() = "Registration Handler"

    override var next: Handler? = LoginHandler()

    override fun execute(context: Context) {
        println("The Registration Handler Just Begin")
        context.mapToUpdate.put(handlerName, "Registration Action Finish")
        println("The Registration Handler Just Finish")
        next?.execute(context)
    }

}