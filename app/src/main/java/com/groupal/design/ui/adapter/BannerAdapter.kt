/*
 * Copyright 2023. All rights reserved.
 * Dissemination of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Divya N.
 *
 * Created by Divya N
 */

package com.groupal.design.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.groupal.design.R
import com.groupal.design.databinding.ViewItemBannerBinding

class BannerAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val banners = listOf(
        R.drawable.ic_banner,
        R.drawable.ic_banner,
        R.drawable.ic_banner,
        R.drawable.ic_banner
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ViewItemBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.init(position)
    }

    override fun getItemCount(): Int {
        return banners.size
    }

    internal inner class ViewHolder(private val binding: ViewItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun init(position: Int) {
            binding.imageViewBanner.setBackgroundResource(banners[position])
        }
    }
}