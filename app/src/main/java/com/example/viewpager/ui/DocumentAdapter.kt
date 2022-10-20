package com.example.viewpager.ui

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.viewpager.models.Document


class DocumentAdapter(
    private val list: MutableList<Document>?,
    private val documentListener: DocumentListener
) :
    RecyclerView.Adapter<DocumentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentViewHolder {
        return DocumentViewHolder.create(parent, documentListener)
    }

    override fun onBindViewHolder(holder: DocumentViewHolder, position: Int) {
        list?.let { holder.bind(list[position]) }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: MutableList<Document>) {
        list?.clear()
        list?.addAll(newList)
        notifyDataSetChanged()
    }


}

