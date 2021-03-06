package space.arkady.defaultshoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_shopping.*
import space.arkady.defaultshoppinglist.R
import space.arkady.defaultshoppinglist.data.db.ShoppingDatabase
import space.arkady.defaultshoppinglist.data.db.entities.ShoppingItem
import space.arkady.defaultshoppinglist.other.ShoppingItemAdapter
import space.arkady.defaultshoppinglist.repository.ShoppingRepository
import space.arkady.defaultshoppinglist.ui.shoppinglist.AddShoppingItemDialog
import space.arkady.defaultshoppinglist.ui.shoppinglist.DialogListener
import space.arkady.defaultshoppinglist.ui.shoppinglist.ShoppingViewModel
import space.arkady.defaultshoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class ShoppingActivity : AppCompatActivity() {

    @Inject
    lateinit var shoppingViewModel: ShoppingViewModel

    @Inject
    lateinit var shoppingviewmodelfactory: ShoppingViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database as ShoppingDatabase)
        val factory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory)[ShoppingViewModel::class.java]

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, androidx.lifecycle.Observer { })

        adapter.items
        adapter.notifyDataSetChanged()

        fab.setOnClickListener {
            AddShoppingItemDialog(context = this,
                object : DialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}
