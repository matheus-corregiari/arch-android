package br.com.arch.toolkit.android.recyclerAdapter

/**
 * Interface to be implemented by custom [android.view.View]s to handle data binding
 * when used with [BaseRecyclerAdapter].
 *
 * @param MODEL The type of data to be bound to the view.
 */
interface ViewBinder<in MODEL> {
    /**
     * Binds the [model] data to the view.
     *
     * @param model The data instance to bind.
     */
    fun bind(model: MODEL)
}
