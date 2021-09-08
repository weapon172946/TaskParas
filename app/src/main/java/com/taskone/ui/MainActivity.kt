package com.taskone.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.taskone.adapter.HomeAdapter
import com.taskone.databinding.ActivityMainBinding
import com.taskone.utils.ListRepo


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var rcPos = MutableLiveData<Int>(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ListRepo.populateList()

        rcPos.observe(this, {
            if (ListRepo.getDataList().size - 1 == it) {
                binding.btSave.visibility = View.VISIBLE
                binding.btNavigate.visibility = View.GONE
            } else {
                binding.btSave.visibility = View.GONE
                binding.btNavigate.visibility = View.VISIBLE
            }
        })

        binding.btNavigate.setOnClickListener {
            Log.e("AkashLog", rcPos.value.toString())
            binding.rvHome.scrollToPosition(rcPos.value!! + 1)
            rcPos.value = rcPos.value!! + 1
        }


        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvHome)

        binding.rvHome.adapter = HomeAdapter(ListRepo.getDataList())
        binding.rvHome.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                rcPos.value =
                    (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            }


        })

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}