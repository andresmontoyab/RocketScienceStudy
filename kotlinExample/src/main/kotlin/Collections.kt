/**
 * By default the collection are inmutable.
 * If we want to create a mutable collection could use the mutable
 */

fun main() {
    arrays()
    maps()

}

private fun maps() {
    // inmutables
    val map = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    map.put(4, "d")
    map.forEach { key, value ->
        println("$key -> $value")
    }

}

private fun arrays() {
    val interestingThings = arrayOf("kotlin", "programmin", "comic boojs")
    val interestingThings2 = listOf("kotlin", "programmin", "comic boojs")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))

    for (interestingThing in interestingThings) {
        println(interestingThing)
    }

    interestingThings.forEach { interestingThing ->
        println(interestingThing)
    }

    interestingThings.forEach {

    }

    interestingThings.forEachIndexed { index, interestingThing ->
        println("$interestingThing is at the index $index")
    }
}