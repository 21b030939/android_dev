package com.example.first_lab.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.first_lab.R
import com.example.first_lab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = FragmentOne.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, fragment)
            .commit()
    }


}