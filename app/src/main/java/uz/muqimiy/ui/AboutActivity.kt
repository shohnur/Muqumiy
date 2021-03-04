package uz.muqimiy.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import uz.muqimiy.R
import uz.muqimiy.aboutMuqumiy

class AboutActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar!!.title=getString(R.string.hayoti_va_ijodi)
        findViewById<TextView>(R.id.about_text).text= "      ${aboutMuqumiy.replace("@","\n      ")}"

    }
}