package com.example.animaltracker.ui.animalList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.animaltracker.R
import com.example.animaltracker.databinding.FragmentAnimalListBinding
import com.example.animaltracker.ui.animalList.recyclerview.AnimalRecyclerViewAdapter
import com.example.animaltracker.ui.viewmodel.AnimalViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class animalListFragment : Fragment() {
    private lateinit var buttonFirstFragment: FloatingActionButton
    private lateinit var cardViewMovies: CardView

    private val animalViewModel: AnimalViewModel by activityViewModels {
        AnimalViewModel.Factory
    }

    private lateinit var binding: FragmentAnimalListBinding
    private lateinit var adapter: AnimalRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        buttonFirstFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_animalListFragment_to_newAnimalFragment)
        }

        cardViewMovies.setOnClickListener{
            it.findNavController().navigate(R.id.action_animalListFragment_to_animalFragment)
        }
    }

    private fun bind() {
        buttonFirstFragment = view?.findViewById(R.id.floating_action_button) as FloatingActionButton
        cardViewMovies = view?.findViewById(R.id.cardView) as CardView
    }
}