package com.example.lab3quotesforeveryday.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3quotesforeveryday.R
import com.example.lab3quotesforeveryday.adapter.TipAdapter
import com.example.lab3quotesforeveryday.data.Tip

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val tips = generateTips()
        val adapter = TipAdapter(tips) { tip ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("tip", tip)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }

    private fun generateTips(): List<Tip> {
        val authors = resources.getStringArray(R.array.authors)
        val shortQuotes = resources.getStringArray(R.array.short_quotes)
        val fullQuotes = resources.getStringArray(R.array.full_quotes)

        return List(30) { index ->
            val imageId = resources.getIdentifier("day_${index + 1}", "drawable", packageName)
            Tip(
                dayNumber = index + 1,
                title = authors[index],
                shortDescription = shortQuotes[index],
                imageResId = imageId,
                fullDescription = fullQuotes[index]
            )
        }
    }
}