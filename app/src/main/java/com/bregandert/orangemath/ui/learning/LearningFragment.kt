package com.bregandert.orangemath.ui.learning

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bregandert.orangemath.MainActivity
import com.bregandert.orangemath.R
import com.bregandert.orangemath.databinding.FragmentLearningBinding
import com.bregandert.orangemath.domain.entity.NumberCount
import com.bregandert.orangemath.ui.rv_adapters.NumberAdapter

class LearningFragment : Fragment() {

    private var _binding: FragmentLearningBinding? = null
    lateinit var learningViewModel: LearningViewModel
    private val numberAdapter = NumberAdapter()
    private var number = 1
    private val numberCountList = listOf(
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


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        _binding = FragmentLearningBinding.inflate(layoutInflater)
//        startActivity(MainActivity, savedInstanceState)
//    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        learningViewModel = ViewModelProvider(this).get(LearningViewModel::class.java)

        _binding = FragmentLearningBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    init()

    }



    private fun init() {
        binding.apply {
            topRecycler.layoutManager = GridLayoutManager(this as MainActivity, 5)
            topRecycler.adapter = numberAdapter

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        init()

//        val n = 0
//
//        var name: String = "orangeView$n"
//
//
        val button: Button = binding.buttonLearningRigth
//
//        val itemOrange = learningViewModel.orangeList.last()

        button.setOnClickListener {
            val numberCount = NumberCount((number-1).toString(), numberCountList[number])
            numberAdapter.addNumber(numberCount)
            number++

//            val imageOrange = itemOrange.orangeImage
//
//            val imageV =  learningViewModel.getNumberItem(1)
//            binding.number2.setImageResource(R.drawable.number_0)

//            (activity as MainActivity).navController.navigate(R.id.action_navigation_learning_to_navigation_test)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}