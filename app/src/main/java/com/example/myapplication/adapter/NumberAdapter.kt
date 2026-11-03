package com.example.listhomework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listhomework.R

class NumberAdapter :
    ListAdapter<Int, NumberAdapter.NumberViewHolder>(DiffCallback()) {

    class NumberViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val numberText: TextView =
            itemView.findViewById(R.id.numberText)

        fun bind(number: Int) {
            numberText.text = number.toString()

            @ColorRes val colorRes = if (number % 2 == 0) {
                R.color.even_item
            } else {
                R.color.odd_item
            }

            itemView.setBackgroundColor(
                itemView.context.getColor(colorRes)
            )
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumberViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_number, parent, false)

        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: NumberViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<Int>() {

        override fun areItemsTheSame(
            oldItem: Int,
            newItem: Int
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Int,
            newItem: Int
        ): Boolean {
            return oldItem == newItem
        }
    }
}