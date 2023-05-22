package com.example.animaltracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.animaltracker.AnimalReviewerApplication
import com.example.animaltracker.data.model.AnimalModel
import com.example.animaltracker.repositories.AnimalRepository

class AnimalViewModel (private val repository: AnimalRepository): ViewModel(){
    var name = MutableLiveData("")
    var habitat = MutableLiveData("")
    var status = MutableLiveData("")

    fun getAnimals() = repository.getAnimals()

    fun addAnimals(animal: AnimalModel) = repository.addAnimals(animal)

    fun createAnimal() {
        if(!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val animal = AnimalModel(
            name.value!!,
            habitat.value!!
        )

        addAnimals(animal)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            habitat.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        name.value = ""
        habitat.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedMovie(animal: AnimalModel) {
        name.value = animal.name
        habitat.value = animal.habitat
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as AnimalReviewerApplication
                AnimalViewModel(app.animalRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}