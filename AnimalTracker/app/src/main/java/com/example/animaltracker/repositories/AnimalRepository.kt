package com.example.animaltracker.repositories

import com.example.animaltracker.data.model.AnimalModel

class AnimalRepository (private val animals: MutableList<AnimalModel>) {
    fun getAnimals() = animals

    fun addAnimals(animal: AnimalModel) = animals.add(animal)
}