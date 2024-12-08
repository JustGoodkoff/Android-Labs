package com.example.labrview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.song_title)
    private val author: TextView = itemView.findViewById(R.id.song_author)
    private val picture: ImageView = itemView.findViewById(R.id.song_picture)


    fun bind(song: Song) {
        title.text = song.title
        author.text = song.author
        picture.setImageResource(song.pictureResId)
    }

}

