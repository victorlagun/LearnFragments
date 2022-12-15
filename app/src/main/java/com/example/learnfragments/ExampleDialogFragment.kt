package com.example.learnfragments

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ExampleDialogFragment : DialogFragment() {

    companion object {
        const val TAG = "ExampleDialogFragment"
        fun newInstance(): DialogFragment {
            return ExampleDialogFragment()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.dialog_title))
            .setMessage(getString(R.string.dialog_message))
            .setPositiveButton(getString(R.string.ok)) { _, _ -> }
            .setNegativeButton(getString(R.string.cancel)) { _, _ -> }
            .create()
}
