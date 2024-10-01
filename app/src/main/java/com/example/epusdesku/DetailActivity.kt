package com.example.epusdesku

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESA = "extra_desa"
        const val EXTRA_TAHUN = "extra_tahun"
        const val EXTRA_PEMUSTAKA = "extra_pemustaka"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_IMAGE = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Perpustakaan"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvPerpusName: TextView = findViewById(R.id.tv_perpus_name)
        val tvPerpusDesa: TextView = findViewById(R.id.tv_perpus_desa)
        val tvPerpusTahun: TextView = findViewById(R.id.tv_perpus_tahun)
        val tvPerpusPemustaka: TextView = findViewById(R.id.tv_perpus_pemustaka)
        val tvPerpusDescription: TextView = findViewById(R.id.tv_perpus_description)
        val imgPerpus: ImageView = findViewById(R.id.img_perpus)
        val shareButton: Button = findViewById(R.id.share_button) // Inisialisasi shareButton
        val favButton: ImageView = findViewById(R.id.fav_button)

        var fav = false

        val perpusNama = intent.getStringExtra(EXTRA_NAME)
        val perpusDesa = intent.getStringExtra(EXTRA_DESA)
        val perpusTahun = intent.getIntExtra(EXTRA_TAHUN, 0).toString()
        val perpusPemustaka = intent.getStringExtra(EXTRA_PEMUSTAKA)
        val perpusDescription = intent.getStringExtra(EXTRA_DESCRIPTION)
        val perpusImage = intent.getIntExtra(EXTRA_IMAGE, R.drawable.pasayangan)

        tvPerpusName.text = perpusNama
        tvPerpusDesa.text = perpusDesa
        tvPerpusTahun.text = perpusTahun
        tvPerpusPemustaka.text = perpusPemustaka
        tvPerpusDescription.text = perpusDescription
        imgPerpus.setImageResource(perpusImage)

        favButton.setOnClickListener {
            fav = if (!fav) {
                Toast.makeText(this, "Follow", Toast.LENGTH_SHORT).show()
                favButton.setImageResource(R.drawable.vector_favorite)
                true
            } else {
                Toast.makeText(this, "Unfollow", Toast.LENGTH_SHORT).show()
                favButton.setImageResource(R.drawable.vector_favorite_border)
                false
            }
        }

        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.setPackage("com.instagram.android")
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Checkout this library: ${tvPerpusName.text}")

            try {
                startActivity(shareIntent)
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(this, "Instagram not installed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}