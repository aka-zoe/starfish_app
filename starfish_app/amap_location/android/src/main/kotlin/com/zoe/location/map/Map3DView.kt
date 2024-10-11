package com.zoe.location.map

import android.content.Context
import android.widget.Button
import android.widget.FrameLayout
import com.amap.api.maps.AMap
import com.amap.api.maps.MapView

class Map3DView(private val context: Context?) : FrameLayout(context!!), MapFunction {

    private var mapView: MapView? = null
    private var map: AMap? = null

    override fun init() {
        removeAllViews()
        mapView = MapView(context)
        map = mapView?.map
        map?.uiSettings?.zoomPosition
        addView(mapView)

    }

    override fun getAMap(): AMap? {
        return map
    }

    override fun onDestroy() {
        mapView?.onDestroy()
    }

    override fun onResume() {
        mapView?.onResume()
    }

    override fun onPause() {
        mapView?.onPause()
    }

}