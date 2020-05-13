package pattern.strategy

class Client(val payment: Payment, val itemsToBuy :List<String>) {
    fun buyItems() {
        payment.pay(itemsToBuy)
    }
}