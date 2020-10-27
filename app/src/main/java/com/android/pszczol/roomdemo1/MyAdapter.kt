package com.android.pszczol.roomdemo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var person = emptyList<Person>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.firstName_txt.text = person[position].firstName
        holder.itemView.lastName_txt.text = person[position].lastName
        holder.itemView.imageView.load(person[position].profilePhoto)
    }

    override fun getItemCount(): Int {
        return person.size
    }

    fun setData(person: List<Person>){
        this.person = person
        notifyDataSetChanged()
    }

}