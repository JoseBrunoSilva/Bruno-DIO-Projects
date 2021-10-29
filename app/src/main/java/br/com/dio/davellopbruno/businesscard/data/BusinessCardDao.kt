package br.com.dio.davellopbruno.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BusinessCardDao {
    @Query("SELECT * FROM Businesscard")
    fun getAll(): LiveData<List<Businesscard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businesscard: Businesscard)
}