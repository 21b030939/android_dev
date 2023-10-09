package com.example.first_lab.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.first_lab.dao.ToDoDao
import com.example.first_lab.entity.ToDo

@Database(entities = [ToDo::class], version = 1)
abstract class ToDoListDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}