package com.bregandert.orangemath.ui.learning

import androidx.lifecycle.ViewModel
import com.bregandert.orangemath.R
import com.bregandert.orangemath.domain.entity.NumberCount
import com.bregandert.orangemath.domain.entity.Orange
import com.bregandert.orangemath.ui.home.HomeFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LearningViewModel : ViewModel() {

    var number = 0

    val scope = CoroutineScope(Dispatchers.IO)


//    var _binding: FragmentLearningBinding? = null
//    val binding get() = _binding!!
//    lateinit var context: Context
//    lateinit var binding: FragmentLearningBinding

//    val numberAdapter = NumberAdapter()
//    val orangeAdapter = OrangeAdapter()
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
    if (number >=0 && number<= 10) {

        val orange = Orange(number, orangeList[number])
        return orange
    }
    val orange = Orange(0, orangeList[0])
    return orange
    }

    fun numberItem(number: Int): NumberCount {
        if (number >=0 && number<= 10) {
            val numberCount = NumberCount(
                (HomeFragment.LEARNING_STAGE * 10 + number).toString(),
                numberCountList[number]
            )
            return numberCount
        }
        val numberCount = NumberCount(
            0.toString(),
            numberCountList[0]
        )
        return numberCount
    }

    suspend fun playVoice(number: Int): String {
        scope.launch {
            delay(3000)
        }

        return suspendCoroutine {


            val string = "Work"
            it.resume(string)
        }
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