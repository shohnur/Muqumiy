package uz.muqimiy.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import uz.muqimiy.R

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        supportActionBar!!.title = getString(R.string.gallery)

        findViewById<CardView>(R.id.gallery_muqimiy).setOnClickListener {
            val intent = Intent(this, SubGallery::class.java)
            intent.putExtra("data", 1)
            startActivity(intent)
        }

        findViewById<CardView>(R.id.gallery_teatr).setOnClickListener {
            val intent = Intent(this, SubGallery::class.java)
            intent.putExtra("data", 2)
            startActivity(intent)
        }

        findViewById<CardView>(R.id.gallery_muqimiyshunoslar).setOnClickListener {
            val intent = Intent(this, SubGallery::class.java)
            intent.putExtra("data", 3)
            startActivity(intent)
        }

        findViewById<CardView>(R.id.gallery_exp).setOnClickListener {
            val intent = Intent(this, SubGallery::class.java)
            intent.putExtra("data", 4)
            startActivity(intent)
        }

    }
}