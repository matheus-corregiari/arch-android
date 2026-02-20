package br.com.arch.toolkit.android.recyclerAdapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.android.recyclerAdapter.stickyheader.StickyHeaders

/**
 * A base implementation of [RecyclerView.Adapter] that uses [AsyncListDiffer] and [ViewBinder]
 * for efficient list updates and simplified view binding.
 *
 * @param MODEL The type of data to be displayed in the list.
 * @param differ The [DiffUtil.ItemCallback] to use for calculating list differences. Defaults to [DefaultItemDiffer].
 */
abstract class BaseRecyclerAdapter<MODEL : Any>(
    differ: DiffUtil.ItemCallback<MODEL> = DefaultItemDiffer()
) :
    RecyclerView.Adapter<BaseViewHolder>(), StickyHeaders {

    @Suppress("LeakingThis")
    private val listDiffer = AsyncListDiffer(this, differ)
    private val clickMap = hashMapOf<Int, (MODEL) -> Unit>()

    /**
     * The current list of items displayed by the adapter.
     */
    var items: List<MODEL>
        get() = listDiffer.currentList
        private set(value) {
            listDiffer.submitList(value)
        }

    private var onItemClick: ((MODEL) -> Unit)? = null

    /**
     * Creates a [ViewBinder] instance for a specific view type.
     *
     * @param context The Android [Context].
     * @param viewType The view type identifier.
     * @return An instance of [ViewBinder] that is also a [View].
     * @throws IllegalStateException If the returned [ViewBinder] is not a [View].
     */
    protected abstract fun viewCreator(context: Context, viewType: Int): ViewBinder<*>

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val viewBinder = viewCreator(parent.context, viewType)
        val itemView = viewBinder as? View
            ?: error("The ViewBinder instance also must be a View")
        return BaseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        bindHolder(holder, items[position], clickMap[getItemViewType(position)] ?: onItemClick)

    override fun isStickyHeader(position: Int) = false

    /**
     * Binds the data to the [BaseViewHolder].
     *
     * @param holder The [BaseViewHolder] to bind to.
     * @param model The data item.
     * @param onItemClick Optional click listener for the item.
     * @throws IllegalStateException If the holder's view does not implement [ViewBinder].
     */
    @Suppress("UNCHECKED_CAST")
    protected open fun <T> bindHolder(
        holder: BaseViewHolder,
        model: T,
        onItemClick: ((T) -> Unit)? = null
    ) {
        val binder = (holder.itemView as? ViewBinder<T>)
            ?: error("${holder.itemView::class} cannot be cast to ViewBinder<>")
        binder.bind(model)

        // Setup click listener
        onItemClick?.let { listener ->
            (binder as View).setOnClickListener { listener.invoke(model) }
        }
    }

    /**
     * Updates the list of items displayed by the adapter.
     *
     * @param newList The new list of items.
     */
    open fun setList(newList: List<MODEL>) {
        items = newList
    }

    /**
     * Sets a global click listener for all items.
     *
     * @param onItemClick The listener to be called on item click.
     * @return The adapter instance for chaining.
     */
    fun withListener(onItemClick: (MODEL) -> Unit): BaseRecyclerAdapter<MODEL> {
        this.onItemClick = onItemClick
        return this
    }

    /**
     * Sets a click listener for a specific view type.
     *
     * @param itemType The view type identifier.
     * @param onItemClick The listener to be called on item click.
     * @return The adapter instance for chaining.
     */
    fun withListener(
        itemType: Int,
        onItemClick: (model: MODEL) -> Unit
    ): BaseRecyclerAdapter<MODEL> {
        this.clickMap[itemType] = onItemClick
        return this
    }

    /**
     * Removes an item from the list.
     *
     * @param item The item to remove.
     */
    open fun removeItem(item: MODEL) = setList(items.minus(item))

    /**
     * Adds an item to the end of the list.
     *
     * @param item The item to add.
     */
    open fun addItem(item: MODEL) = setList(items.plus(item))
}
