package pattern.strategy

import pattern.strategy.strategies.CashPayment
import pattern.strategy.strategies.CreditCarPayment
import pattern.strategy.strategies.PSEPayment

/**
 * Strategy Pattern - Behavior pattern
 *
 * 1. Define a family of algorithms, encapsulate each one, and make them interchangeable.
 *    Strategy lets the algorithm vary independently from the clients that use it.
 * 2. Capture the abstraction in an interface, bury implementation details in derived classes
 * 3. Following Open-closed principle
 * 4. Program to an interface, not an implementation
 */

fun main() {
    println("First Client")
    val cashClient: Client = Client(CashPayment(), listOf("pencil", "notebook", "board"))
    cashClient.buyItems()

    println("Second Client")
    val creditCardClient: Client = Client(CreditCarPayment(), listOf("flight new york", "flight medellin"))
    creditCardClient.buyItems()

    println("Third Client")
    val pseClient: Client = Client(PSEPayment(), listOf("cellphone", "camera"))
    pseClient.buyItems()
}