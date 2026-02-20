package br.com.arch.toolkit.android.statemachine

import android.R
import android.transition.Fade
import android.transition.Scene
import android.widget.FrameLayout
import org.junit.Assert
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.Test

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class SceneStateMachineTest {

    @Test
    fun whenChangeState_shouldApplyViewChangesOnEachState() {
        val container = FrameLayout(RuntimeEnvironment.getApplication())
        val machine = SceneStateMachine()
        machine.setup {
            state(0) {
                scene(R.layout.activity_list_item to container)
                onEnter { }
            }
            state(1) {
                scene(R.layout.browser_link_context_header to container)
                transition(Fade())
                onExit { }
            }
            state(3) { scene(Scene(container)) }
        }

        machine.changeState(0)
        Assert.assertEquals(0, machine.getCurrentStateKey())
        Assert.assertNotNull(container.findViewById(R.id.icon))
        Assert.assertNull(container.findViewById(R.id.title))

        machine.changeState(1)
        Assert.assertEquals(1, machine.getCurrentStateKey())
        Assert.assertNotNull(container.findViewById(R.id.title))
        Assert.assertNull(container.findViewById(R.id.icon))
    }

    @Test
    fun withoutScene_shouldDoNothing() {
        val machine = SceneStateMachine()
        machine.setup {
            state(0) { onEnter { } }
            state(1) { onExit { } }
            state(2) {}
        }

        machine.changeState(0)
        Assert.assertEquals(0, machine.getCurrentStateKey())
        machine.changeState(1)
        Assert.assertEquals(1, machine.getCurrentStateKey())
        machine.changeState(2)
        Assert.assertEquals(2, machine.getCurrentStateKey())
    }
}
