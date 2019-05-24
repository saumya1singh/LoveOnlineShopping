package com.example.groffersapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.myrow.view.*

class CategoryActivity : AppCompatActivity() {
       val firelist= arrayListOf<Model>()

      val myArray= arrayListOf<MyArray>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
//        myArray.add(MyArray("Tata Salt", 17, "a kg" , "http://im.rediff.com/news/2014/aug/12tata-salt.jpg" , "Arhar dal", 79 , "1kg" , "https://rukminim1.flixcart.com/image/704/704/j8rnpu80/pulses/q/g/w/500-toor-dal-arhar-dal-desi-arhar-dal-un-branded-original-imaeymjgrjw8xgvw.jpeg?q=70"))
//
//        myArray.add(MyArray("Surf Excel", 17, "a kg" , "http://3.bp.blogspot.com/-7mLh_eWQBKI/UhZnYcigO7I/AAAAAAAAAAM/1EBGnuov8DA/s1600/266951_2-surf-excel-quick-wash-detergent-powder-with-x-tra-clean-particles.jpg" , "Arhar dal", 79 , "1kg" , "https://3.bp.blogspot.com/-DKdKLQVAYcA/U8jd1yql0EI/AAAAAAABX7s/KezlLCc5Dfg/s640/Naturalite_packaging+suggestion+a.jpg"))
//
//        myArray.add(MyArray("Maggi Masala", 17, "a kg", "https://s1.ibtimes.com/sites/www.ibtimes.com/files/styles/lg/public/2015/06/03/maggi.jpg", "Arhar dal", 79, "1kg", "https://www.deobazaar.com/admin/product_image/Fiama_Di_Wills_Aqua_Nights_Bathing_Bar.jpg"))
//
//
//        myArray.add(MyArray("Tata Salt", 17, "a kg" , "http://im.rediff.com/news/2014/aug/12tata-salt.jpg" , "Tajmahal Tea", 79 , "1kg" , "http://www.desimart.com/image/cache/data/taj_mahal_tea_bags_100-500x500.jpg"))

        val myadapter = CategoryAdapter(firelist, this)
        rv.adapter = myadapter
        rv.layoutManager = LinearLayoutManager(this)
        val dbref = FirebaseDatabase.getInstance().reference.child("Items")
        dbref.addChildEventListener(object : ChildEventListener {
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
                val item: Model? = p0.getValue(Model::class.java)
                if (item != null) {
                    firelist.add(item)
                }
                myadapter.notifyDataSetChanged()
            }

        })

        btncart.setOnClickListener {
            startActivity(Intent(baseContext, Cart::class.java))
        }
//        val myadapter = MyAdapter(myArray, this)
//        rv.adapter=myadapter
//        rv.layoutManager=LinearLayoutManager(this)
    }

//    private fun logRecycler() {
//        val mAdapter = object : FirebaseRecyclerAdapter<Model, CategoryViewHolder>(Model::class.java,
//                R.layout.myrow,
//               CategoryViewHolder::class.java,
//                mReference) {
//            override fun populateViewHolder(viewHolder: CategoryViewHolder?, model: Model?, position: Int) {
//
//                viewHolder?.setDetails(baseContext,model?.name.toString(),model?.price.toString(),model?.amount.toString(),model?.url.toString(),
//                        model?.name1.toString(), model?.price1.toString(), model?.amount1.toString(), model?.url1.toString() )
//                recyclerView.adapter=mAdapter
//                recyclerView.layoutManager=LinearLayoutManager(baseContext)
//            }
//        }
//        recyclerView.layoutManager=LinearLayoutManager(this)
//        recyclerView.adapter=mAdapter
//    }



}





