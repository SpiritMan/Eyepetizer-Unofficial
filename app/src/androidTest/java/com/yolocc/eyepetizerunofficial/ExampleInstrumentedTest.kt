package com.yolocc.eyepetizerunofficial

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented main_setting_menu, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under main_setting_menu.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.yolocc.eyepetizerunofficial", appContext.packageName)
    }
}
