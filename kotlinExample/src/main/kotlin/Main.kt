
val name: String = "Top-Level Variables"
val greetng: String = "Hello"

/**
 * Simplicidad
 * Conciso
 * Seguros NPE
 */

fun main() {
    println("Welcome Kotlin")
    variables()
    controlFlows()
    functions()
    classes()
    visibility()
    interfaces()
    objectExpression()
    companionObjects()
    enumClasses()
    highOrderFunction()
    coroutines()
}

fun coroutines() {
    /**
     * Is another options for threading.
     * 1. Common practical use cases, if you're making a request on network do it in background
     * 2. How to deal with chain of request?
     */
}

fun highOrderFunction() {
    /**
     * Are function that can return other function or receive funcion as parameters
     * Check AdvanceFuntions
     */
}

fun enumClasses() {
    /**
     * Enum class
     */
    val type:EntityType = EntityType.EASY
    val name:String = when(type) {
        EntityType.EASY -> "Easy"
        EntityType.MEDIUM -> type.name
        EntityType.HARD -> "Hard"
    }
}

enum class EntityType {
    EASY, MEDIUM, HARD
}

fun companionObjects() {
    /**
     * A companion objects are objects inside a class that can access to the private fields or fun of the
     * outter class, also the companion object are like classes cam have methods, atributtes and even implement
     * from interfaces.
     */
}

fun objectExpression() {
    /**
     * In order to create anonymous classes you must use the object : keyword
     * Allows you to create an anonymous inner class
     */
    val provider = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New Anonymous Info Provider"

        fun getSessionId() = "id"
    }

    provider.getSessionId()
    provider.providerInfo

}

fun interfaces() {
    /**
     * 1.The interface are defined with the word interfaces
     * 2. To implement interfaces only need to use the : mark
     * 3. In Kotlin there are default interfaces methods
     * 4. If I want to implement more than one interfaces you only should use the ","
     * 5. The "is" keyword -> similar to instance of
     * 6. The "as" keyword is used to cast objects
     */
}

fun visibility() {
    /**
     * In Kotlin the default visibility is public by default
     * 1. public
     * 2. internal -> Is public within the module
     * 3. private -> Only available in the file
     * 4. protected -> that class or any subclasses
     */
}

/**
 * To create classes in kotlin you should use the keyword class
 *  class Person {}
 *  If you want to create an instance of the object you use Person() without new
 *  1. Init block are always going to run first that secundary constructors
 *  2. In kotlin the getter an setter are provided automatically, if you have a val
 *  only de get is generated.
 *  3 You can overridide your getter if you want a custom behavior
 *  4. By default in Kotlin classes are close, meaning can not be inheritance or extended
 *  5. If you want to extend a class you need to add the open keyword
 */
fun classes() {
    val person = Person(firstName = "Hey", lastName = "There")
    person.lastName
    person.firstName
    person.nickname = "Jones"
    person.nickname = "New Jones "
    println(person.nickname)
    person.printInfo()
    val otherPerson = Person()
}

fun functions() {
    /**
     * To define a function you should use the fun keywork
     * After that the function name
     * Later () -> with parameters
     * At the end the return type
     * Ej : fun getGreeting(): String {
     *      return "Hello"
     * }
     * Similar to void is Unit.
     */
    funSimplified()
    funWithParameters("Hey there")
    funWithNamedAndDefauldValues()
}

fun funWithNamedAndDefauldValues() {
    greetPerson(greeting = "Hallo")
}

fun greetPerson(greeting:String = "Def Greeting", name:String?) = println("$greeting $name")


fun funWithParameters(something:String) {
    println(something)

}

fun funSimplTwo() = "Single Literal"


fun funSimplified() = "Single Literal Function";
}

fun controlFlows() {
    learningIf()
    learningwhen()
}

fun learningwhen() {
    when(greetng) {
        null -> println("Is null")
        "Hi" -> println("It Match with H1 :3")
        else -> println("This is the default")
    }
}

fun learningIf() {
    if (greetng == "Hi") {
        println("Match!")
    } else {
        println("No match")
    }
}

private fun variables() {
    typesDefinition()
    topLevelVariables()
    noNullVariables()
}

fun noNullVariables() {
    /**
     * One big difference between java and kotlin is that in kotlin the
     * objects are not null by default, if you want actually have null as a value
     * you need to add a question mark
     */
    val jpMasterForever:String = null
    val address:String? = "address"
    val otherAddress:String?
}

fun topLevelVariables() {
    /**
     * The variable could created at the fun level or also
     * at the file level, the last one are the top level variables.
     */
}

fun typesDefinition() {
    /**
     * Variables should be defining using var or val
     * var -> mutable
     * val - inmutable
     */
    var name = "Carlos"
    name = "Simon"
    val lastname:String = "Perez"
    // lastname = "Giraldo" -> error here.
}

