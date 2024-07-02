package com.bregandert.orangemath.ui.learning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bregandert.orangemath.R
import com.bregandert.orangemath.domain.entity.NumberCount
import com.bregandert.orangemath.domain.entity.Orange

class LearningViewModel : ViewModel() {

    var orangeList = arrayListOf<Orange>(
        Orange(0, R.drawable.ic_oranges),
        Orange(1, R.drawable.ic_oranges),
        Orange(2, R.drawable.ic_oranges),
        Orange(3, R.drawable.ic_oranges),
        Orange(4, R.drawable.ic_oranges),
        Orange(5, R.drawable.ic_oranges),
    )



    val numbersList = listOf(
        NumberCount("1", R.drawable.number_background),
        NumberCount("2", R.drawable.number_background)
    )

    fun getNumberItem(id: Int) : NumberCount {
        return numbersList.get(id)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is learning Fragment"
    }
    val text: LiveData<String> = _text
}