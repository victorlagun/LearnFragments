package com.example.learnfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]

        viewModel.viewModelLiveData.observe(viewLifecycleOwner) { textViewViewModel.text = it }

        parentFragmentManager.setFragmentResultListener(RESULT_KEY, this) { requestKey, bundle ->
            textViewResultAPI.text = bundle.getString(RESULT_API_TEXT)
        }

        nextButton.setOnClickListener {
            ExampleDialogFragment.newInstance().show(childFragmentManager, "TAG")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, SecondFragment.newInstance())
                .commit()
        }

        floatingActionButton.setOnClickListener {
            ExampleDialogFragment.newInstance()
                .show(childFragmentManager, ExampleDialogFragment.TAG)
        }
    }
}