package com.dicoding.bangkitprogram.succulentwiki

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar

import androidx.appcompat.app.AppCompatActivity


class Detailed : AppCompatActivity(), View.OnClickListener {

    private lateinit var currentImage: ImageView
    private lateinit var succulentName: TextView
    private lateinit var commonName: TextView
    private lateinit var succulentDetail: TextView
    private lateinit var sun_asp: TextView
    private lateinit var grow_asp: TextView
    private lateinit var water_asp: TextView
    private lateinit var temp_asp: TextView
    private lateinit var prop_asp: TextView
    private lateinit var tox_asp: TextView
    private lateinit var dor_asp: TextView



    companion object {

        const val DATA_PICT = "data_foto"
        const val POSITION_INDEX = ""
        const val DATA_NAME = "NAME"
        const val DATA_COMMNAME = "COMMNAME"
        const val DATA_DETAIL = "DETAIL"
        const val DATA_SUN = "SUN"
        const val DATA_GROW = "GROW"
        const val DATA_WATER = "WATER"
        const val DATA_TEMP = "TEMP"
        const val DATA_PROP ="PROP"
        const val DATA_TOX ="TOX"
        const val DATA_DOR="DOR"


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
        val btnbuy: Button = findViewById(R.id.buy)
        btnbuy.setOnClickListener(this)
        val btnBack: TextView = findViewById(R.id.backToMain)
        btnBack.setOnClickListener(this)
        setDataFiles()

    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.backToMain->{
                val backIntent = Intent(this@Detailed, MainActivity::class.java)
            startActivity(backIntent)
            }
            R.id.buy->{
                val halo = intent.getStringExtra(DATA_NAME)
                Toast.makeText(this, "$halo Will Be Coming Soon", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun setDataFiles() {

        succulentName = findViewById(R.id.sucname)
        commonName  =   findViewById(R.id.comname)
        succulentDetail = findViewById(R.id.detailed)
        sun_asp = findViewById(R.id.sunval)
        grow_asp = findViewById(R.id.growval)
        water_asp = findViewById(R.id.waterval)
        temp_asp = findViewById(R.id.tempval)
        prop_asp = findViewById(R.id.propval)
        tox_asp = findViewById(R.id.toxval)
        dor_asp = findViewById(R.id.dorval)

        val dataImage = intent.getIntExtra(DATA_PICT, 0)
        currentImage = findViewById(R.id.image_placeholder)
        currentImage.setImageResource(dataImage)
        succulentName.text=intent.getStringExtra(DATA_NAME)
        commonName.text=intent.getStringExtra(DATA_COMMNAME)
        succulentDetail.text=intent.getStringExtra(DATA_DETAIL)
        sun_asp.text=intent.getStringExtra(DATA_SUN)
        grow_asp.text=intent.getStringExtra(DATA_GROW)
        water_asp.text=intent.getStringExtra(DATA_WATER)
        temp_asp.text=intent.getStringExtra(DATA_TEMP)
        prop_asp.text=intent.getStringExtra(DATA_PROP)
        tox_asp.text=intent.getStringExtra(DATA_TOX)
        dor_asp.text=intent.getStringExtra(DATA_DOR)
    }



}