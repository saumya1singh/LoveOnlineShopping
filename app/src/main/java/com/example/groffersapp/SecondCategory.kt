package com.example.groffersapp


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second_category.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SecondCategory : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        img1.setOnClickListener {
            startActivity(Intent(context, BiscuitDescription::class.java))
        }

        img2.setOnClickListener {
            startActivity(Intent(context, BiscuitDescription::class.java))
        }

        img1.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }

        img1.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }

        img1.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }

        img1.setOnClickListener {
            startActivity(Intent(context, Description::class.java))
        }

    }

}
