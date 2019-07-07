package com.yolocc.eyepetizerunofficial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yolocc.eyepetizerunofficial.base.BaseActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import kotlin.concurrent.thread

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LandingActivity : BaseActivity() {

    override fun init() {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                startActivity<MainActivity>()
                finish()
            }
        }
    }

    override fun getLayoutRes(): Int = R.layout.activity_landing

}
