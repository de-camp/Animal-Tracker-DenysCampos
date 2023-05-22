package com.example.animaltracker.ui.animalList.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.animaltracker.data.model.AnimalModel
import com.example.animaltracker.databinding.AnimalItemBinding

class AnimalRecyclerViewHolder (private val binding: AnimalItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(animal: AnimalModel, clickListener: (AnimalModel)->Unit) {
        binding.titleTextView.text = animal.name
        binding.qualificationTextView.text = animal.habitat

        binding.animalItemCardView.setOnClickListener {
            clickListener(animal)
        }
    }
}