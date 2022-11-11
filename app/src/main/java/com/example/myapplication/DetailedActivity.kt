package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class DetailedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val serials = intent.getParcelableExtra<Serials>("serials")
        if (serials != null){
            val textView : TextView = findViewById(R.id.detailedActivityTv)
            val imageView : ImageView = findViewById(R.id.detailedActivityIv)
            val description : TextView = findViewById(R.id.description)

            textView.text = serials.name
            imageView.setImageResource(serials.image)

            //Glide
            val url = "https://ic.pics.livejournal.com/sewa7/16446669/18928/18928_600.jpg"
            if(serials.name == "Queens gambit") {
                Glide.with(this)
                    .load(url)
                    .into(imageView)

            }

            val name = serials.name

            val result = when (name){
                "Breaking bad" -> getString(R.string.breaking_bad)
                "Paper house" -> getString(R.string.paper_house)
                "Peaky blinders" -> getString(R.string.peaky_blinders)
                "Queens gambit" -> getString(R.string.queens_gambit)
                "Witcher" -> getString(R.string.witcher)
                else -> "Invalid"
            }

            description.text = result

        }

    }
}