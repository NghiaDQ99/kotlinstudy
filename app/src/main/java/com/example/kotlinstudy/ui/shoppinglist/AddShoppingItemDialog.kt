package com.example.kotlinstudy.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.kotlinstudy.data.db.entities.ShoppingItem
import com.example.kotlinstudy.databinding.DialogAddShoppingItemBinding

class AddShoppingItemDialog(context: Context, val addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    var binding: DialogAddShoppingItemBinding = DialogAddShoppingItemBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCancelable(true)
        setCanceledOnTouchOutside(true)
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        binding.tvCancel.setOnClickListener {
            cancel()
        }

        binding.tvAdd.setOnClickListener{
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()
            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Enter all information", Toast.LENGTH_SHORT).show()
            } else {
                val item = ShoppingItem(name, amount.toInt())
                addDialogListener.onAddButtonClicked(item)
                dismiss()
            }
        }
    }
}