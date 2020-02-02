package com.app.simpledatabase.database

import androidx.room.*

@Dao
interface StudentDAO {

    @Query("Select * from StudentTable")
    fun getStudentList():List<StudentEntity>

    @Insert
    fun insert(studentEntity: StudentEntity)

    @Update
    fun update(studentEntity: StudentEntity)

    @Delete
    fun delete(studentEntity: StudentEntity)


}