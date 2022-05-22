package space.arkady.defaultshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import space.arkady.defaultshoppinglist.repository.ShoppingRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@HiltViewModel
class ShoppingViewModelFactory @Inject constructor(
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}