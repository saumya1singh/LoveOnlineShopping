package com.example.groffersapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.openlook.*
import java.util.*
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError


class Location : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.openlook)
        FirebaseApp.initializeApp(this)
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val userId = firebaseUser?.uid.toString()
        Log.e("UIDActivity", "UID is: $userId")
        val dbref = FirebaseDatabase.getInstance().reference
        btnloc.setOnClickListener {
            val s = editloc.text.toString()
            val rootNode = dbref.child(userId)
            val location = dbref.child(userId).child("Delivery Location").push().setValue(s)
            Toast.makeText(this, " Location Saved", Toast.LENGTH_SHORT).show()
        }
        btnnext.setOnClickListener {
            startActivity(Intent(baseContext, MainActivity::class.java))
        }
    }
}