package com.example.first_lab.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.first_lab.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM toDo")
    fun getToDoList():List<ToDo>

    @Insert
    fun insertAll(vararg toDos : ToDo)
}