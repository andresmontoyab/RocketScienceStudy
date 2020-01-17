package pattern.strategy

interface Payment {
    fun pay(itemsToBuy: List<String>)
}