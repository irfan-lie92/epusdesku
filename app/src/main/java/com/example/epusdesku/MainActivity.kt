package com.example.epusdesku

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var rvPerpuses: RecyclerView
    private val list : ArrayList<Perpus> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "Perpustakaan Desa"

        rvPerpuses = findViewById(R.id.rv_perpuss)
        rvPerpuses.setHasFixedSize(true)

        // Get Data from Object
        list.addAll(DataPerpus.listData)

        // Layout manager = LinearLayoutManager
        rvPerpuses.layoutManager = LinearLayoutManager(this)
        val listPerpusAdapter = ListPerpusAdapter(list)
        rvPerpuses.adapter = listPerpusAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_list -> {
                // Layout becomes LinearLayoutManager
                rvPerpuses.layoutManager = LinearLayoutManager(this)
                true
            }
            R.id.action_grid -> {
                // Layout becomes GridLayoutManager 2 block
                rvPerpuses.layoutManager = GridLayoutManager(this, 2)
                true
            }
            R.id.about -> {
                // Activitas from MainActivity to AboutActivity
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}