package com.example.animaltracker.repositories

import com.example.animaltracker.data.model.AnimalModel

class AnimalRepository (private val animals: MutableList<AnimalModel>) {
    fun getMovies() = animals

    fun addMovies(movie: AnimalModel) = animals.add(movie)
}