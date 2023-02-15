package com.nrp.shift_test_task.model

import androidx.lifecycle.viewModelScope
import com.nrp.shift_test_task.network.CardApi
import kotlinx.coroutines.launch

class CardViewModel {

    init {
        getCardData()
    }

    private fun getCardData() {
        viewModelScope.launch {
            try {
                _dishObjects.value = CardApi.retrofitService.getInfo()
                _status.value = DishApiStatus.DONE
            } catch (e: Exception) {
                _status.value = DishApiStatus.DONE
                _dishObjects.value = listOf()
            }
        }
    }
}