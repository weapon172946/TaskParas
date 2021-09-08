package com.taskone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taskone.adapter.HomeAdapter
import com.taskone.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), HomeAdapter.AdapterClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var topText = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.rvHome.adapter = HomeAdapter(ListRepo.getDataList(), this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override
    fun onItemChecked(pos: Int) {
//        ListRepo.getCheckedItems()
    }


}