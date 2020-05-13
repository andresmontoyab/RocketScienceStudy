class Person(val firstName: String, val lastName:String) {
    init {
        println("init 1")
    }
    constructor(): this("Def First Name", "Def Lastname") {
        println("Secondary constractur")
    }
    init {
        println("init 2")
    }

    var nickname:String? = null
        set(value) {
            field  = value
            println("The new nickname is $value")
        }

        get() {
            println("The retuned value is $field")
            return field
        }

    fun printInfo() {
        // ?: validate if is null
        val nickNameToPrint = nickname ?: "no nickname"
        println("The person info is $firstName $lastName and also know as $nickNameToPrint")
    }
}
