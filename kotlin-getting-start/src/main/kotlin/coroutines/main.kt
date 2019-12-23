package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    //exampleBlocking()
    //exampleGlobalLaunch()
    //exampleGlobalLaunchWaiting()
    exampleLaunchWCoroutinesScope()

}

suspend fun printLineDelay(message:String) {
    // complex calculation
    // Make this funcion suspending
    delay(1000) // suspend this particular function
    println(message)
}

fun exampleBlocking() {
    println("one - from thread ${Thread.currentThread().name}")
    runBlocking {
        printLineDelay("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
}

fun exampleGlobalLaunch() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")
        GlobalScope.launch{
            printLineDelay("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
    delay(3000)
}

fun exampleGlobalLaunchWaiting() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")
    val job = GlobalScope.launch{
        printLineDelay("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
    job.join()
}

fun exampleLaunchWCoroutinesScope() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")
    this.launch{
        printLineDelay("two - from thread ${Thread.currentThread().name}")
    }
    println("three - from thread ${Thread.currentThread().name}")
}