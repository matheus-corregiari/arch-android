package br.com.arch.toolkit.android.statemachine

import android.view.View
import android.widget.TextView
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class ViewStateMachineTest {

    private lateinit var view1: TextView
    private lateinit var view2: TextView
    private lateinit var view3: TextView
    private lateinit var view4: TextView
    private lateinit var view5: TextView

    @BeforeTest
    fun setupViews() = with(RuntimeEnvironment.getApplication()) {
        view1 = TextView(this)
        view2 = TextView(this)
        view3 = TextView(this)
        view4 = TextView(this)
        view5 = TextView(this)
    }

    @Test
    fun whenChangeState_shouldApplyViewChangesOnEachState() {
        val machine = ViewStateMachine()
        machine.setup {
            state(0) {
                visibles(null, view1)
                invisibles(null, view2)
                gones(null, view3)
                enables(null, view4)
                disables(null, view5)
                onEnter { }
            }
            state(1) {
                visibles(view3)
                invisibles(view1)
                gones(view2)
                enables(view5)
                disables(view4)
                onExit { }
            }
        }

        assertEquals(View.VISIBLE, view1.visibility)
        assertEquals(View.VISIBLE, view2.visibility)
        assertEquals(View.VISIBLE, view3.visibility)
        assertTrue(view4.isEnabled)
        assertTrue(view5.isEnabled)

        machine.changeState(0)

        assertEquals(View.VISIBLE, view1.visibility)
        assertEquals(View.INVISIBLE, view2.visibility)
        assertEquals(View.GONE, view3.visibility)
        assertTrue(view4.isEnabled)
        assertFalse(view5.isEnabled)

        machine.changeState(1)

        assertEquals(View.INVISIBLE, view1.visibility)
        assertEquals(View.GONE, view2.visibility)
        assertEquals(View.VISIBLE, view3.visibility)
        assertFalse(view4.isEnabled)
        assertTrue(view5.isEnabled)
    }
}
