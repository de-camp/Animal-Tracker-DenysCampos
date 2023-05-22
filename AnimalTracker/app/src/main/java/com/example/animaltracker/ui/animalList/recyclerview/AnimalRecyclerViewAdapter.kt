package com.example.animaltracker.ui.animalList.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animaltracker.data.model.AnimalModel

class AnimalRecyclerViewAdapter(
    private val clickListerner: (AnimalModel) -> Unit
): RecyclerView.Adapter<AnimalRecyclerViewHolder>() {
    private val animals = ArrayList<AnimalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalRecyclerViewHolder, position: Int) {
        val animal = animals[position]
        holder.bind(animal, clickListerner)
    }

    fun setData(animalsList: List<AnimalModel>) {
        animals.clear()
        animals.addAll(animalsList)
    }
}