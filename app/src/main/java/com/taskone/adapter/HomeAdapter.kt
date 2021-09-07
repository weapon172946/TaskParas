package com.taskone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taskone.databinding.RecyclerHomeItemBinding
import com.taskone.model.MyListModel

class HomeAdapter(
    var dataList: ArrayList<MyListModel>,
    var adapterClickListener: AdapterClickListener
) :
    RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerHomeItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvName.setText(dataList[position].name)
        holder.binding.tvDate.setText(dataList[position].date)
        holder.itemView.setOnClickListener { holder.binding.cbItem.performClick() }
        holder.binding.cbItem.isChecked = dataList[position].isSelected
        holder.binding.cbItem.setOnCheckedChangeListener { buttonView, isChecked ->
            dataList[position].isSelected = isChecked
            adapterClickListener.onItemChecked(position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: RecyclerHomeItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding: RecyclerHomeItemBinding = itemView

    }

    interface AdapterClickListener {
        fun onItemChecked(pos: Int)
    }
}