package br.com.arch.toolkit.android.delegate

import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull
import kotlin.test.assertSame

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class ViewProviderDelegateTest {

    private val optional: View? = null
    private val required: View? = null

    @Test
    fun missingParent_returnsNullForOptionalView() {
        val root = FrameLayout(RuntimeEnvironment.getApplication())
        root.addView(View(root.context).apply { id = 100 })
        assertNull(optionalViewProvider<View>(100, 200).getValue(root, ::optional))
    }

    @Test
    fun missingParent_reportsRequiredViewWithPropertyName() {
        val root = FrameLayout(RuntimeEnvironment.getApplication())
        val failure = assertFailsWith<IllegalStateException> {
            viewProvider<View>(100, 200).getValue(root, ::required)
        }
        assertEquals("View ID 100 for 'required' not found.", failure.message)
    }

    @Test
    fun missingActivityParent_obeysOptionalAndRequiredContracts() {
        val controller = Robolectric.buildActivity(AppCompatActivity::class.java)
        try {
            val activity = controller.get()
            activity.setTheme(androidx.appcompat.R.style.Theme_AppCompat)
            controller.setup()
            assertNull(optionalViewProvider<View>(100, 200).getValue(activity, ::optional))
            assertFailsWith<IllegalStateException> {
                viewProvider<View>(100, 200).getValue(activity, ::required)
            }
        } finally {
            controller.pause().stop().destroy()
        }
    }

    @Test
    fun presentParent_findsOnlyItsChild() {
        val context = RuntimeEnvironment.getApplication()
        val root = FrameLayout(context)
        val parent = FrameLayout(context).apply { id = 200 }
        val child = View(context).apply { id = 100 }
        root.addView(View(context).apply { id = 100 })
        root.addView(parent)
        parent.addView(child)
        assertSame(child, viewProvider<View>(100, 200).getValue(root, ::required))
    }
}
