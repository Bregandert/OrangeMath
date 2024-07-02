package com.bregandert.orangemath.ui.Examination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bregandert.orangemath.MainActivity
import com.bregandert.orangemath.R
import com.bregandert.orangemath.databinding.FragmentTestBinding

class ExaminationFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val examinationViewModel =
            ViewModelProvider(this).get(ExaminationViewModel::class.java)

        _binding = FragmentTestBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        examinationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = binding.buttonHome

        button.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_navigation_test_to_navigation_home)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}