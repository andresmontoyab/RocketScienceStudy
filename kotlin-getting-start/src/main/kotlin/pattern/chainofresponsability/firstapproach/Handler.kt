package pattern.chainofresponsability.firstapproach

interface Handler {
    val handlerName:String
    var next:Handler?

    fun execute(context:Context)
}