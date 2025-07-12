package com.example.personaltrainer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "foods")
data class FoodItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val calories: Int,
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val category: String? = null
)
