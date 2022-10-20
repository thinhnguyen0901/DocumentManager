package com.example.viewpager.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE
import android.provider.MediaStore.VOLUME_EXTERNAL
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.viewpager.db.DocumentDatabase
import com.example.viewpager.db.DocumentRepository
import com.example.viewpager.models.Document
import kotlinx.coroutines.launch

class DocumentViewModel(application: Application) : AndroidViewModel(application) {

    private val allDocuments: LiveData<MutableList<Document>>
    private val repository: DocumentRepository

    init {
        val dao = DocumentDatabase.getDatabase(application).getDocumentDao()
        repository = DocumentRepository(dao)
        allDocuments = repository.allDocuments
    }

    fun insertDocument(document: Document) = viewModelScope.launch {
        repository.insert(document)
    }


    @SuppressLint("Recycle")
    fun getAllVideos(list: MutableList<Document>, application: Application) {
        val contentResolver: ContentResolver = application.contentResolver
        val videoUri: Uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI
        val videoCursor: Cursor? = contentResolver.query(videoUri, null, null, null, null)
        if (videoCursor != null && videoCursor.moveToFirst()) {
            val videoName: Int = videoCursor.getColumnIndex(MediaStore.Video.Media.TITLE)
            val videoSize: Int = videoCursor.getColumnIndex(MediaStore.Video.Media.SIZE)
            val videoTime: Int = videoCursor.getColumnIndex(MediaStore.Video.Media.DATE_MODIFIED)
            val videoPath: Int = videoCursor.getColumnIndex(MediaStore.Video.Media.DATA)
            do {
                val _videoName: String = videoCursor.getString(videoName)
                val _videoFormat: String = "3"
                val _videoSize: String = videoCursor.getString(videoSize)
                val _videoTime: String = videoCursor.getString(videoTime)
                val _videoPath: String = videoCursor.getString(videoPath)
                val document =
                    Document(_videoName, _videoFormat, _videoSize, _videoTime, _videoPath)
                list.add(document)
            } while (videoCursor.moveToNext())
        }
    }

    fun getAllFiles(list: MutableList<Document>, application: Application) {
        val contentResolver: ContentResolver = application.contentResolver
        val songUri: Uri = MediaStore.Files.getContentUri(VOLUME_EXTERNAL)
        val songCursor: Cursor? = contentResolver.query(songUri, null, null, null, null)
        if (songCursor != null && songCursor.moveToFirst()) {
            val columnName: Int = songCursor.getColumnIndex(MediaStore.Files.FileColumns.TITLE)
            val columnFormat: Int = songCursor.getColumnIndex(MediaStore.Files.FileColumns.MEDIA_TYPE)
            val columnSize: Int = songCursor.getColumnIndex(MediaStore.Files.FileColumns.SIZE)
            val columnTime: Int = songCursor.getColumnIndex(MediaStore.Files.FileColumns.DATE_MODIFIED)
            val columnPath: Int = songCursor.getColumnIndex(MediaStore.Files.FileColumns.DATA)
            do {
                val _columnName: String = songCursor.getString(columnName)
                val _columnFormat: String = songCursor.getString(columnFormat)
                val _columnSize: String = songCursor.getString(columnSize)
                val _columnTime: String = songCursor.getString(columnTime)
                val _columnPath: String = songCursor.getString(columnPath)
                val document =
                    Document(_columnName, _columnFormat, _columnSize, _columnTime, _columnPath)
                list.add(document)
            } while (songCursor.moveToNext())
        }
    }


}