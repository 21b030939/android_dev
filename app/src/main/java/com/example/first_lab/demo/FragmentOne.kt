package com.example.first_lab.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.first_lab.adapter.ToDoListAdapter
import com.example.first_lab.databinding.FragmentOneBinding
import com.example.first_lab.model.ToDoItem
import java.util.UUID

class FragmentOne : Fragment() {

    private var _binding: FragmentOneBinding? = null
        private val binding
        get() = _binding!!

    companion object {
        fun newInstance() = FragmentOne()
    }

    private var toDoListAdapter: ToDoListAdapter? = null

    private var items = listOf(
        ToDoItem(
            id = UUID.randomUUID().toString(),
            title = "Do Homework",
            description = "Do Android Advanced laboratory work urgent!",
            status = ToDoItem.Status.PENDING,
        ),
        ToDoItem(
            id = UUID.randomUUID().toString(),
            title = "Clean your room",
            description = "Clean you room carefully!",
            status = ToDoItem.Status.COMPLETED,
        ),
        ToDoItem(
            id = UUID.randomUUID().toString(),
            title = "Play computer games",
            description = "Play 3 games of CS:GO",
            status = ToDoItem.Status.PENDING,
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        toDoListAdapter = ToDoListAdapter()

        binding.toDoList.adapter = toDoListAdapter
        binding.toDoList.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        toDoListAdapter?.onToDoItemClicked = { toDoItem ->
            updateToDoItem(toDoItem)
        }

        submitList(items)
    }

    private fun updateToDoItem(toDoItem: ToDoItem) {
        val newList = items.map {
            if (it.id == toDoItem.id) {
                it.copy(
                    status = if (toDoItem.status != ToDoItem.Status.COMPLETED) {
                        ToDoItem.Status.COMPLETED
                    } else {
                        ToDoItem.Status.PENDING
                    }
                )
            } else {
                it
            }
        }

        items = newList

        submitList(newList)
    }

    private fun submitList(list: List<ToDoItem>) {
        toDoListAdapter?.submitList(list)
    }

}