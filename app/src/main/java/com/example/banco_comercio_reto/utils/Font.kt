package com.example.banco_comercio_reto.utils

import android.app.Application
import com.example.banco_comercio_reto.R
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class Font : Application() {
    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder().setDefaultFontPath("font/Lato-Light.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build()
        )
    }
}