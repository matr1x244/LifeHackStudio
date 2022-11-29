package com.example.lifehackstudio.ui.main.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifehackstudio.domain.model.data.DataCompanyItem

class RecyclerViewAdapter(private val itemClick: (DataCompanyItem) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    private var companyList: MutableList<DataCompanyItem> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<DataCompanyItem>) {
        companyList.clear()
        companyList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.createView(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), itemClick)
    }

    private fun getItem(position: Int): DataCompanyItem = companyList[position]

    override fun getItemCount() = companyList.size
}