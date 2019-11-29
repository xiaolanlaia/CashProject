package com.w.xiaolanlaia.database

import androidx.room.*

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/11/29 10:10
 *
 */


@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: MutableList<T>)

    @Delete
    fun delete(element: T)

    @Delete
    fun deleteList(elements:MutableList<T>)

    @Delete
    fun deleteSome(vararg elements:T)

    @Update
    fun update(element: T)

}