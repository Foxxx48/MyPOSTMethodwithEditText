package com.fox.mypostmethodwithedittext

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.fox.mypostmethodwithedittext.databinding.ActivityMainBinding
import com.fox.mypostmethodwithedittext.databinding.AlertDialogWithEdittextBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), ConfirmationDialogFragment.ConfirmationListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!




    val booksApi = RetrofitHelper.getInstance().create(BooksApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acBtn.setOnClickListener {
//            withEditText(it)

            showConfirmationDialog()

        }
    }



    private fun showConfirmationDialog() {
        ConfirmationDialogFragment()
            .show(supportFragmentManager, "ConfirmationDialogFragmentTag")
    }


    override fun confirmButtonClicked(book:Books) {
        GlobalScope.launch {

            val result = booksApi.addBook(book)
            if (result != null)
            // Checking the results
               println(result.body())
        }




    }


    override fun cancelButtonClicked() {
        println("Cancel button clicked")
    }
}


