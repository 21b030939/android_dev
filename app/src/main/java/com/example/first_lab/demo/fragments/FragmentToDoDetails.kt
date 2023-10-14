package com.example.first_lab.demo.fragments

import com.example.first_lab.databinding.FragmentToDoDetailsBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.first_lab.databinding.FragmentAddToDoBinding
import kotlinx.android.extensions.ContainerOptions


class FragmentToDoDetails : Fragment() {
    private var _binding: FragmentToDoDetailsBinding? = null

    private val binding
        get() = _binding!!

    companion object{
        fun newInstance() = FragmentToDoList()
    }

    override fun onViewCreated(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToDoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


}