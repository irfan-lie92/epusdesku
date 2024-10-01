package com.example.epusdesku

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATION")
class AboutActivity : AppCompatActivity() {
    private lateinit var instagram: ImageView
    private lateinit var linkedin: ImageView
    private lateinit var github: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val actionBar = supportActionBar
        actionBar!!.title = "About"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        instagram = findViewById(R.id.instagram)
        linkedin = findViewById(R.id.linkedin)
        github = findViewById((R.id.github))

        instagram.setOnClickListener {
            openInstagram()
        }

        linkedin.setOnClickListener {
            openLinkedIn()
        }

        github.setOnClickListener {
            openGitHub()
        }
    }

    private fun openInstagram() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/irfan_lie92"))
        startActivity(intent)
    }

    private fun openLinkedIn() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/irfan-lie92"))
        startActivity(intent)
    }

    private fun openGitHub() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/irfan-lie92"))
        startActivity(intent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    @Suppress("UNUSED_PARAMETER")
    fun openInstagram(view: View) {}

    @Suppress("UNUSED_PARAMETER")
    fun openLinkedIn(view: View) {}

    @Suppress("UNUSED_PARAMETER")
    fun openGitHub(view: View) {}

}