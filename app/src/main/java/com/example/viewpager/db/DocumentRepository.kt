package com.example.viewpager.db

import androidx.lifecycle.LiveData
import com.example.viewpager.models.Document

class DocumentRepository(private val documentDao: DocumentDao) {
    val allDocuments: LiveData<MutableList<Document>> = documentDao.getAllDocuments()

    suspend fun insert(document: Document) {
        documentDao.insert(document)
    }


}