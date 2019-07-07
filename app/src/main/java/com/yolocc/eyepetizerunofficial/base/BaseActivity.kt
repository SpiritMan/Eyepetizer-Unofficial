package com.yolocc.eyepetizerunofficial.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    private var density = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        init()
    }

    abstract fun init()

    abstract fun getLayoutRes():Int

    //防止字体随系统修改而改变
    override fun onConfigurationChanged(newConfig: Configuration) {
        if(newConfig.fontScale != 1f) {
            resources
        }
        super.onConfigurationChanged(newConfig)
    }

    override fun getResources(): Resources {
        val res = super.getResources()
        if(res.configuration.fontScale != 1f) {
            val newConfig = Configuration()
            newConfig.setToDefaults()
            res.updateConfiguration(newConfig, res.displayMetrics)
        }
        //同步这只density，解决横屏息屏后UI问题，问题原因是息屏后density变化导致， 推出原因是谷歌广告造成，目前只想到这种方式来解决
        if(density != 0f) {
            res?.displayMetrics?.density = density
        }
        return res
    }
}