package com.example.lab3quotesforeveryday.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3quotesforeveryday.R
import com.example.lab3quotesforeveryday.data.Tip

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tip = intent.getParcelableExtra<Tip>("tip") ?: return

        findViewById<TextView>(R.id.tvDetailDay).text = getString(R.string.day_number, tip.dayNumber)
        findViewById<TextView>(R.id.tvDetailTitle).text = tip.title
        findViewById<ImageView>(R.id.ivDetail).setImageResource(tip.imageResId)
        findViewById<TextView>(R.id.tvDetailFull).text = tip.fullDescription
    }
}