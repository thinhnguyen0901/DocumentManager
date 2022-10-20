package com.example.viewpager.ui

import com.example.viewpager.models.Document

interface DocumentListener {
    fun onDetail(document: Document)
}