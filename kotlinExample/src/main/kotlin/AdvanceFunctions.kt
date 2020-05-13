fun printFilteredStrings(list:List<String>, predicate:(String) -> Boolean) {
    list.forEach { it ->
        if(predicate(it)) {
            println(it)
        }
    }
}

fun printFilteredStringsNullable(list:List<String>, predicate:((String) -> Boolean)?) {
    list.forEach { it ->
        if(predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

fun main() {
    val list = listOf<String>("Kotlin", "Java", "JavaScript", "C+++")
    val listWithNulls = listOf("Kotlin", "Java", "JavaScript", "C+++", null, null)


    listWithNulls
        .filterNotNull()
        .take(3)
        //.takeLast(3)
        .associate { it.length to it } // create map
         //.filter { it -> it.startsWith("J") }
         //.map { it -> it.length }
        .forEach { it -> println(it) }

    printFilteredStrings(list, {it.startsWith("K")})

    val predicate:(String) -> Boolean = {
        it.startsWith("J")
    }
    printFilteredStrings(list, predicate)

    // Re structure

    printFilteredStrings(list) {
        it.startsWith("K")
    }
    printFilteredStringsNullable(list, null)
}