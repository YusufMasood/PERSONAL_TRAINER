package com.example.personaltrainer.data

import androidx.room.*

@Dao
interface FoodDao {

    @Query("SELECT * FROM foods")
    suspend fun getAllFoods(): List<FoodItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(foods: List<FoodItem>)

    @Query("SELECT * FROM foods WHERE name LIKE '%' || :query || '%'")
    suspend fun searchFood(query: String): List<FoodItem>
}
