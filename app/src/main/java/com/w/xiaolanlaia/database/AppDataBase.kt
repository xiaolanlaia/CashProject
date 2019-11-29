package com.w.xiaolanlaia.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.w.xiaolanlaia.common.MyApplication
import com.w.xiaolanlaia.database.projectDB.ProjectDao
import com.w.xiaolanlaia.database.projectDB.ProjectEntity

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/29 11:07
 *
 */


@Database(entities = [ProjectEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getProjectDao(): ProjectDao

    companion object {

        val instance = Single.sin

    }

    private object Single {

        val sin :AppDataBase= Room.databaseBuilder(
            MyApplication.instance(),
            AppDataBase::class.java,
            "Project.db"
        )
            .allowMainThreadQueries()
            .build()
    }

}