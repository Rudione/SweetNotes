package com.example.sweetnotes.domain.util

sealed class OrderType() {
    object Ascending: OrderType()

    object Descending: OrderType()
}