package space.arkady.defaultshoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import kotlinx.android.synthetic.main.dialog_add_shoppingitem.*
import kotlinx.android.synthetic.main.shopping_item.*
import space.arkady.defaultshoppinglist.R
import space.arkady.defaultshoppinglist.data.db.entities.ShoppingItem

class AddShoppingItemDialog(context: Context, var addDialogListener: DialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_item)

        tvAdd.setOnClickListener {
            val name = tvName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

        }
        val item = ShoppingItem(name = "Name", amount = 10)
        addDialogListener.onAddButtonClicked(item)
        dismiss()
        tvCancel.setOnClickListener {
            cancel()
        }
    }
}