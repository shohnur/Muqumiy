package uz.muqimiy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.muqimiy.R

class GalleryAdapter(var jobs: ArrayList<String>?) :
    RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    var data = arrayListOf<Int>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(data: Int) {
            itemView.findViewById<ImageView>(R.id.g_image).setImageResource(data)
            if (jobs != null) {
                itemView.findViewById<TextView>(R.id.name).text = jobs!![adapterPosition]

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindData(data[position])

    override fun getItemCount(): Int = data.size
}