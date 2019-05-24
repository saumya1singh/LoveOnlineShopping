package com.example.groffersapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.groffersapp.CategoriesOfItems.UpdatedCategory
import kotlinx.android.synthetic.main.activity_main.*

import com.firebase.ui.auth.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {

    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("Delivery Location")

    val myArray = arrayListOf<MyArray>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val s = searchEditText.text.toString()

        myArray.add(MyArray("Tata Salt", 17, "a kg", "http://im.rediff.com/news/2014/aug/12tata-salt.jpg", "Arhar dal", 79, "1kg", "https://rukminim1.flixcart.com/image/704/704/j8rnpu80/pulses/q/g/w/500-toor-dal-arhar-dal-desi-arhar-dal-un-branded-original-imaeymjgrjw8xgvw.jpeg?q=70"))

        myArray.add(MyArray("Surf Excel", 84, "a kg", "http://3.bp.blogspot.com/-7mLh_eWQBKI/UhZnYcigO7I/AAAAAAAAAAM/1EBGnuov8DA/s1600/266951_2-surf-excel-quick-wash-detergent-powder-with-x-tra-clean-particles.jpg", "Fiama Dwills", 79, "1kg", "https://www.deobazaar.com/admin/product_image/Fiama_Di_Wills_Aqua_Nights_Bathing_Bar.jpg"))

        myArray.add(MyArray("Maggi Masala", 17, "a kg", "https://s1.ibtimes.com/sites/www.ibtimes.com/files/styles/lg/public/2015/06/03/maggi.jpg", "Taj Mahal", 79, "1kg", "http://www.desimart.com/image/cache/data/taj_mahal_tea_bags_100-500x500.jpg"))

        cashback.setOnClickListener {
            startActivity(Intent(baseContext, CategoryActivity::class.java))
        }
        searchicon.setOnClickListener {
            val string = searchEditText.text.toString()
            Toast.makeText(baseContext, "$string is out of stock", Toast.LENGTH_SHORT).show()
        }
        cartbtn.setOnClickListener {
            startActivity(Intent(baseContext, Cart::class.java))
        }

        val firebaseUser = FirebaseAuth.getInstance().currentUser
        val userId = firebaseUser?.uid.toString()
        val email=firebaseUser?.email.toString()
        val phone=firebaseUser?.phoneNumber.toString()
        Log.e("TAG", "OnMainActivity UID is : $userId")
        val dbref = FirebaseDatabase.getInstance().reference
        val rootNode = dbref.child(userId)

        btncurrent.setOnClickListener {

             rootNode.child("Delivery Location").addChildEventListener(object:ChildEventListener{
                 override fun onCancelled(p0: DatabaseError) {
                     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                 }

                 override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                 }

                 override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                 }

                 override fun onChildRemoved(p0: DataSnapshot) {
                     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                 }

                 override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                     val s=p0.getValue(String::class.java).toString()
                     tvlocation.text=s
                 }

             })
        }

        btnseeall.setOnClickListener {
            startActivity(Intent(baseContext, CategoryActivity::class.java))
        }
        btncatogory.setOnClickListener {
            startActivity(Intent(baseContext, UpdatedCategory::class.java))
        }

        val myadapter = MyAdapter(myArray, this)
        mainrecycler.adapter = myadapter
        mainrecycler.layoutManager = LinearLayoutManager(this)
    }
}
