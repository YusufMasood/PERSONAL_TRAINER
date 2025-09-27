package com.example.personaltrainer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods",

    indices = [androidx.room.Index(value= ["name"], unique = true)]
)
data class FoodItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val quantity: Float,
    val calories: Int,
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val category: String? = null
)
