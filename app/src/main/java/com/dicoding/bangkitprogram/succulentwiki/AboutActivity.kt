package com.dicoding.bangkitprogram.succulentwiki

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

//Rasyid Hafiz
//Bangkit Program 2021 Mobile Dev
//for study purpose
class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        val btnback: TextView = findViewById(R.id.backToMain)
        val Dicoding: ImageButton = findViewById(R.id.btn_dicoding)
        val Github: ImageButton = findViewById(R.id.btn_github)
        val Email: ImageButton = findViewById(R.id.btn_email)
        Dicoding.setOnClickListener(this)
        Github.setOnClickListener(this)
        Email.setOnClickListener(this)
        btnback.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_dicoding -> {
                val URLbase = "https://www.dicoding.com/users/holysyid"
                val ready = Intent(Intent.ACTION_VIEW, Uri.parse(URLbase))
                    startActivity(ready)
            }
            R.id.btn_github -> {
                val URLbase = "https://github.com/holysyid"
                val URLready = Intent(Intent.ACTION_VIEW, Uri.parse(URLbase))
                    startActivity(URLready)

            }
            R.id.btn_email -> {
                val emailtest = "holysyid@gmail.com"
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$emailtest"))
                startActivity(emailIntent)
            }
            R.id.backToMain->{
                val backIntent = Intent(this@AboutActivity, MainActivity::class.java)
                startActivity(backIntent)
            }

        }
    }
}