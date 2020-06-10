package net.dasturlash.easyadapter.controllers

import android.view.ViewGroup
import android.widget.TextView
import net.dasturlash.easyadapter.R
import net.dasturlash.easyadapter.data.SubTwoType
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class SubTwoItemController : BindableItemController<SubTwoType, SubTwoItemController.Holder>() {

    override fun getItemId(data: SubTwoType) = ID_TAG + data.id

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<SubTwoType>(parent, R.layout.item_sub_2) {

        private val contentTv: TextView = itemView.findViewById(R.id.sub_2_content_tv)

        override fun bind(data: SubTwoType) {
            contentTv.text = data.text
        }
    }

    private companion object {
        const val ID_TAG = "SubTwoItemController"
    }
}