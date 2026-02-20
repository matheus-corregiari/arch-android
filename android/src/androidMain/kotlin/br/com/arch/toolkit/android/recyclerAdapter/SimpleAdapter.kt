package br.com.arch.toolkit.android.recyclerAdapter

import android.content.Context
import android.view.View
import br.com.arch.toolkit.android.recyclerAdapter.stickyheader.StickyHeaderModel

/**
 * A simplified implementation of [BaseRecyclerAdapter] for a single view type.
 *
 * @param MODEL The type of data to be displayed.
 * @param VIEW The type of the view that will display the data. Must extend [View] and implement [ViewBinder].
 * @property creator A lambda that creates a new instance of [VIEW].
 */
open class SimpleAdapter<MODEL : Any, out VIEW>(private val creator: (context: Context) -> VIEW) :
    BaseRecyclerAdapter<MODEL>()
    where VIEW : View, VIEW : ViewBinder<MODEL> {

    override fun viewCreator(context: Context, viewType: Int) = creator.invoke(context)
}

/**
 * A simplified implementation of [BaseRecyclerAdapter] that supports sticky headers.
 *
 * @param MODEL The type of data to be displayed. Must implement [StickyHeaderModel].
 * @param VIEW The type of the view for regular items. Must extend [View] and implement [ViewBinder].
 * @param STICKY_VIEW The type of the view for sticky headers. Must extend [View] and implement [ViewBinder].
 * @property itemCreator A lambda that creates a new instance of [VIEW].
 * @property stickyItemCreator A lambda that creates a new instance of [STICKY_VIEW].
 */
open class SimpleStickyAdapter<MODEL, out VIEW, out STICKY_VIEW>(
    private val itemCreator: (context: Context) -> VIEW,
    private val stickyItemCreator: (context: Context) -> STICKY_VIEW
) : BaseRecyclerAdapter<MODEL>()
    where MODEL : StickyHeaderModel,
          VIEW : View, VIEW : ViewBinder<MODEL>,
          STICKY_VIEW : View, STICKY_VIEW : ViewBinder<MODEL> {

    override fun viewCreator(context: Context, viewType: Int): ViewBinder<MODEL> =
        if (viewType == STICKY_TYPE) {
            stickyItemCreator.invoke(context)
        } else {
            itemCreator.invoke(
                context
            )
        }

    override fun getItemViewType(position: Int) =
        if (items[position].isSticky) STICKY_TYPE else DEFAULT_TYPE

    override fun isStickyHeader(position: Int) =
        items[position].isSticky

    companion object ViewType {
        /**
         * View type for regular items.
         */
        const val DEFAULT_TYPE = 0

        /**
         * View type for sticky header items.
         */
        const val STICKY_TYPE = 1
    }
}
