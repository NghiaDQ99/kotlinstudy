package com.example.kotlinstudy.ui.shoppinglist

import com.example.kotlinstudy.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}