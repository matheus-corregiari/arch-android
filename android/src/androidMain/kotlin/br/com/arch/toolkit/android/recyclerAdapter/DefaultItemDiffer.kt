package br.com.arch.toolkit.android.recyclerAdapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * A default implementation of [DiffUtil.ItemCallback] that uses the equality operator (==)
 * for both item and content comparison.
 *
 * @param MODEL The type of data items being compared.
 */
class DefaultItemDiffer<MODEL : Any> : DiffUtil.ItemCallback<MODEL>() {
    /**
     * Checks if two items represent the same object using equality (==).
     */
    override fun areItemsTheSame(oldItem: MODEL, newItem: MODEL): Boolean = newItem == oldItem

    /**
     * Checks if two items have the same content using equality (==).
     */
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: MODEL, newItem: MODEL): Boolean = newItem == oldItem
}
