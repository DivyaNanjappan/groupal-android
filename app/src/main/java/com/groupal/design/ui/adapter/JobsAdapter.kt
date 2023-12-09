/*
 * Copyright 2023. All rights reserved.
 * Dissemination of this information or reproduction of this material is strictly forbidden
 * unless prior written permission is obtained from Divya N.
 *
 * Created by Divya N
 */

package com.groupal.design.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.groupal.design.R
import com.groupal.design.databinding.ViewEmptyBinding
import com.groupal.design.databinding.ViewHeaderBinding
import com.groupal.design.databinding.ViewItemCompanyBinding
import com.groupal.design.databinding.ViewItemJobsBinding
import com.groupal.design.databinding.ViewItemSuggestedJobsBinding
import com.groupal.design.utils.JobsType

class JobsAdapter(private val context: Context, private val isHome: Boolean = false) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var viewTypes = mutableListOf<Int>()
    private var titles = mutableListOf<String>()

    init {
        prepareViewItems()
    }

    private fun prepareViewItems() {
        viewTypes = mutableListOf()
        if (isHome) {
            viewTypes.add((JobsType.VIEW_HEADER))
            viewTypes.add((JobsType.VIEW_LATEST_JOB))
            viewTypes.add((JobsType.VIEW_LATEST_JOB))

            titles.add((context.getString(R.string.latest_job)))
            titles.add((context.getString(R.string.latest_job)))
            titles.add((context.getString(R.string.latest_job)))

            viewTypes.add((JobsType.VIEW_HEADER))
            viewTypes.add((JobsType.VIEW_SUGGESTED_JOB))
            viewTypes.add((JobsType.VIEW_SUGGESTED_JOB))

            titles.add((context.getString(R.string.suggested_for_you)))
            titles.add((context.getString(R.string.suggested_for_you)))
            titles.add((context.getString(R.string.suggested_for_you)))

            viewTypes.add((JobsType.VIEW_HEADER))
            viewTypes.add((JobsType.VIEW_SUGGESTED_COMPANY))
            viewTypes.add((JobsType.VIEW_SUGGESTED_COMPANY))

            titles.add((context.getString(R.string.suggested_for_you)))
            titles.add((context.getString(R.string.suggested_for_you)))
            titles.add((context.getString(R.string.suggested_for_you)))
        } else {
            viewTypes.add((JobsType.VIEW_SUGGESTED_JOB))
            viewTypes.add((JobsType.VIEW_SUGGESTED_JOB))
            viewTypes.add((JobsType.VIEW_SUGGESTED_JOB))
            viewTypes.add((JobsType.VIEW_SUGGESTED_JOB))
            viewTypes.add((JobsType.VIEW_SUGGESTED_JOB))
        }


        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null

        when (viewType) {

            JobsType.VIEW_EMPTY -> {
                val binding = ViewEmptyBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                viewHolder = EmptyViewHolder(binding)
            }

            JobsType.VIEW_HEADER -> {
                val binding = ViewHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                viewHolder = ViewHolderHeader(binding)
            }

            JobsType.VIEW_LATEST_JOB -> {
                val binding = ViewItemJobsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                viewHolder = ViewHolderJobs(binding)
            }

            JobsType.VIEW_SUGGESTED_JOB -> {
                val binding = ViewItemSuggestedJobsBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                viewHolder = ViewHolderSuggestedJobs(binding)
            }

            JobsType.VIEW_SUGGESTED_COMPANY -> {
                val binding = ViewItemCompanyBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                viewHolder = ViewHolderSuggestedCompany(binding)
            }
        }

        return viewHolder!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {

            JobsType.VIEW_EMPTY -> {
                val emptyViewHolder = holder as EmptyViewHolder
                emptyViewHolder.binding.textViewEmpty.apply {
                    text = ""
                }
            }

            JobsType.VIEW_HEADER -> {
                val viewHolder = holder as ViewHolderHeader
                viewHolder.init(position)
            }

            JobsType.VIEW_LATEST_JOB -> {
                val viewHolder = holder as ViewHolderJobs
                viewHolder.init()
            }

            JobsType.VIEW_SUGGESTED_JOB -> {
                val viewHolder = holder as ViewHolderSuggestedJobs
                viewHolder.init()
            }

            JobsType.VIEW_SUGGESTED_COMPANY -> {
                val viewHolder = holder as ViewHolderSuggestedCompany
                viewHolder.init()
            }
        }
    }

    override fun getItemViewType(position: Int): Int = viewTypes[position]

    override fun getItemCount(): Int = viewTypes.size

    internal inner class ViewHolderJobs(binding: ViewItemJobsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun init() {
        }
    }

    internal inner class ViewHolderSuggestedJobs(binding: ViewItemSuggestedJobsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun init() {
        }
    }

    internal inner class ViewHolderHeader(private val binding: ViewHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun init(position: Int) {

            binding.textViewJobLatest.text = titles[position]
        }
    }

    internal inner class ViewHolderSuggestedCompany(binding: ViewItemCompanyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun init() {
        }
    }
}