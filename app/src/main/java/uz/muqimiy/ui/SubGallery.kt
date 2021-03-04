package uz.muqimiy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.muqimiy.*
import uz.muqimiy.adapter.GalleryAdapter

class SubGallery : AppCompatActivity() {

    private lateinit var list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_gallery)
        supportActionBar!!.title = getString(R.string.gallery)

        when (intent.getIntExtra("data", 0)) {
            1 -> {
                val adapter = GalleryAdapter(null)
                list = findViewById(R.id.list_images)
                list.adapter = adapter
                list.layoutManager = GridLayoutManager(this, 2)
                adapter.data = gMuqimiy
            }
            2 -> {
                val adapter = GalleryAdapter(null)
                list = findViewById(R.id.list_images)
                list.adapter = adapter
                list.layoutManager = GridLayoutManager(this, 2)
                adapter.data = gTeatr
            }
            3 -> {
                val adapter = GalleryAdapter(jobs)
                list = findViewById(R.id.list_images)
                list.adapter = adapter
                list.layoutManager = LinearLayoutManager(this)
                adapter.data = gMuqimiyshunoslar
            }
            4 -> {
                val adapter = GalleryAdapter(null)
                list = findViewById(R.id.list_images)
                list.adapter = adapter
                list.layoutManager = GridLayoutManager(this, 2)
                adapter.data = gExp
            }
        }

    }
}