package com.fox.mypostmethodwithedittext

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.fox.mypostmethodwithedittext.databinding.AlertDialogWithEdittextBinding

class ConfirmationDialogFragment : DialogFragment() {
    private var _binding: AlertDialogWithEdittextBinding? = null
    private val binding get() = _binding!!

    interface ConfirmationListener {
        fun confirmButtonClicked(book:Books)
        fun cancelButtonClicked()
    }

    private lateinit var listener: ConfirmationListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = AlertDialogWithEdittextBinding.inflate(LayoutInflater.from(requireContext()))

        listener = requireActivity() as ConfirmationListener

        return AlertDialog.Builder(requireContext())
            .setTitle("Adding book")
            .setMessage("Please, add book to the server")
            .setView(binding.root)
            .setPositiveButton("Add") { _, _ ->

                var editTextId = binding.etId.text.toString()
                var editTextTitle = binding.etTitle.text.toString()
                var editTextAuthor = binding.etAuthor.text.toString()
                var editTextDescription = binding.etDescription.text.toString()
                var editTextPublished = binding.etPublished.text.toString()
                var id :Int =if(binding.etId.text.toString().length!=0) binding.etId.text.toString().toInt() else 0
                var publ: Int = if(binding.etPublished.text.toString().length !=0) binding.etPublished.text.toString().toInt() else 0
        var book: Books= Books(id, binding.etTitle.text.toString(), binding.etAuthor.text.toString(),binding.etDescription.text.toString() )
                println(book)

                listener.confirmButtonClicked(book)
            }
            .setNegativeButton("Cancel") { _, _ ->
                listener.cancelButtonClicked()
            }
            .create()
    }
}