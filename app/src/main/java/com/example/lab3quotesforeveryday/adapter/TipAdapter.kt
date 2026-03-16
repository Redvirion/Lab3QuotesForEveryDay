package com.example.lab3quotesforeveryday.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3quotesforeveryday.R
import com.example.lab3quotesforeveryday.data.Tip

class TipAdapter(
    private val tips: List<Tip>,
    private val onItemClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDay: TextView = itemView.findViewById(R.id.tvDay)
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        private val ivTip: ImageView = itemView.findViewById(R.id.ivTip)
        private val tvShortDesc: TextView = itemView.findViewById(R.id.tvShortDesc)

        fun bind(tip: Tip, listener: (Tip) -> Unit) {
            tvDay.text = itemView.context.getString(R.string.day_number, tip.dayNumber)
            tvTitle.text = tip.title
            ivTip.setImageResource(tip.imageResId)
            tvShortDesc.text = tip.shortDescription
            itemView.setOnClickListener { listener(tip) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(tips[position], onItemClick)
    }

    override fun getItemCount() = tips.size
}