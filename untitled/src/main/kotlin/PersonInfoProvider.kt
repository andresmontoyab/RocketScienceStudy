interface PersonInfoProvider {
    val providerInfo:String
    fun printInfo(person: Person) {
        // default method
        println("The $providerInfo impl person is ${person.firstName} ${person.lastName}")
    }

}

interface SessionInfoProvider {
    fun getSessionId():String
}

fun main() {
    val provider = BasicProvider()
    var person = Person("Andres", "Montoya")
    person.nickname = "Barbas"
    provider.printInfo(person)
    provider.getSessionId()
    checkTypes(provider)
}

open class BasicProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "Basic Provider"

    override fun printInfo(person: Person) {
        println("The info person is ${person.firstName} ${person.lastName}")
    }

    override fun getSessionId(): String {
        println("Getting the session id ....")
        return "Session"
    }
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider is SessionInfoProvider) {
        println("Is a session info provider")
    } else {
        println("Is not a info provider")
        (infoProvider as SessionInfoProvider).getSessionId()
    }
}