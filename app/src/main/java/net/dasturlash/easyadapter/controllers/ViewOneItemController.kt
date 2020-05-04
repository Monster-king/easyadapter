package net.dasturlash.easyadapter.controllers

import android.view.ViewGroup
import android.widget.Button
import net.dasturlash.easyadapter.R
import net.dasturlash.easyadapter.data.ViewOneType
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class ViewOneItemController(
    private val onClick: (ViewOneType) -> Unit
) : BindableItemController<ViewOneType, ViewOneItemController.Holder>() {

    override fun getItemId(data: ViewOneType) = data.text

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<ViewOneType>(parent, R.layout.item_view_1) {

        private lateinit var data: ViewOneType
        private val btn: Button = itemView.findViewById(R.id.view_1_btn)

        init {
            btn.setOnClickListener { onClick(data) }
        }

        override fun bind(data: ViewOneType) {
            this.data = data
            btn.text = data.text
        }
    }
}