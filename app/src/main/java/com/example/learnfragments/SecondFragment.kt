package com.example.learnfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_second.*

const val RESULT_KEY = "RESULT_KEY"
const val RESULT_API_TEXT = "RESULT_API_TEXT"

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]

        saveButton.setOnClickListener {
            viewModel.viewModelLiveData.postValue(editTextViewModel.text.toString())

            parentFragmentManager.setFragmentResult(
                RESULT_KEY,
                bundleOf(RESULT_API_TEXT to editTextResultAPI.text.toString())
            )

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, FirstFragment.newInstance()).commit()
        }
    }
}