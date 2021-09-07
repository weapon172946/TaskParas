package com.taskone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taskone.adapter.ListingAdapter
import com.taskone.databinding.ActivitySecondBinding
import com.taskone.utils.ListRepo

class SecondActivity : AppCompatActivity() {
    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ListingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ListingAdapter(ListRepo.getCheckedItems())
        binding.rvList.adapter = adapter

        binding.btAsc.setOnClickListener { adapter.updateData(ListRepo.getAscendingList()) }
        binding.btDsc.setOnClickListener { adapter.updateData(ListRepo.getDescendingList()) }
    }


}