package pattern.chainofresponsability.firstapproach.handlers

import pattern.chainofresponsability.firstapproach.Context
import pattern.chainofresponsability.firstapproach.Handler

class BuyHandler: Handler {
    override val handlerName: String
        get() = "Buy Handler"

    override var next: Handler? = null

    override fun execute(context: Context) {
        println("The Buy Handler Just Begin")
        context.mapToUpdate.put(handlerName, "Buy Action Finish")
        println("The Buy Handler Just Finish")
    }

}