/*
 * Copyright 2023. All rights reserved.
 * Dissemination of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Divya N.
 *
 * Created by Divya N
 */

package com.groupal.design.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.groupal.design.databinding.FragmentHomeBinding
import com.groupal.design.databinding.FragmentJobsBinding
import com.groupal.design.databinding.FragmentProfileBinding
import com.groupal.design.ui.adapter.BannerAdapter
import com.groupal.design.ui.adapter.JobsAdapter
import com.groupal.design.utils.JobsType

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}