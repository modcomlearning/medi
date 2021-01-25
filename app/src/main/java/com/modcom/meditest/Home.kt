package com.modcom.meditest

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout


class Home : AppCompatActivity() {
    lateinit var gridView: GridView
    private var playerNames = arrayOf("Cristiano Ronaldo", "Joao Felix", "Bernado Silva", "Andre    Silve")
    private var playerImages = intArrayOf(R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = "Meditest"

        gridView = findViewById(R.id.grid)
        val mainAdapter = CustomAndroidGridViewAdapter(this@Home, playerNames, playerImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->



            Toast.makeText(
                applicationContext, "You CLicked " + playerNames[+position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}