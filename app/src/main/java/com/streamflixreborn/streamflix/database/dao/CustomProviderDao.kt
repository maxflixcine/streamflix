package com.streamflixreborn.streamflix.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.streamflixreborn.streamflix.database.models.CustomProviderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomProviderDao {
    
    @Query("SELECT * FROM custom_providers ORDER BY name ASC")
    fun getAllProviders(): Flow<List<CustomProviderEntity>>

    @Query("SELECT * FROM custom_providers WHERE isEnabled = 1 ORDER BY name ASC")
    fun getEnabledProviders(): Flow<List<CustomProviderEntity>>

    @Query("SELECT * FROM custom_providers WHERE id = :id")
    suspend fun getProviderById(id: Int): CustomProviderEntity?

    @Query("SELECT * FROM custom_providers WHERE name = :name")
    suspend fun getProviderByName(name: String): CustomProviderEntity?

    @Insert
    suspend fun insertProvider(provider: CustomProviderEntity): Long

    @Update
    suspend fun updateProvider(provider: CustomProviderEntity)

    @Delete
    suspend fun deleteProvider(provider: CustomProviderEntity)

    @Query("DELETE FROM custom_providers WHERE id = :id")
    suspend fun deleteProviderById(id: Int)

    @Query("UPDATE custom_providers SET isEnabled = :enabled WHERE id = :id")
    suspend fun updateProviderStatus(id: Int, enabled: Boolean)

    @Query("DELETE FROM custom_providers")
    suspend fun deleteAllProviders()
}