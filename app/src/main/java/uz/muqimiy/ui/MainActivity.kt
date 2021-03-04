package uz.muqimiy.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import uz.muqimiy.Dialog
import uz.muqimiy.R

class MainActivity : AppCompatActivity() {

    private lateinit var mAbout: TextView
    private lateinit var mGallery: TextView
    private lateinit var mLyrics: TextView
    private lateinit var mMore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadViews()
        loadListeners()
    }

    private fun loadListeners() {
        mAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        mLyrics.setOnClickListener {
            startActivity(Intent(this, LyricsActivity::class.java))
        }
        mGallery.setOnClickListener {
            startActivity(Intent(this, GalleryActivity::class.java))
        }
        mMore.setOnClickListener {
            val dialog = Dialog(this)
            dialog.onClickListener = object : Dialog.OnClickListener {
                override fun onSite() {
                    try {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://www.muqimiymerosi.uz")
                            )
                        )
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.error_message),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

                override fun onTelegram() {
                    try {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://t.me/muqimiyshunoslar")
                            )
                        )
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(
                            this@MainActivity,
                            getString(R.string.error_message),
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
            dialog.show()
        }
    }

    private fun loadViews() {
        mAbout = findViewById(R.id.m_about)
        mGallery = findViewById(R.id.m_gallery)
        mLyrics = findViewById(R.id.m_lyrics)
        mMore = findViewById(R.id.m_more)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_us -> {

                val dialog = AlertDialog.Builder(this)
                dialog.setTitle("Dastur haqida")
                dialog.setMessage("“Muqimiy” mobil ilovasi - Muhammad  Aminxo'ja Muqimiyning adabiy merosini yoshlar oʼrtasida ommalashtirish va adib ijodiyotidan bahra olishlarini soddalashtirish va erkinlashtirish, shuningdek adib hayoti va ijodini yoritish maqsadida yaratilgan. Mazkur mobil ilova muallifi - Toshkent davlat iqtisodiyot universitetining 2-bosqich magistranti Roʼziqulov Abdimoʼmin Qussam oʼgʼli hisoblanadi.")
                dialog.setNegativeButton("Qaytish") { d, _ ->
                    d.cancel()
                }
                dialog.setCancelable(false)
                dialog.show()

            }
            R.id.baho -> {
                try {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store")
                        )
                    )
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.error_message),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            R.id.contact -> {
                try {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://tsue.uz/uz/")
                        )
                    )
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.error_message),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}