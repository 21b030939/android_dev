package com.example.first_lab.demo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.first_lab.R
import com.example.first_lab.databinding.FragmentAddToDoBinding

class FragmentAddToDo : Fragment() {

    private var _binding: FragmentAddToDoBinding? = null
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance() = FragmentAddToDo()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddToDoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener{
            val fragment = FragmentToDoList.newInstance()

            parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container_view, fragment)
                .commit()
        }
    }
}