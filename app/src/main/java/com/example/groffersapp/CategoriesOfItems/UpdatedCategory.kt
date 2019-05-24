package com.example.groffersapp.CategoriesOfItems

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.groffersapp.R
import com.example.groffersapp.SaltFragment
import com.example.groffersapp.SecondCategory
import kotlinx.android.synthetic.main.activity_updated_category.*

class UpdatedCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updated_category)

        personalcare.setOnClickListener {
            val saltFragment = SaltFragment()
            val fragmentManager=supportFragmentManager
            val transaction= supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragcontainer , saltFragment)
            transaction.commit()
        }
        Breakfast.setOnClickListener {
            val secondCategory = SecondCategory()
            val fragmentManager=supportFragmentManager
            val transaction= supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragcontainer ,secondCategory)
            transaction.commit()
        }
    }
}
