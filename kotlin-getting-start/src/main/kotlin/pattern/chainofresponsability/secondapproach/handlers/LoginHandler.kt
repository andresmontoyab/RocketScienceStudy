package pattern.chainofresponsability.secondapproach.handlers

import pattern.chainofresponsability.secondapproach.Context
import pattern.chainofresponsability.secondapproach.Handler

class LoginHandler: Handler {
    override val handlerName: String
        get() = "Login Handler"

    override fun execute(context: Context) {
        println("The Login Handler Just Begin")
        context.mapToUpdate.put(handlerName, "Login Action Finish")
        println("The Login Handler Just Finish")
    }

}