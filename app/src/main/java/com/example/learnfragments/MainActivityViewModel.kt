package com.example.learnfragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val viewModelLiveData = MutableLiveData<String>()
}