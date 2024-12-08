package com.example.labrview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val songList = listOf(
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24),
            Song("No Hay Ley", "Kali Uchis", R.drawable.baseline_library_music_24)
        )

        val adapter = SongAdapter(this, songList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}