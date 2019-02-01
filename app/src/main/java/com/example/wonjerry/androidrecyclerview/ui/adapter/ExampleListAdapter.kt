package com.example.wonjerry.androidrecyclerview.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.wonjerry.androidrecyclerview.R
import kotlinx.android.synthetic.main.item_example.view.*
import list.Clickable

class ExampleListAdapter(private val clicker: Clickable) : RecyclerView.Adapter<ExampleListAdapter.ViewHolder>() {

    private val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun addItem(item: String) {
        items.add(item)
//        notifyItemInserted(items.size - 1)
        notifyDataSetChanged()
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_example, parent, false)) {

        fun bind(item: String) = with(itemView) {
            item_text.text = item
            setOnClickListener {
                clicker.clickItem(it.item_text.text.toString())
            }
        }
    }
}
