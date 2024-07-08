package com.bregandert.orangemath.ui.learning

import androidx.lifecycle.ViewModel
import com.bregandert.orangemath.R
import com.bregandert.orangemath.domain.entity.NumberCount
import com.bregandert.orangemath.domain.entity.Orange
import com.bregandert.orangemath.utils.rv_adapters.NumberAdapter
import com.bregandert.orangemath.utils.rv_adapters.OrangeAdapter

class LearningViewModel : ViewModel() {

    var number = 0

//    var _binding: FragmentLearningBinding? = null
//    val binding get() = _binding!!
//    lateinit var context: Context
//    lateinit var binding: FragmentLearningBinding

    val numberAdapter = NumberAdapter()
    val orangeAdapter = OrangeAdapter()
    val orangeList = listOf(
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
        R.drawable.ic_orange,
    )

    val numberCountList = listOf(
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
        R.drawable.number_background,
    )

//    private fun initTopRecycler() {
//        learningViewModel = LearningViewModel()
//        binding.apply {
//            topRecycler.layoutManager = GridLayoutManager(context, 5)
//            topRecycler.adapter = numberAdapter
//
//        }
//    }
//
//    private fun initDownRecycler() {
//        learningViewModel = LearningViewModel()
//        binding.apply {
//            downRecycler.layoutManager = GridLayoutManager(context, 5)
//            downRecycler.adapter = orangeAdapter
//
//        }
//    }
    fun orangeItem(number: Int): Orange {
//        if (number > -1 && number < 10) {
//            val numberCount = NumberCount((number).toString(), numberCountList[number])
            val orange = Orange(number, orangeList[number])
    return orange
//            binding.number2.text = number.toString()
//            binding.number2.visibility = View.VISIBLE
//            numberAdapter.addNumber(numberCount)
//            if (number > 0) {
//                orangeAdapter.addOrange(orange)
//            }
//            number++
//        } else {
//            binding.case1.visibility = View.VISIBLE
//        }
    }

    fun numberItem(number: Int): NumberCount {
        val numberCount = NumberCount((number).toString(), numberCountList[number])
        return numberCount
    }



//    val numbersList = listOf(
//        NumberCount("1", R.drawable.number_background),
//        NumberCount("2", R.drawable.number_background)
//    )
//
//    fun getNumberItem(id: Int) : NumberCount {
//        return numbersList.get(id)
//    }

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is learning Fragment"
//    }
//    val text: LiveData<String> = _text
}