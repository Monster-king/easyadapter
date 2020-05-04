package net.dasturlash.easyadapter

import net.dasturlash.easyadapter.controllers.*
import net.dasturlash.easyadapter.data.SubOneType
import net.dasturlash.easyadapter.data.SubTwoType
import net.dasturlash.easyadapter.data.ViewOneType
import net.dasturlash.easyadapter.data.ViewTwoType
import ru.surfstudio.android.easyadapter.ItemList
import kotlin.random.Random

class RandomDataGenerator(
    val viewOneController: ViewOneItemController,
    val viewTwoController: ViewTwoItemController,
    val itemListController: ItemListItemController,
    val subOneController: SubOneItemController,
    val subTwoController: SubTwoItemController
) {
    val random = Random(System.currentTimeMillis())

    private val viewOneList = listOf(
        ViewOneType("View one 1"),
        ViewOneType("View one 2"),
        ViewOneType("View one 3"),
        ViewOneType("View one 4"),
        ViewOneType("View one 5")
    )

    private val viewTwoList = listOf(
        ViewTwoType(1, "hello", 3),
        ViewTwoType(2, "hi", 4),
        ViewTwoType(3, "how are you", 5),
        ViewTwoType(4, "lets do some stuff", 6),
        ViewTwoType(5, "ok lets go", 7)
    )

    private val subOneList = listOf(
        SubOneType(1, "ok google"),
        SubOneType(2, "lets go"),
        SubOneType(3, "dota 2"),
        SubOneType(4, "csgo")
    )

    private val subTwoList = listOf(
        SubTwoType(1, "Good job"),
        SubTwoType(2, "Well done"),
        SubTwoType(3, "Amazing")
    )

    fun generateNextData(): ItemList {
        val result = ItemList.create()
        val subItemList = ItemList.create()
        if (random.nextInt() % 2 == 0) {
            result.addAll(viewOneList.shuffled(), viewOneController)
        } else {
            result.add(viewOneList[random.nextInt(viewOneList.size)], viewOneController)
        }

        if (random.nextInt() % 2 == 0) {
            result.addAll(viewTwoList.shuffled(), viewTwoController)
        } else {
            result.add(viewTwoList[random.nextInt(viewTwoList.size)], viewTwoController)
        }

        if (random.nextInt() % 2 == 0) {
            subItemList.addAll(subOneList.shuffled(), subOneController)
        } else {
            subItemList.add(subOneList[random.nextInt(subOneList.size)], subOneController)
        }

        if (random.nextInt() % 2 == 0) {
            subItemList.addAll(subTwoList.shuffled(), subTwoController)
        } else {
            subItemList.add(subTwoList[random.nextInt(subTwoList.size)], subTwoController)
        }

        result.add(subItemList, itemListController)
        return result
    }
}