package com.example.groffersapp

import android.content.Context
import android.support.v4.app.FragmentManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.myrow.view.*
import android.content.Intent
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_description.*


class MyAdapter(val ewlist: ArrayList<MyArray>, val context: Context) : RecyclerView.Adapter<MyAdapter.MyHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        val inflatedview = LayoutInflater.from(context).inflate(R.layout.myrow, p0, false)
        return MyHolder(inflatedview)
    }

    override fun getItemCount(): Int {
        return ewlist.size
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        val current = ewlist[p1]
        with(p0.itemView) {
            names.text = current.name
            amounts.text = current.amount
            Picasso.get().load(current.url).into(img1)
            prices.text = current.price.toString()
            name2s.text = current.name1
            amount2s.text = current.amount1
            price2s.text = current.price1.toString()
            Picasso.get().load(current.url1).into(img2)
            FirebaseApp.initializeApp(context)
            val dbref = FirebaseDatabase.getInstance().reference
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            val userId = firebaseUser?.uid.toString()

//            Log.e("UIDActivity", "UID is: $userId")
//            val uidref = dbref.child(FirebaseAuth.getInstance().currentUser?.uid.toString())
//            Log.e("TAG", "UIDAdapter :" + FirebaseAuth.getInstance().currentUser?.uid)
            btnadd1.setOnClickListener {
                Log.e("TAG", "UIDAdapterClick :" + FirebaseAuth.getInstance().currentUser?.uid)
//                uidref.addListenerForSingleValueEvent(object : ValueEventListener {
//                    override fun onCancelled(p0: DatabaseError) {
//                    }
//
//                    override fun onDataChange(p0: DataSnapshot) {
//                        val s = current.name
//                        uidref.child("Selected Item").push().setValue(s)
//                    }
//
//                })
                val s = current.name
                val uidref=dbref.child(userId)
                uidref.child("Selected Item").push().setValue(s)
                Toast.makeText(context, "Your Item Added to Cart", Toast.LENGTH_SHORT).show()
            }
            btnadd2.setOnClickListener {
                Log.e("TAG", "UIDAdapterClick :" + FirebaseAuth.getInstance().currentUser?.uid)
                val st = name2s.text.toString()
                val uidref=dbref.child(userId)
                uidref.child("Selected Item").push().setValue(st)
                Toast.makeText(context, "Your item Saved to cart", Toast.LENGTH_SHORT).show()
            }
        }
    }

    class MyHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    }


}