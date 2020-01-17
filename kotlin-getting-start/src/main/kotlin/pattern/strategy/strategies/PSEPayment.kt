package pattern.strategy.strategies

import pattern.strategy.Payment

class PSEPayment : Payment {

    override fun pay(itemsToBuy: List<String>) {
        itemsToBuy.forEach {
            println("There was a purchase of $it with PSE platform")
        }
    }
}