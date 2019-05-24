package com.example.groffersapp


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_salt.*


/**
 * A simple [Fragment] subclass.
 */
class SaltFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_salt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        im1.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }
        im2.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }
        im3.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }
        im4.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }
        im5.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }
        im6.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }
    }
}
