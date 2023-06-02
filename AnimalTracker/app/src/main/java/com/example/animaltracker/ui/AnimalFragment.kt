package com.example.animaltracker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.animaltracker.R
import com.example.animaltracker.databinding.FragmentAnimalBinding
import com.example.animaltracker.ui.viewmodel.AnimalViewModel

class animalFragment : Fragment() {

    private val animalViewModel: AnimalViewModel by activityViewModels {
        AnimalViewModel.Factory
    }

    private lateinit var  binding: FragmentAnimalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = animalViewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }
}