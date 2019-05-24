package com.example.groffersapp

import android.content.Context
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.myrow.view.*
import kotlinx.android.synthetic.main.myrow.view.img1
import kotlinx.android.synthetic.main.myrow.view.img2
import kotlinx.android.synthetic.main.row2.view.*

class CategoryAdapter(val ewlist: ArrayList<Model>, val context: Context):RecyclerView.Adapter<CategoryAdapter.CategoryHolder>(){


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CategoryHolder {
        val inflatedview = LayoutInflater.from(context).inflate(R.layout.myrow, p0, false)
        return CategoryHolder(inflatedview)
    }

    override fun getItemCount(): Int {
    return  ewlist.size
    }

    override fun onBindViewHolder(p0: CategoryHolder, p1: Int) {
        val current = ewlist[p1]
        with(p0.itemView) {

           names.text=current.name
            amounts?.text = current.amount
            Log.e("TAG","Product name ${current.name}")
            Picasso.get().load(current.url).into(img1)
            price?.text = current.price
            name2?.text = current.names
            amount2?.text = current.amounts
            price2?.text = current.prices.toString()
            Picasso.get().load(current.urls).into(img2)
            val dbref = FirebaseDatabase.getInstance().reference
            val firebaseUser = FirebaseAuth.getInstance().currentUser
            val userId = firebaseUser?.uid.toString()

            btnadd1.setOnClickListener {
                Log.e("TAG", "UIDAdapterClick :" + FirebaseAuth.getInstance().currentUser?.uid)
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

    class CategoryHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }


}


