package com.example.first_lab.model

data class ToDoItem (
    val id: String,
    val title: String,
    val description: String,
    var status: Status
    ) {
    enum class Status {
        COMPLETED, IN_PROGRESS, PENDING;
    }
}