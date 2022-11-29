package com.example.lifehackstudio.ui.main.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem

class RecyclerViewAdapter(private val itemClick: (DataCompanyListItem) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    private var companyList: MutableList<DataCompanyListItem> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<DataCompanyListItem>) {
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

    private fun getItem(position: Int): DataCompanyListItem = companyList[position]

    override fun getItemCount() = companyList.size
}