package com.ubaya.todoapp.model

import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todo:Todo)

    @Query("SELECT * FROM todo ORDER BY priority DESC")
    fun selectAllTodo(): List<Todo>

    @Query("SELECT * FROM todo WHERE uuid= :id")
    fun selectTodo(id:Int): Todo

    @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
    fun update(title: String, notes: String, priority: Int, id: Int, uuid: Int)

    @Query("UPDATE todo SET is_done=1 WHERE uuid=:id")
    fun doneTodo(id:Int)

    @Delete
    fun deleteTodo(todo:Todo)


}