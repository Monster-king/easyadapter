package net.dasturlash.easyadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import net.dasturlash.easyadapter.controllers.*
import net.dasturlash.easyadapter.data.ViewOneType
import ru.surfstudio.android.easyadapter.EasyAdapter

class MainActivity : AppCompatActivity() {

    private val adapter = EasyAdapter().apply {
        isFirstInvisibleItemEnabled = true
    }
    private val viewOneController = ViewOneItemController { showMessage(it) }
    private val viewTwoController = ViewTwoItemController()
    private val itemListController = ItemListItemController()
    private val subOneController = SubOneItemController()
    private val subTwoController = SubTwoItemController()

    private val generator = RandomDataGenerator(
        viewOneController,
        viewTwoController,
        itemListController,
        subOneController,
        subTwoController
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listRv: RecyclerView = findViewById(R.id.demo_rv)
        listRv.adapter = adapter

        adapter.setItems(generator.generateNextData())

        findViewById<View>(R.id.refresh_btn).setOnClickListener {
            adapter.setItems(generator.generateNextData())
        }
    }

    private fun showMessage(data: ViewOneType) {
        Toast.makeText(this, data.text, Toast.LENGTH_SHORT).show()
    }
}
