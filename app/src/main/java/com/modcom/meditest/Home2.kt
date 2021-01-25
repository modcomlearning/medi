package com.modcom.meditest

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.CollapsingToolbarLayout

class Home2 : AppCompatActivity() {
    lateinit var gridView: GridView
    private var playerNames = arrayOf("Laboratory", "Phamacy", "Consultation", "Home Care")
    private var playerImages = intArrayOf(R.mipmap.doc, R.mipmap.doc, R.mipmap.doc,
        R.mipmap.doc)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home3)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = "Meditest"

        gridView = findViewById(R.id.grid)
        val mainAdapter = CustomAndroidGridViewAdapter(this@Home2, playerNames, playerImages)
        gridView.adapter = mainAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val i = Intent(this@Home2, MainActivity::class.java)
            startActivity(i)

            Toast.makeText(
                applicationContext, "You CLicked " + playerNames[+position],
                Toast.LENGTH_SHORT
            ).show()
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

        }
    }
}