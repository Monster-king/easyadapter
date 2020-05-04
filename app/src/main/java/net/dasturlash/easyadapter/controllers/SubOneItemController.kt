package net.dasturlash.easyadapter.controllers

import android.view.ViewGroup
import android.widget.TextView
import net.dasturlash.easyadapter.R
import net.dasturlash.easyadapter.data.SubOneType
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class SubOneItemController : BindableItemController<SubOneType, SubOneItemController.Holder>() {

    override fun getItemId(data: SubOneType) = data.id

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<SubOneType>(parent, R.layout.item_sub_1) {

        private val contentTv: TextView = itemView.findViewById(R.id.sub_1_content_tv)

        override fun bind(data: SubOneType) {
            contentTv.text = data.text
        }
    }
}