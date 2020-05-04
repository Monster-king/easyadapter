package net.dasturlash.easyadapter.controllers

import android.view.ViewGroup
import android.widget.TextView
import net.dasturlash.easyadapter.R
import net.dasturlash.easyadapter.data.ViewTwoType
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class ViewTwoItemController : BindableItemController<ViewTwoType, ViewTwoItemController.Holder>() {

    override fun getItemId(data: ViewTwoType) = data.id

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<ViewTwoType>(parent, R.layout.item_view_2) {

        private val labelTv: TextView = itemView.findViewById(R.id.view_2_label_tv)
        private val counterTv: TextView = itemView.findViewById(R.id.view_2_counter_tv)

        override fun bind(data: ViewTwoType) {
            labelTv.text = data.data
            counterTv.text = data.count.toString()
        }
    }
}