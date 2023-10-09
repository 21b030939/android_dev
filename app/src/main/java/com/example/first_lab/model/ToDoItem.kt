package com.example.first_lab.model

import android.os.Parcelable
import com.example.first_lab.entity.ToDo
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDoItem (
    val id: String,
    val title: String,
    val description: String,
    var status: Status
    ) : Parcelable {
    enum class Status {
        COMPLETED, IN_PROGRESS, PENDING;
    }

}
val toDoItemMapper: (ToDo) -> ToDoItem = {
    ToDoItem(
        id = it.id,
        title = it.title,
        description = it.description,
        status = it.status
    )
}