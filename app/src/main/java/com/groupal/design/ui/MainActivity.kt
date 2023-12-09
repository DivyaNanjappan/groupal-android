/*
 * Copyright 2023. All rights reserved.
 * Dissemination of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Divya N.
 *
 * Created by Divya N
 */

package com.groupal.design.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.groupal.design.R
import com.groupal.design.databinding.ActivityMainBinding
import com.groupal.design.utils.FragmentType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigationView()
    }

    private val homeFragment = HomeFragment.newInstance()
    private val jobsFragment = JobsFragment.newInstance()
    private val savedFragment = JobsFragment.newInstance()
    private val profileFragment = ProfileFragment.newInstance()

    private fun setBottomNavigationView() {
        binding.bottomNavigation.apply {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_home -> handleFragmentChange(FragmentType.HOME)
                    R.id.menu_jobs -> handleFragmentChange(FragmentType.JOBS)
                    R.id.menu_saved -> handleFragmentChange(FragmentType.SAVED)
                    R.id.menu_profile -> handleFragmentChange(FragmentType.PROFILE)
                }
                true
            }
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, homeFragment, FragmentType.HOME.toString())
            .add(R.id.main_container, jobsFragment, FragmentType.JOBS.toString())
            .add(R.id.main_container, savedFragment, FragmentType.SAVED.toString())
            .add(R.id.main_container, profileFragment, FragmentType.PROFILE.toString())
            .commit()

        handleFragmentChange(FragmentType.HOME)
    }

    private var selectedFragment = FragmentType.HOME

    private fun handleFragmentChange(type: Int) {
        selectedFragment = type

        getCurrentFragment(selectedFragment).commit()

        updateCurrentSelection(type)
    }

    private fun updateCurrentSelection(type: Int) {
        binding.bottomNavigation.menu.apply {
            when (type) {
                FragmentType.HOME -> findItem(R.id.menu_home).isChecked = true
                FragmentType.JOBS -> findItem(R.id.menu_jobs).isChecked = true
                FragmentType.SAVED -> findItem(R.id.menu_saved).isChecked = true
                FragmentType.PROFILE -> findItem(R.id.menu_profile).isChecked = true
            }
        }
    }

    private fun getCurrentFragment(type: Int): FragmentTransaction {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val headerTitle: String
        when (type) {
            FragmentType.JOBS -> {
                headerTitle = getString(R.string.search_job)
                fragmentTransaction.show(jobsFragment)
                fragmentTransaction.hide(homeFragment)
                fragmentTransaction.hide(savedFragment)
                fragmentTransaction.hide(profileFragment)
            }

            FragmentType.SAVED -> {
                headerTitle = getString(R.string.search_job)
                fragmentTransaction.show(savedFragment)
                fragmentTransaction.hide(homeFragment)
                fragmentTransaction.hide(jobsFragment)
                fragmentTransaction.hide(profileFragment)
            }

            FragmentType.PROFILE -> {
                headerTitle = getString(R.string.your_profile)
                fragmentTransaction.show(profileFragment)
                fragmentTransaction.hide(homeFragment)
                fragmentTransaction.hide(jobsFragment)
                fragmentTransaction.hide(savedFragment)
            }

            else -> {
                headerTitle = getString(R.string.menu_home)
                fragmentTransaction.show(homeFragment)
                fragmentTransaction.hide(jobsFragment)
                fragmentTransaction.hide(savedFragment)
                fragmentTransaction.hide(profileFragment)
            }
        }

        binding.toolHome.textViewHeader.text = headerTitle

        return fragmentTransaction
    }
}
