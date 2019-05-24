package com.example.groffersapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.myrow.*
import kotlinx.android.synthetic.main.row2.*

class Shopping: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.row2)

//        btnadd.setOnClickListener {
//           Toast.makeText(this,"Item Booked", Toast.LENGTH_SHORT).show()
//        }
        btnadd2.setOnClickListener {
            Toast.makeText(this,"Item Booked", Toast.LENGTH_SHORT).show()
        }



    }
}