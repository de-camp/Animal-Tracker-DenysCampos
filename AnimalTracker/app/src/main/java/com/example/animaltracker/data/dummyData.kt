package com.example.animaltracker.data

import com.example.animaltracker.data.model.AnimalModel

val name = "Lince"
val habitat = "El campo"

val name2 = "Pejelagarto"
val habitat2 = "Florida"

var animals = mutableListOf(
    AnimalModel(name, habitat),
    AnimalModel(name2, habitat2)
)