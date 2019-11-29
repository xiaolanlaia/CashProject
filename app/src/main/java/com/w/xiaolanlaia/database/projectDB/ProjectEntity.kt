package com.w.xiaolanlaia.database.projectDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/26 8:31
 *
 */

@Entity(tableName = "projectEntity")
data class ProjectEntity(

    @PrimaryKey(autoGenerate = true)
    var projectID : Int?,

    @ColumnInfo(name = "projectNum")
    var projectNum: String?,

    @ColumnInfo(name = "projectTime")
    var projectTime: String?,

    @ColumnInfo(name = "projectLocation")
    var projectLocation: String?,

    @ColumnInfo(name = "project")
    var project: String?,

    @ColumnInfo(name = "projectType")
    var projectType: String?,

    @ColumnInfo(name = "projectMoney")
    var projectMoney: String?








)