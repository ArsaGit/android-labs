package com.example.lab1

sealed class SealedItem {
    data class BigItem(val id: Int, val imgUrl: String) : SealedItem()
    data class SmallItem(val id: Int) : SealedItem()
}