package com.example.lab1.data.model

import com.example.lab1.R

sealed class SealedCard {
    data class CardInfo(
        val img: String?,
        val title: String,
        val subtitle: String,
        val hasBag: String?,
        val isCircle: Boolean?
    ) : SealedCard()

    fun getCardType() : Int {
        if (this is CardInfo) {
            // Карточка с текстом на фоне картинки
            if (this.img != null &&
                this.title != null  &&
                this.subtitle != null  &&
                this.hasBag == null  &&
                this.isCircle == null)
                return R.layout.card_img_text;
            // карточка с текстом на фоне и картинкой сверху
            else if (this.img != null &&
                this.title != null  &&
                this.subtitle != null  &&
                this.hasBag != null  &&
                this.isCircle == null)
                return R.layout.card_img_text_bag;
            // карточка только с описанием и заголовком
            else if (this.img == null &&
                this.title != null  &&
                this.subtitle != null  &&
                this.hasBag == null  &&
                this.isCircle == null)
                return R.layout.card_text;
            // карточка с круглой картинкой
            else if (this.img != null &&
                this.title != null  &&
                this.subtitle != null  &&
                this.hasBag == null  &&
                this.isCircle != null)
                return R.layout.card_img_round_text;
            else return 2;
        }
        else return 2;
    }
}
