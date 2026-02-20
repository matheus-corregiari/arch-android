package br.com.arch.toolkit.android.recyclerAdapter.stickyheader

import android.view.View

/**
 * Interface to be implemented by [androidx.recyclerview.widget.RecyclerView.Adapter] to support
 * sticky headers.
 */
interface StickyHeaders {

    /**
     * Checks if the item at the given [position] should be a sticky header.
     *
     * @param position The adapter position of the item.
     * @return true if the item is a sticky header, false otherwise.
     */
    fun isStickyHeader(position: Int): Boolean

    /**
     * Interface for setting up and tearing down the sticky header view.
     */
    interface ViewSetup {
        /**
         * Adjusts any necessary properties of the [stickyHeader] view when it becomes a sticky header.
         *
         * @param stickyHeader The view used as a sticky header.
         */
        fun setupStickyHeaderView(stickyHeader: View)

        /**
         * Reverts any changes made in [setupStickyHeaderView].
         *
         * @param stickyHeader The view used as a sticky header.
         */
        fun teardownStickyHeaderView(stickyHeader: View)
    }
}
