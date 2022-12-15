package com.example.learnfragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ExampleDialogFragment : DialogFragment() {

    companion object {
        fun newInstance(): DialogFragment {
            return ExampleDialogFragment()
        }
    }

    class PurchaseConfirmationDialogFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
            AlertDialog.Builder(requireContext())
                .setMessage(getString(R.string.order_confirmation))
                .setPositiveButton(getString(R.string.ok)) { _, _ -> }
                .setNegativeButton(getString(R.string.cancel)) { _, _ -> }
                .create()
    }
}