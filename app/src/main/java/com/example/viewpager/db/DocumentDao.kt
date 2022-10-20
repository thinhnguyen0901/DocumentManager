package com.example.viewpager.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.viewpager.models.Document

@Dao
interface DocumentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(document: Document)

    @Query("select * from document_table")
    fun getAllDocuments(): LiveData<MutableList<Document>>


}