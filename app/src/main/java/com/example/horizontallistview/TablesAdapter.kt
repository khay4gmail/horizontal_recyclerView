package com.example.horizontallistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TablesAdapter(val tableList: List<String>): RecyclerView.Adapter<TablesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TablesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent,false)
        return TablesViewHolder(itemView)
    }

    override fun getItemCount(): Int = tableList.size

    override fun onBindViewHolder(holder: TablesViewHolder, position: Int) {
        holder.title.text = tableList[position]
    }
}

class TablesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var title: TextView = view.findViewById(R.id.title_tv)
}
