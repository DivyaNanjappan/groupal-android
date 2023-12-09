/*
 * Copyright 2023. All rights reserved.
 * Dissemination of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Divya N.
 *
 * Created by Divya N
 */

package com.groupal.design

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.groupal.design.databinding.ActivitySplashScreenBinding
import com.groupal.design.ui.MainActivity
import com.groupal.design.utils.startAppActivityClear

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launchIntent()
    }

    private fun launchIntent() {
        Handler(Looper.getMainLooper()).postDelayed({
            startAppActivityClear(MainActivity::class.java)
        }, DELAY_TIME.toLong())
    }

    companion object {
        const val DELAY_TIME = 3000
    }
}