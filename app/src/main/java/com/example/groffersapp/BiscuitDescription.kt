package com.example.groffersapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_description.*
import java.io.IOException

class BiscuitDescription : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biscuit_description)

        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val userId = firebaseUser?.uid.toString()
        Log.e("UIDActivity", "UID is: $userId")
        val dbref = FirebaseDatabase.getInstance().reference
        btncart.setOnClickListener {
            val s = tvname.text.toString()
            try {
                val rootnode = dbref.child(userId)
                rootnode.child("Selected Item").push().setValue(s)
            }catch (e: IOException){
                e.printStackTrace()
            }

            Toast.makeText(this, "Your Item Saved to Cart", Toast.LENGTH_SHORT).show()
        }
        val fragmentlist = arrayListOf<Fragment>()
        fragmentlist.add(FragmentBiscuit())
        fragmentlist.add(FragmentB())
        val pagerAdapter = PagerAdapter(fragmentlist, supportFragmentManager)
        viewpager.adapter = pagerAdapter
    }
}
