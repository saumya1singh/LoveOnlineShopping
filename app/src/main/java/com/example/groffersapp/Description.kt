package com.example.groffersapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_description.*
import android.R.attr.phoneNumber
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import java.io.IOException

class Description : AppCompatActivity() {
    private final val TAG = "Description Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        FirebaseApp.initializeApp(this)

        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val userId = firebaseUser?.uid.toString()
        Log.e("UIDActivity", "UID is: $userId")
        val dbref = FirebaseDatabase.getInstance().reference
        btncart.setOnClickListener {
            val s = tvname.text.toString()
            try {
                val rootnode = dbref.child(userId)
                rootnode.child("Selected Item").push().setValue(s)
            }catch (e:IOException){
                e.printStackTrace()
            }
            Toast.makeText(this, "Your Item Saved to Cart", Toast.LENGTH_SHORT).show()
        }
        val fragmentlist = arrayListOf<Fragment>()
        fragmentlist.add(FragmentA())
        fragmentlist.add(FragmentB())
        val pagerAdapter = PagerAdapter(fragmentlist, supportFragmentManager)
        viewpager.adapter = pagerAdapter
    }

//    private fun getIncoming() {
//
//        Log.d(TAG, " checking intents")
//        if (intent.hasExtra("name1") && intent.hasExtra("amount1") && intent.hasExtra("price1"))
//        {
//            val name=intent.getStringArrayExtra("name1")
//            val amount=intent.getStringArrayExtra("amount1")
//            val price=intent.getStringArrayExtra("price1")
//
//            setValue(name, amount, price)
//        }
//    }
//
//    private fun setValue(name: Array<out String>?, amount: Array<out String>?, price: Array<out String>?) {
//     tvnmae.text=name.toString()
//        tvprice.text=price.toString()
//        tvamount.text=amount.toString()
//
//    }  //getting intent of a new activity
}
