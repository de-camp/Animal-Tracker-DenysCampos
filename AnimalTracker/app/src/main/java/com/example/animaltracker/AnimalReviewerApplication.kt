package com.example.animaltracker

import android.app.Application
import com.example.animaltracker.data.animals
import com.example.animaltracker.repositories.AnimalRepository

class AnimalReviewerApplication : Application() {
    val animalRepository: AnimalRepository by lazy {
        AnimalRepository(animals)
    }
}