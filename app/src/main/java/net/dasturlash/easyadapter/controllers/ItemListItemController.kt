package net.dasturlash.easyadapter.controllers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.dasturlash.easyadapter.R
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder

class ItemListItemController : BindableItemController<ItemList, ItemListItemController.Holder>() {

    override fun getItemId(data: ItemList) = data

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) :
        BindableViewHolder<ItemList>(parent, R.layout.item_view_3) {

        private val adapter = EasyAdapter()
        private val listRv: RecyclerView = itemView.findViewById(R.id.view_3_rv)

        init {
            listRv.adapter = adapter
        }

        override fun bind(data: ItemList) {
            adapter.setItems(data)
        }
    }
}