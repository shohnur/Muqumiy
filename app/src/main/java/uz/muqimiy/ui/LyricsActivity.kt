package uz.muqimiy.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import uz.muqimiy.R
import uz.muqimiy.adapter.LyricsAdapter
import uz.muqimiy.lyrics

class LyricsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lyrics)
        supportActionBar!!.title = getString(R.string.asarlari)

        val list = findViewById<RecyclerView>(R.id.list)
        val adapter = LyricsAdapter()
        list.adapter = adapter
        adapter.data = lyrics

        adapter.onLyricSelected = object : LyricsAdapter.OnLyricSelected {
            override fun onSelect(index: Int) {
                val intent = Intent(this@LyricsActivity, SubLyrics::class.java)
                intent.putExtra("data", index)
                startActivity(intent)
            }
        }
    }
}