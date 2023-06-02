package com.example.animaltracker.ui.newanimal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.animaltracker.databinding.FragmentNewAnimalBinding
import com.example.animaltracker.ui.viewmodel.AnimalViewModel

class newAnimalFragment : Fragment() {
    private val animalViewModel: AnimalViewModel by activityViewModels{
        AnimalViewModel.Factory
    }

    private lateinit var binding: FragmentNewAnimalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = animalViewModel
    }

    private fun observeStatus() {
        animalViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(AnimalViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    animalViewModel.clearStatus()
                }

                status.equals(AnimalViewModel.ANIMAL_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, animalViewModel.getAnimals().toString())
                    animalViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP TAG"
    }

}