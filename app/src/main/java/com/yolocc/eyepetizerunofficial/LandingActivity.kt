package com.yolocc.eyepetizerunofficial

import com.yolocc.eyepetizerunofficial.base.BaseActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LandingActivity : BaseActivity() {

    override fun init() {
        GlobalScope.launch {
            delay(2000)
            startActivity<MainActivity>()
            finish()
        }

    }

    override fun getLayoutRes(): Int = R.layout.activity_landing

}
