package com.example.animaltracker.ui.animalList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animaltracker.R
import com.example.animaltracker.data.model.AnimalModel
import com.example.animaltracker.databinding.FragmentAnimalListBinding
import com.example.animaltracker.ui.animalList.recyclerview.AnimalRecyclerViewAdapter
import com.example.animaltracker.ui.viewmodel.AnimalViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class animalListFragment : Fragment() {

    private val animalViewModel: AnimalViewModel by activityViewModels {
        AnimalViewModel.Factory
    }

    private lateinit var binding: FragmentAnimalListBinding
    private lateinit var adapter: AnimalRecyclerViewAdapter
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnimalListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)
        navController = findNavController()

        binding.floatingActionButton.setOnClickListener {
            animalViewModel.clearData()
            navController.navigate(R.id.action_animalListFragment_to_newAnimalFragment)
        }
    }

    private fun showSelectedItem(animal: AnimalModel) {
        animalViewModel.setSelectedAnimal(animal)
        findNavController().navigate(R.id.action_animalListFragment_to_animalFragment)
    }

    private fun displayAnimals() {
        adapter.setData(animalViewModel.getAnimals())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = AnimalRecyclerViewAdapter { selectedAnimal ->
            showSelectedItem(selectedAnimal)
        }

        binding.recyclerView.adapter = adapter
        displayAnimals()
    }
}