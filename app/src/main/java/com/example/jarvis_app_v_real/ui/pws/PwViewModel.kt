package com.example.jarvis_app_v_real.ui.pws

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PwViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is PW Fragment"
    }
    val text: LiveData<String> = _text
}