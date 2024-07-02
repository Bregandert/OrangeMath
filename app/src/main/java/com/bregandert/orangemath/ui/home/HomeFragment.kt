package com.bregandert.orangemath.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.bregandert.orangemath.MainActivity
import com.bregandert.orangemath.R
import com.bregandert.orangemath.databinding.FragmentHomeBinding
import com.bregandert.orangemath.ui.learning.LearningFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button_09: Button = binding.buttonLearning09
        val button_19: Button = binding.buttonLearning1019
        val button_29: Button = binding.buttonLearning2029

        button_09.setOnClickListener {
            LEARNING_STAGE = 1
            (activity as MainActivity).navController.navigate(R.id.action_navigation_home_to_navigation_learning)
        }

        button_19.setOnClickListener {
            LEARNING_STAGE = 2
            (activity as MainActivity).navController.navigate(R.id.action_navigation_home_to_navigation_learning)

        }

        button_29.setOnClickListener {
            LEARNING_STAGE = 3
            (activity as MainActivity).navController.navigate(R.id.action_navigation_home_to_navigation_learning)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        var LEARNING_STAGE = 0
//        val LearningFragment = LearningFragment()
    }

}