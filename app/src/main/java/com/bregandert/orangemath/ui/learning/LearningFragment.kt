package com.bregandert.orangemath.ui.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bregandert.orangemath.databinding.FragmentLearningBinding
import com.bregandert.orangemath.utils.rv_adapters.NumberAdapter
import com.bregandert.orangemath.utils.rv_adapters.OrangeAdapter

class LearningFragment : Fragment() {
    private var _binding: FragmentLearningBinding? = null
    private val binding get() = _binding!!
    lateinit var learningViewModel: LearningViewModel
    private val numberAdapter = NumberAdapter()
    private val orangeAdapter = OrangeAdapter()
    private var number = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        learningViewModel = ViewModelProvider(this).get(LearningViewModel::class.java)
        _binding = FragmentLearningBinding.inflate(inflater, container, false)
        initTopRecycler()
        initDownRecycler()
        return binding.root
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonRigth()
        buttonLeft()
      }

    fun buttonRigth() {
        val buttonRigth: Button = binding.buttonLearningRigth
        buttonRigth.setOnClickListener {
            val numberCount = learningViewModel.numberItem(number)
            val orange = learningViewModel.orangeItem(number)
            if (number > 0) {
                orangeAdapter.addOrange(orange)
            }
            if (number > -1 && number < 10) {

                binding.number2.text = number.toString()
                binding.number2.visibility = View.VISIBLE
                numberAdapter.addNumber(numberCount)


            } else {
                binding.case1.visibility = View.VISIBLE
                numberAdapter.clearNumberList(numberCount)
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
            numberAdapter.deleteNumber(numberCount)
            binding.number2.text = (number-1).toString()
            if (number>0) {
                orangeAdapter.deleteOrange(orange)
            } else {
                orangeAdapter.clearOrangeList(orange)
                binding.number2.visibility = View.INVISIBLE
            }

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