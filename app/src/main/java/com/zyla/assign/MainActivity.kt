package com.zyla.assign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.zyla.assign.databinding.ActivityMainBinding
import com.zyla.assign.viewmodel.ZViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val zViewModel by lazy {
        ViewModelProviders.of(this, factory).get(ZViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        binding.zViewModel = zViewModel
    }
}
