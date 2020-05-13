package pattern.chainofresponsability.firstapproach.handlers

import pattern.chainofresponsability.firstapproach.Context
import pattern.chainofresponsability.firstapproach.Handler

class LoginHandler: Handler {
    override val handlerName: String
        get() = "Login Handler"

    override var next: Handler? = BuyHandler()

    override fun execute(context: Context) {
        println("The Login Handler Just Begin")
        context.mapToUpdate.put(handlerName, "Login Action Finish")
        println("The Login Handler Just Finish")
        next?.execute(context)
    }

}