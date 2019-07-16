package com.zyla.assign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.zyla.assign.databinding.ActivityMainBinding
import com.zyla.assign.viewmodel.ZViewModel


class MainActivity : AppCompatActivity() {

    private val zViewModel by lazy {
        ViewModelProviders.of(this).get(ZViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.zViewModel = zViewModel
    }
}
