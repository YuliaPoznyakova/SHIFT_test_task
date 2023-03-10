package com.nrp.shift_test_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nrp.shift_test_task.databinding.FragmentMenuBinding
import com.nrp.shift_test_task.model.CardViewModel
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel


class MenuFragment : Fragment() {

    private val sharedViewModel: CardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMenuBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = sharedViewModel


        binding.apply {
             cardButton.setOnClickListener { goToNextScreen() }
        }
        return binding.root
    }

    fun checkCard() {

    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_menuFragment_to_cardDataFragment)
    }

}