package com.example.groffersapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_main.*

class Cart : AppCompatActivity() {
    val items=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val arrayAdapter= ArrayAdapter<String>(this,R.layout.listitem,R.id.tvlist,items)
        listview.adapter=arrayAdapter
        btnitems.setOnClickListener {
            val databaseref = FirebaseDatabase.getInstance().reference.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).child("Selected Item")
            databaseref.addChildEventListener(object : ChildEventListener {
                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {

                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {

                }

                override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                    val item = p0.getValue(String::class.java).toString()
                        items.add(item)
                    arrayAdapter.notifyDataSetChanged()

                }

                override fun onChildRemoved(p0: DataSnapshot) {

                }

            })
        }
        buttonshop.setOnClickListener {

            startActivity(Intent(baseContext, CategoryActivity::class.java))
        }
    }
}
