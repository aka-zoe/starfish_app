package com.zoe.location.map

import com.amap.api.maps.AMap

interface MapFunction {
    fun init()

    fun getAMap(): AMap?

    fun onDestroy()

    fun onResume()

    fun onPause()
}