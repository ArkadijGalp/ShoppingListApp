package space.arkady.defaultshoppinglist.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import space.arkady.defaultshoppinglist.data.ShoppingDAO
import space.arkady.defaultshoppinglist.data.db.ShoppingDatabase
import javax.inject.Singleton
import kotlin.coroutines.coroutineContext


@Module
@InstallIn(SingletonComponent::class)
object ShoppingAppModule {

    @Singleton
    @Provides
    fun provideShoppingDatabase(@ApplicationContext shoppingApp: Context) =
        Room.databaseBuilder(shoppingApp, ShoppingDatabase::class.java, "ShoppingDB.db").build()


    @Singleton
    @Provides
    fun provideShippingDao(shoppingdatabase: ShoppingDatabase) = shoppingdatabase.getShoppingDao()
}
