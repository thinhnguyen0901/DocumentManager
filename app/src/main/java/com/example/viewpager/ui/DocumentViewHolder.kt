package com.example.viewpager.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager.R
import com.example.viewpager.databinding.ItemPageBinding
import com.example.viewpager.models.Document

class DocumentViewHolder(
    private val binding: ItemPageBinding,
    private val documentListener: DocumentListener
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup, documentListener: DocumentListener): DocumentViewHolder {
            val itemView =
                ItemPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return DocumentViewHolder(itemView, documentListener)
        }
    }

    fun bind(document: Document) {
        with(binding) {
            tvName.text = document._name
            tvFormat.text = document._format
            tvTime.text = document._time
            tvSize.text = document._size
            tvPath.text = document._path
            if (tvFormat.text.toString() == "3") {
                ivIcon.setImageResource(R.drawable.ic_baseline_all_inbox_24)
            } else {
                ivIcon.setImageResource(R.drawable.ic_baseline_airline_seat_recline_extra_24)
            }


            container.setOnClickListener {
                documentListener.onDetail(document,)
            }
        }

    }
}
