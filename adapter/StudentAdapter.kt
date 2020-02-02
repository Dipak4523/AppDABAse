package com.app.simpledatabase.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.simpledatabase.R
import com.app.simpledatabase.database.StudentEntity

class StudentAdapter(private val context: Context, private var list: List<StudentEntity>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position,holder)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var textTitle: TextView
        public var textRating: TextView
        public var textYear: TextView

        init {
            textTitle = itemView.findViewById(R.id.main_title)
            textRating = itemView.findViewById(R.id.main_rating)
            textYear = itemView.findViewById(R.id.main_year)
        }

        fun bindData(position: Int,holder:ViewHolder){
            textTitle.text=list[position].name
           // textRating.text=list[position].rating.toString()
          //  textYear.text=list[position].year.toString()
        }
    }

    fun updateList(list:List<StudentEntity>){
        this.list=list
        notifyDataSetChanged()
    }
}