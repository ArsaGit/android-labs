package com.example.lab1.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.R
import com.example.lab1.data.model.SealedCard
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class CardListAdapter : ListAdapter<SealedCard, CardListAdapter.ItemViewHolder>(ItemDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            R.layout.card_img_text -> ItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_img_text, parent, false)
            )
            R.layout.card_img_round_text -> ItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_img_round_text, parent, false)
            )
            R.layout.card_img_text_bag -> ItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_img_text_bag, parent, false)
            )
            R.layout.card_text -> ItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_text, parent, false)
            )
            else -> ItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_img_text, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val cardInfo = currentList[position] as SealedCard.CardInfo

        val imageUrl = cardInfo.img

        if (cardInfo.hasBag != null) {
            holder.title.setBackgroundColor(Color.parseColor(cardInfo.hasBag))
            holder.subtitle.setBackgroundColor(Color.parseColor(cardInfo.hasBag))
        }

        if (holder.image != null) {
            if (cardInfo.isCircle != null && cardInfo.isCircle)
                Picasso.get().load(imageUrl).resize(400, 400)
                    .transform(CropCircleTransformation()).into(holder.image)
            else
                Picasso.get().load(imageUrl).into(holder.image)
        }

        holder.title.text = cardInfo.title
        holder.subtitle.text = cardInfo.subtitle
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView? = itemView.findViewById(R.id.card_img)
        val title: TextView = itemView.findViewById(R.id.card_title)
        val subtitle: TextView = itemView.findViewById(R.id.card_subtitle)
    }

    override fun getItemViewType(position: Int): Int = currentList[position].getCardType()

    class ItemDiffUtil : DiffUtil.ItemCallback<SealedCard>() {
        override fun areItemsTheSame(oldItem: SealedCard, newItem: SealedCard): Boolean {
            return when {
                oldItem is SealedCard.CardInfo && newItem is SealedCard.CardInfo -> {
                    oldItem == newItem
                }
                else -> false
            }

        }

        override fun areContentsTheSame(oldItem: SealedCard, newItem: SealedCard): Boolean {
            return when {
                oldItem is SealedCard.CardInfo && newItem is SealedCard.CardInfo -> {
                    oldItem.img.equals(newItem.img);
                    oldItem.title == newItem.title;
                    oldItem.subtitle == newItem.subtitle;
                    oldItem.hasBag.equals(newItem.hasBag);
                    oldItem.isCircle == newItem.isCircle;
                }
                else -> false
            }
        }
    }
}