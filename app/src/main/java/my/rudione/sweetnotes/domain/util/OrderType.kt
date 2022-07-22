package my.rudione.sweetnotes.domain.util

sealed class OrderType() {
    object Ascending: OrderType()

    object Descending: OrderType()
}