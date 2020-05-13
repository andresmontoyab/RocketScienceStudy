package pattern.chainofresponsability.secondapproach.handlers

import pattern.chainofresponsability.secondapproach.Context
import pattern.chainofresponsability.secondapproach.Handler

class RegistrationHandler: Handler {
    override val handlerName: String
        get() = "Registration Handler"

    override fun execute(context: Context) {
        println("The Registration Handler Just Begin")
        context.mapToUpdate.put(handlerName, "Registration Action Finish")
        println("The Registration Handler Just Finish")
    }

}