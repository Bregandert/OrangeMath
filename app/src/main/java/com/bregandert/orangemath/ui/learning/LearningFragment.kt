package com.bregandert.orangemath.ui.learning

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bregandert.orangemath.MainActivity
import com.bregandert.orangemath.R
import com.bregandert.orangemath.databinding.FragmentLearningBinding
import com.bregandert.orangemath.ui.home.HomeFragment
import com.bregandert.orangemath.utils.rv_adapters.NumberAdapter
import com.bregandert.orangemath.utils.rv_adapters.OrangeAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LearningFragment : Fragment() {
    private var _binding: FragmentLearningBinding? = null
    private val binding get() = _binding!!
    lateinit var learningViewModel: LearningViewModel
    private val numberAdapter = NumberAdapter()
    private val orangeAdapter = OrangeAdapter()
    private var number = 0

    lateinit var sound1: MediaPlayer
    lateinit var sound2: MediaPlayer

    val scope = CoroutineScope(Dispatchers.Main)
    val scope1 = CoroutineScope(Dispatchers.IO)
    private lateinit var job: Job


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        learningViewModel = ViewModelProvider(this).get(LearningViewModel::class.java)
        _binding = FragmentLearningBinding.inflate(inflater, container, false)
        sound1 = MediaPlayer.create(context, R.raw.one)
        sound2 = MediaPlayer.create(context, R.raw.two)
        initTopRecycler()
        initDownRecycler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLearningStage()
        buttonRigth()
        buttonLeft()
    }

    fun initLearningStage() {
        val orange = learningViewModel.orangeItem(number)
        val numberCount = learningViewModel.numberItem(number)

        job = scope.launch {

//            var scope2 = CoroutineScope(Dispatchers.IO)
            when (HomeFragment.LEARNING_STAGE) {

                0 -> {
//                    val childJob1 = launch {
//                        playVoice(number)
//                        delay(3000)

//                        Thread.sleep(3000)

//                    }
//                    childJob1.start()
//                    childJob1.join()
                }


                1 -> {


                    val childJob2 = launch {
                        val childJob1 = launch {
//                            sound1.start()
                            playVoice(number)


//                            playVoice(number)
                            Thread.sleep(3000)

//                    if (sound1.currentPosition == sound1.duration) {
//                        sound1.stop()
                            for (number in 1..9) {
                                orangeAdapter.addOrange(orange)
                                binding.number2.text = number.toString()
                                binding.number2.visibility = View.VISIBLE
                            }
//                        sound2.start()
//                    }
//                            delay(3000)

//                            Thread.sleep(3000)


                        }
//                        childJob1.start()
//                        if (!sound1.isPlaying) {
//                            childJob1.isCompleted
//                        }
//                        childJob1.isCompleted
                        childJob1.join()


//                        playVoice(number)
                        Thread.sleep(3000)
//                    if (!sound1.isPlaying && !sound2.isPlaying) {
                        playVoice(number)

//                        sound2.start()

                        orangeAdapter.addOrange(orange)
                        binding.number1.text = HomeFragment.LEARNING_STAGE.toString()
                        binding.number1.visibility = View.VISIBLE
                        binding.number2.text = 0.toString()
                        binding.case1.visibility = View.VISIBLE
                        orangeAdapter.clearOrangeList(orange)
                        numberAdapter.clearNumberList(numberCount)

                    }
                    childJob2.start()
//                    if (!sound2.isPlaying) {
//                        childJob2.isCompleted
//                    }
                    childJob2.join()
                }


                2 -> {
//                    val childJob2 = launch {
//                        val childJob1 = launch {
//                            learningViewModel.playVoice(number)

//                            Thread.sleep(3000)

//                        }
                    for (number in 1..9) {
                        orangeAdapter.addOrange(orange)
                        binding.number2.text = number.toString()
                        binding.number2.visibility = View.VISIBLE
                        binding.number1.text = (HomeFragment.LEARNING_STAGE - 1).toString()
                        binding.number1.visibility = View.VISIBLE
                        binding.case1.visibility = View.VISIBLE
                    }

//                        childJob1.join()
//                        learningViewModel.playVoice(number)
//                        Thread.sleep(3000)
                    orangeAdapter.addOrange(orange)
                    binding.number1.text = HomeFragment.LEARNING_STAGE.toString()
                    binding.number1.visibility = View.VISIBLE
                    binding.number2.text = 0.toString()
                    binding.case2.visibility = View.VISIBLE
                    orangeAdapter.clearOrangeList(orange)
                    numberAdapter.clearNumberList(numberCount)
                }
//                    childJob2.join()


            }
        }
    }


        suspend fun playVoice(number: Int): Boolean {

            return suspendCoroutine {
                sound1.start()
                sound1.isPlaying
                it.resume(!sound1.isPlaying)
            }
        }

        fun buttonRigth() {
            val buttonRigth: Button = binding.buttonLearningRigth
            number = 0
            buttonRigth.setOnClickListener {

                val numberCount = learningViewModel.numberItem(number)
                val orange = learningViewModel.orangeItem(number)
                if (number > 0) {
                    orangeAdapter.addOrange(orange)
                }
                if (number >= 0 && number < 10) {

                    binding.number2.text = number.toString()
                    binding.number2.visibility = View.VISIBLE
                    numberAdapter.addNumber(numberCount)


                } else {
//                binding.case1.visibility = View.VISIBLE
                    numberAdapter.clearNumberList(numberCount)
                    orangeAdapter.clearOrangeList(orange)
                    (activity as MainActivity).navController.navigate(R.id.action_navigation_learning_to_navigation_test)
                }
                number++
            }
        }

        fun buttonLeft() {
            val buttonLeft: Button = binding.buttonLearningLeft
            buttonLeft.setOnClickListener {
                number--
                var numberCount = learningViewModel.numberItem(number)
                val orange = learningViewModel.orangeItem(number)

                if (number > 0) {
                    orangeAdapter.deleteOrange(orange)
                    numberAdapter.deleteNumber(numberCount)
                    binding.number2.text = (number - 1).toString()
                } else {
                    if (number == 0) {
                        orangeAdapter.clearOrangeList(orange)
                        numberAdapter.clearNumberList(numberCount)
//                    binding.number1.visibility = View.INVISIBLE
                        binding.number2.visibility = View.INVISIBLE
//                    (activity as MainActivity).navController.navigate(R.id.action_navigation_learning_to_navigation_test)
                    } else {
                        (activity as MainActivity).navController.navigate(R.id.action_navigation_learning_to_navigation_test)
                    }
                }

            }
        }

        private fun initTopRecycler() {
            binding.apply {
                topRecycler.layoutManager = GridLayoutManager(context, 5)
                topRecycler.adapter = numberAdapter
            }
        }

        private fun initDownRecycler() {
            binding.apply {
                downRecycler.layoutManager = GridLayoutManager(context, 5)
                downRecycler.adapter = orangeAdapter
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }







//    private val numberCountList = listOf(
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//        R.drawable.number_background,
//    )
//    private val orangeList = listOf(
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//        R.drawable.ic_orange,
//    )