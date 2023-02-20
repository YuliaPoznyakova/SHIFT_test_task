package com.nrp.shift_test_task.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nrp.shift_test_task.dto.CardDto
import com.nrp.shift_test_task.network.CardApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardViewModel: ViewModel() {

    private val _currentNumber = MutableLiveData<CardDto>()
    val currentNumber: LiveData<CardDto> = _currentNumber

    private val _currentInput = MutableLiveData<Int>()
    val currentInput: LiveData<Int> = _currentInput


    init {
        getCardData()
    }

    private fun getCardData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _currentNumber.value = CardApi.retrofitService.getInfo(currentInput)
            } catch (e: Exception) {
            }
        }
    }
}