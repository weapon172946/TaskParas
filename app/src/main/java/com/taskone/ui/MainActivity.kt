package com.taskone.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taskone.R
import com.taskone.databinding.ActivityMainBinding
import com.taskone.utils.ListRepo

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ListRepo.populateList()

        ListRepo.observableList.observe(this, {
            var topText = ""
            if (it.isNotEmpty()) {
                for (item in ListRepo.getCheckedItems())
                    topText += item.name + ","
                binding.tvTop.text = topText.removeSuffix(",")
            } else binding.tvTop.text = getString(R.string.txt_no_selection_yet)
        })

        binding.btNavigate.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SecondActivity::class.java
                )
            )
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}