package pattern.chainofresponsability.secondapproach

interface Handler {
    val handlerName:String

    fun execute(context:Context)
}