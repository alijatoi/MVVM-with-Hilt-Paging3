package com.example.paging3library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class QuotePagingAdapter : PagingDataAdapter<Results, QuotePagingAdapter.QuoteViewHolder>(COMPARATOR) {

        class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val quote = itemView.findViewById<TextView>(R.id.quote)
        }

        override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
            val item = getItem(position)
            if (item != null) {
                holder.quote.text = item.content
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false)
            return QuoteViewHolder(view)
        }

        companion object {
            private val COMPARATOR = object : DiffUtil.ItemCallback<Results>() {
                override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
                    return oldItem == newItem
                }
            }
        }

}