package com.example.lifehackstudio.ui.main.recycler

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.lifehackstudio.R
import com.example.lifehackstudio.databinding.RecyclerItemListCompanyBinding
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = RecyclerItemListCompanyBinding.bind(itemView)

    companion object {
        fun createView(parent: ViewGroup): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_list_company, parent, false)
            return ViewHolder(view)
        }
    }

    fun bind(item: DataCompanyListItem, listener: DataCompanyListItem.() -> Unit) {
        Glide.with(binding.ivImage)
            .load(item.img)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    println("@@@@ onLoadFailed")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    println("@@@@ onResourceReady")
                    return false
                }
            })
            .into(binding.ivImage)

        binding.tvId.text = item.id
        binding.tvName.text = item.name

        binding.root.setOnClickListener {
            listener.invoke(item)
        }
    }

}