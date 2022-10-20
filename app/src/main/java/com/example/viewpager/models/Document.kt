package com.example.viewpager.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "document_table")
data class Document(
    @ColumnInfo(name = "name")
    val _name: String? = null,
    @ColumnInfo(name = "format")
    val _format: String? = null,
    @ColumnInfo(name = "size")
    val _size: String? = null,
    @ColumnInfo(name = "time")
    val _time: String? = null,
    @ColumnInfo(name = "path")
    val _path: String? = null,

    @PrimaryKey(autoGenerate = true) var id: Int = 0
)