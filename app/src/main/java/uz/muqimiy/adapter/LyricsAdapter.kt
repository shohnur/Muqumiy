package uz.muqimiy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.muqimiy.R
import uz.muqimiy.model.LyricsData

class LyricsAdapter : RecyclerView.Adapter<LyricsAdapter.DataViewHolder>() {

    var data = arrayListOf<LyricsData>()
        set(v) {
            field.clear()
            field.addAll(v)
            notifyDataSetChanged()
        }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindData(data: LyricsData) {
            itemView.findViewById<TextView>(R.id.name_of_lyric).text = data.name
            itemView.setOnClickListener {
                onLyricSelected?.onSelect(adapterPosition)
            }
        }
    }

    var onLyricSelected: OnLyricSelected? = null

    interface OnLyricSelected {
        fun onSelect(index: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_lyrics, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bindData(data[position])

    override fun getItemCount(): Int = data.size
}