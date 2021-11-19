package com.psp.universitylisting.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.psp.universitylisting.R
import com.psp.universitylisting.data.University


class UniversityListAdapter(private val listener: IClickListener) : ListAdapter<University, UniversityListAdapter.UniversityViewHolder>(DataComparator()){

    class UniversityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val universityName:TextView = itemView.findViewById(R.id.universityName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        val viewHolder = UniversityViewHolder(view)
        view.setOnClickListener{
            listener.viewClicked(getItem(viewHolder.adapterPosition))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.universityName.text = currentItem.name
    }

    class DataComparator : DiffUtil.ItemCallback<University>() {
        override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
            return oldItem == newItem
        }

    }
}

interface IClickListener{
    fun viewClicked(university: University)
}