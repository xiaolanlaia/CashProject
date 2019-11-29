package com.w.xiaolanlaia.database.projectDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.w.xiaolanlaia.database.BaseDao

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/29 10:57
 *
 */

@Dao
interface ProjectDao : BaseDao<ProjectEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(element: ProjectEntity)

    @Query("select * from projectEntity")
    fun getAllProjects():MutableList<ProjectEntity>

    @Query("select * from projectEntity where projectId = :projectID")
    fun getProject(projectID:Int): ProjectEntity

    @Query("select * from projectEntity order by projectID desc ")
    fun getAllByDateDesc():MutableList<ProjectEntity>

    @Query("delete from projectEntity")
    fun deleteAll()
}