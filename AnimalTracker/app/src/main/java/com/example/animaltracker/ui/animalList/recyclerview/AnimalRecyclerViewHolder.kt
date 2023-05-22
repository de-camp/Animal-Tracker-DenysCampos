package com.example.animaltracker.ui.animalList.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.animaltracker.data.model.AnimalModel

class AnimalRecyclerViewHolder (private val binding: AnimalItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(animal: AnimalModel, clickListener: (AnimalModel)->Unit) {
        binding.titleTextView.text = animal.name
        binding.qualificationTextView.text = animal.habitat

        binding.movieItemCardView.setOnClickListener {
            clickListener(animal)
        }
    }
}