package com.app.simpledatabase.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="StudentTable")
class StudentEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    @ColumnInfo(name="studentName")
    var name:String?=null

}