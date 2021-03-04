package uz.muqimiy.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import uz.muqimiy.R
import uz.muqimiy.lyrics

class SubLyrics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_lyrics)
        val index = intent.getIntExtra("data", -1)
        supportActionBar!!.title = getString(R.string.asarlari)
        findViewById<TextView>(R.id.nameLy).text = lyrics[index].name
        findViewById<TextView>(R.id.textLy).text = lyrics[index].lyric
    }
}