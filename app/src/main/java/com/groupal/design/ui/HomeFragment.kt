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
import com.groupal.design.ui.adapter.BannerAdapter
import com.groupal.design.ui.adapter.JobsAdapter
import com.groupal.design.utils.JobsType

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        loadBanners()

        loadJobs()

        return binding.root
    }

    private var bannerAdapter: BannerAdapter? = null
    private fun loadBanners() {
        bannerAdapter = activity?.let { BannerAdapter() }

        binding.apply {
            recyclerViewBanner.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                itemAnimator = DefaultItemAnimator()
                adapter = bannerAdapter
            }
            indicatorBanner.attachToRecyclerView(recyclerViewBanner)
        }
    }

    private var jobsAdapter: JobsAdapter? = null
    private fun loadJobs() {
        jobsAdapter = activity?.let { JobsAdapter(it, true) }

        val gridLayoutManager = GridLayoutManager(activity, 4)

        binding.recyclerViewJobsLatest.run {
            layoutManager = gridLayoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = jobsAdapter
        }

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (jobsAdapter?.getItemViewType(position)) {
                    JobsType.VIEW_HEADER -> gridLayoutManager.spanCount
                    JobsType.VIEW_LATEST_JOB, JobsType.VIEW_SUGGESTED_JOB -> gridLayoutManager.spanCount
                    JobsType.VIEW_SUGGESTED_COMPANY -> 2

                    else -> -1
                }
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}