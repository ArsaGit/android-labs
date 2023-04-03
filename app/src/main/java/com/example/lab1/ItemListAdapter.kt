package com.example.lab1

import android.os.Bundle
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.databinding.ItemSmallBinding

class ItemListAdapter : ListAdapter<Item, ItemListAdapter.ItemViewHolder>(ItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        if (viewType == 0) return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_big, parent, false)
        )
        else return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_small, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.setOnClickListener { view ->
            val bundle = Bundle()
            val itemId = currentList[position].id
            bundle.putInt("itemId", itemId)
            view.findNavController()
                .navigate(R.id.action_itemListFragment2_to_itemDetailsFragment, bundle)
        }

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    class ItemDiffUtil : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private fun createOnClickListener(view: View, itemId: Int): View.OnClickListener {
        return View.OnClickListener {


        }
    }


}