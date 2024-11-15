package com.zoe.location.map.platform

import android.content.Context
import android.location.Location
import android.util.Log
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.maps.AMap
import com.amap.api.maps.LocationSource
import com.amap.api.maps.LocationSource.OnLocationChangedListener
import com.amap.api.maps.MapsInitializer
import com.amap.api.maps.TextureMapView
import com.blankj.utilcode.util.LogUtils
import com.zoe.location.map.MapConstants.Method_AMap_channelPath
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.platform.PlatformView


class MapViewController(
    private val context: Context?,
    messenger: BinaryMessenger,
    val id: Int,
    val params: HashMap<String, Any>
) : PlatformView, MethodChannel.MethodCallHandler, DefaultLifecycleObserver, LocationSource,
    OnLocationChangedListener {
    //    private var map3DView: Map3DView? = null
    private var mapView: TextureMapView? = null

    //通信
    private val channel: MethodChannel = MethodChannel(
        messenger, "$Method_AMap_channelPath$id"
    )

    init {
        channel.setMethodCallHandler(this)

        params.entries.forEach {
            Log.i("rex", "CustomView初始化接收入参：${it.key} - ${it.value}")
        }

    }

    override fun getView(): View? {
        //初始化地图组件
        if (mapView == null) {
            //在构造MapView之前必须进行合规检查
            MapsInitializer.updatePrivacyShow(context, true, true)
            MapsInitializer.updatePrivacyAgree(context, true)
            mapView = TextureMapView(context)
            val map = mapView?.map
            mapView?.onResume()
            mapView?.onCreate(null)
            map?.setOnMapLoadedListener {
                LogUtils.d("地图加载完成")
            }
            val uiSettings = map?.uiSettings
            //缩放按钮
            uiSettings?.isZoomControlsEnabled = false
            //指南针
            uiSettings?.isCompassEnabled = true
            //显示默认的定位按钮
            uiSettings?.isMyLocationButtonEnabled = true

            initLocation(map)
        }
        return mapView

    }

    private fun initLocation(map: AMap?) {
        map?.setLocationSource(this)
        //可触发定位并显示当前位置
        map?.isMyLocationEnabled = true
        map?.setMyLocationType(AMap.LOCATION_TYPE_LOCATE)

    }

    override fun dispose() {
        mapView?.onPause()
        mapView?.onDestroy()
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
//        when (call.method) {
//            //必须先初始化
//            MapConstants.Method_Spline_init -> {
//                result.success(true)
//            }
//
//            MapConstants.Method_Spline_loadRes -> {
//                result.success(true)
//            }
//
//            MapConstants.Method_Spline_loadUrl -> {
//                val url = call.argument<String>(MapConstants.ParamName_Url)
//                result.success(true)
//            }
//
//            MapConstants.Method_Spline_loadBuffer -> {
//                result.success(true)
//            }

//        }
    }

    private var mListener: OnLocationChangedListener? = null
    private var mlocationClient: AMapLocationClient? = null
    private var mLocationOption: AMapLocationClientOption? = null

    override fun activate(listener: LocationSource.OnLocationChangedListener?) {
        mListener = listener
        if (mlocationClient == null) {
            mlocationClient = AMapLocationClient(context)
            mLocationOption = AMapLocationClientOption()
        }
    }

    override fun deactivate() {

    }

    override fun onLocationChanged(location: Location?) {
        mListener?.onLocationChanged(location)
        LogUtils.d("地图 onLocationChanged location latitude=${location?.latitude }")
    }
}
