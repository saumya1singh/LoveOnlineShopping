package com.example.groffersapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.Transaction
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

class Welcome : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long =5000000
    private var mDelayHandler: Handler? = null
    private lateinit var animate:Animation
    private val USER_LOCATION_REQUEST_CODE = 1000
    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, Location::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        //Initialize the Handler
        mDelayHandler = Handler()
        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable,SPLASH_TIME_OUT)
        val animate= AnimationUtils.loadAnimation(this,R.anim.animate)
        btn.animation=animate
        val firebaseUser = FirebaseAuth.getInstance().currentUser
        linear.setOnClickListener {
            if (firebaseUser != null) {
                val i = Intent(baseContext, Location::class.java)
                startActivity(i)

            } else {
                startActivityForResult(
                        AuthUI.getInstance()
                                .createSignInIntentBuilder()
                                .setIsSmartLockEnabled(false)
                                .setAvailableProviders(Arrays.asList(
                                        AuthUI.IdpConfig.GoogleBuilder().build(),
                                        AuthUI.IdpConfig.PhoneBuilder().build()))
                                .build(),
                        USER_LOCATION_REQUEST_CODE)
            }
        }
    }
    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == USER_LOCATION_REQUEST_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            // Successfully signed in
            if (resultCode == Activity.RESULT_OK) {
                val i = Intent(baseContext, Location::class.java)
                startActivity(i)
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    return
                }
                if (response.error!!.errorCode == ErrorCodes.NO_NETWORK) {

                    return
                }
            }
        }
    }

//    override fun onStop() {
//        super.onStop()
//        FirebaseAuth.getInstance().signOut()
//    }


}

