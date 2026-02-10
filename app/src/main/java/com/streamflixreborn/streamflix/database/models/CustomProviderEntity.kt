package com.streamflixreborn.streamflix.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "custom_providers")
data class CustomProviderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val baseUrl: String,
    val language: String = "en",
    val logoUrl: String = "",
    val isEnabled: Boolean = true,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)