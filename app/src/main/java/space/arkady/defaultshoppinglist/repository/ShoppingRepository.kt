package space.arkady.defaultshoppinglist.repository

import space.arkady.defaultshoppinglist.data.db.ShoppingDatabase
import space.arkady.defaultshoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val database: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = database.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = database.getShoppingDao().delete(item)

    fun getAllShoppingItems() = database.getShoppingDao().getAllShoppingItems()
}