package com.example.first_lab.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.first_lab.model.ToDoItem

@Entity
class ToDo(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "status") var status: ToDoItem.Status
)

val ToDoMapper: (ToDoItem) -> ToDo = {
    ToDo(
        id = it.id,
        title = it.title,
        description = it.description,
        status = it.status
    )
}