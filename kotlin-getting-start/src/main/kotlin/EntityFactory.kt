class Entity private constructor(val id:String) {
    companion object Factory {
        const val id = "id"
        fun create():Entity {
            return Entity("id")
        }
    }
}

fun main() {
    val entity = Entity.create()
}

