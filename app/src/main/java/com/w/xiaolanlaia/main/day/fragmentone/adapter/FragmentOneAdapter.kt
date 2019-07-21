package com.w.xiaolanlaia.main.day.fragmentone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.w.xiaolanlaia.R
import com.w.xiaolanlaia.entity.FragmentOneBean
import kotlinx.android.synthetic.main.fragment_one_item.view.*

/**
 *  @author  xiaolanlaia
 *
 *  @create  2019/7/19 19:29
 *
 */


class FragmentOneAdapter : RecyclerView.Adapter<FragmentOneAdapter.FragmentOneViewHelper>(){

    private var list = mutableListOf<FragmentOneBean>()
    lateinit var context: Context

    fun updateList(type : Int, list : MutableList<FragmentOneBean>){

        if (type == 0){
            val li =list.filter {

                it.type == 0

            }

            li.forEachIndexed { _, fragmentOneBean ->
                this.list.add(fragmentOneBean)
            }
        }else if (type == 1){
            val li = list.filter {
                it.type == 1
            }

            li.forEachIndexed { _, fragmentOneBean ->
                this.list.add(fragmentOneBean)
            }

        }else{
            this.list = list
        }

        notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentOneViewHelper {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_one_item,parent,false)
        return FragmentOneViewHelper(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: FragmentOneViewHelper, position: Int) {

        holder.number.text = list[position].number
        holder.type.text = list[position].type.toString()
        holder.project.text = list[position].project
        holder.money.text = list[position].money
        holder.time.text = list[position].time.toString()
        holder.location.text = list[position].location
    }



    class FragmentOneViewHelper(itemView : View) : RecyclerView.ViewHolder(itemView){

        var view = itemView
        var number = itemView.findViewById<TextView>(R.id.number)
        var type = itemView.findViewById<TextView>(R.id.type)
        var project = itemView.findViewById<TextView>(R.id.project)
        var money = itemView.findViewById<TextView>(R.id.money)
        var time = itemView.findViewById<TextView>(R.id.time)
        var location = itemView.findViewById<TextView>(R.id.location)

    }

}