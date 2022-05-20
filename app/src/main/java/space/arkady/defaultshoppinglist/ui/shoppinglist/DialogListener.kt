package space.arkady.defaultshoppinglist.ui.shoppinglist

import space.arkady.defaultshoppinglist.data.db.entities.ShoppingItem

interface DialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}