package com.example.first_lab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.first_lab.databinding.ItemToDoBinding
import com.example.first_lab.diffutil.ToDoListDiffUtilCallback
import com.example.first_lab.model.ToDoItem

class ToDoListAdapter:ListAdapter<ToDoItem, ToDoListAdapter.ViewHolder>(ToDoListDiffUtilCallback()){

    var onToDoItemClicked: ((ToDoItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemToDoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("OnBindViewHolder: $position")
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemToDoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(toDoItem : ToDoItem){
            binding.toDoTitle.text = toDoItem.title
            binding.toDoDescription.text = toDoItem.description
            binding.checkMark.isVisible = toDoItem.status == ToDoItem.Status.COMPLETED

            binding.root.setOnClickListener{
                onToDoItemClicked?.invoke(toDoItem)
            }
        }
    }

}