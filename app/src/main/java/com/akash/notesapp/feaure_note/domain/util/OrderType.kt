package com.akash.notesapp.feaure_note.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}