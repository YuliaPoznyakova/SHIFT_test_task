package com.nrp.shift_test_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nrp.shift_test_task.databinding.FragmentCardDataBinding
import com.nrp.shift_test_task.databinding.FragmentMenuBinding
import com.nrp.shift_test_task.model.CardViewModel

class CardDataFragment : Fragment() {

    private val sharedViewModel: CardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCardDataBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = sharedViewModel

        binding.apply {
            backToMenu.setOnClickListener { goToPreviousScreen() }
        }
        return binding.root
    }

    fun checkCard() {

    }

    fun goToPreviousScreen() {
        findNavController().navigate(R.id.action_cardDataFragment_to_menuFragment)
    }

}