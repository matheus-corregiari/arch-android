package br.com.arch.toolkit.android.delegate

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * A property delegate for retrieving a [ViewModel] from [AppCompatActivity], [Fragment], [View], or [ViewHolder].
 *
 * @param T The type of the [ViewModel].
 * @property kClass The class of the [ViewModel] to provide.
 */
class ViewModelProviderDelegate<out T : ViewModel> internal constructor(
    private val kClass: KClass<T>
) {

    operator fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T =
        thisRef.defaultViewModelProviderFactory.create(kClass.java)

    operator fun getValue(thisRef: Fragment, property: KProperty<*>): T =
        thisRef.defaultViewModelProviderFactory.create(kClass.java)

    operator fun getValue(thisRef: View, property: KProperty<*>): T =
        getValue(thisRef.context as AppCompatActivity, property)

    operator fun getValue(thisRef: ViewHolder, property: KProperty<*>): T =
        getValue(thisRef.itemView, property)
}

/**
 * Creates a [ViewModelProviderDelegate] for the specified [ViewModel] type.
 */
inline fun <reified T : ViewModel> viewModelProvider() = viewModelProvider(T::class)

/**
 * Creates a [ViewModelProviderDelegate] for the specified [KClass].
 *
 * @param kClass The class of the [ViewModel].
 */
fun <T : ViewModel> viewModelProvider(kClass: KClass<T>) =
    ViewModelProviderDelegate(kClass = kClass)
