package com.example.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter : ListAdapter<SealedItem, ItemListAdapter.ItemViewHolder>(ItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when(viewType) {
            R.layout.item_big -> {
                ItemViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_big, parent, false))
            }
            R.layout.item_small -> {
                ItemViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_small, parent, false))
            }
            else -> throw IllegalArgumentException("Uknown viewType")
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.setOnClickListener { view ->
            val bundle = Bundle()

            val item = currentList[position]
            val itemId = when(item) {
                is SealedItem.BigItem -> item.id
                is SealedItem.SmallItem -> item.id
            }

            bundle.putInt("itemId", itemId)
            view.findNavController()
                .navigate(R.id.action_itemListFragment2_to_itemDetailsFragment, bundle)
        }

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is SealedItem.BigItem -> R.layout.item_big
            is SealedItem.SmallItem -> R.layout.item_small
        }
    }

    class ItemDiffUtil : DiffUtil.ItemCallback<SealedItem>() {
        override fun areItemsTheSame(oldItem: SealedItem, newItem: SealedItem): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: SealedItem, newItem: SealedItem): Boolean {
            return when {
                oldItem is SealedItem.BigItem && newItem is SealedItem.BigItem -> {
                    oldItem.id == newItem.id;
                    oldItem.imgUrl == newItem.imgUrl;
                }
                oldItem is SealedItem.SmallItem && newItem is SealedItem.SmallItem -> {
                    oldItem.id == newItem.id;
                }
                else -> false
            }
        }
    }

    private fun createOnClickListener(view: View, itemId: Int): View.OnClickListener {
        return View.OnClickListener {

        }
    }


}