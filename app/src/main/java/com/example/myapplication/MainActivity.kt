package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var serialsList: ArrayList<Serials>
    private lateinit var serialsAdapter: SerialsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        serialsList = ArrayList()

        serialsList.add(Serials(R.drawable.breaking_bad, "Breaking bad"))
        serialsList.add(Serials(R.drawable.paper_house, "Paper house"))
        serialsList.add(Serials(R.drawable.peaky_blinders, "Peaky blinders"))
        serialsList.add(Serials(R.drawable.queens_gambit, "Queens gambit"))
        serialsList.add(Serials(R.drawable.witcher, "Witcher"))

        serialsAdapter = SerialsAdapter(serialsList)
        recyclerView.adapter = serialsAdapter

        serialsAdapter.onItemClick = {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("serials", it)
            startActivity(intent)
        }

    }
}