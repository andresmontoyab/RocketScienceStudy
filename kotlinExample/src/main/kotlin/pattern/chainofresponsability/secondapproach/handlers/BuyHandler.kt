package pattern.chainofresponsability.secondapproach.handlers

import pattern.chainofresponsability.secondapproach.Context
import pattern.chainofresponsability.secondapproach.Handler

class BuyHandler: Handler {
    override val handlerName: String
        get() = "Buy Handler"

    override fun execute(context: Context) {
        println("The Buy Handler Just Begin")
        context.mapToUpdate.put(handlerName, "Buy Action Finish")
        println("The Buy Handler Just Finish")
    }

}