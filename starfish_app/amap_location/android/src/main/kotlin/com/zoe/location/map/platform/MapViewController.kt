package com.zoe.location.map.platform

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import com.amap.api.maps.MapsInitializer
import com.amap.api.maps.TextureMapView
import com.blankj.utilcode.util.LogUtils
import com.zoe.location.map.Map3DView
import com.zoe.location.map.MapConstants.Method_AMap_channelPath
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.platform.PlatformView
import java.util.HashMap

class MapViewController(
    private val context: Context?,
    messenger: BinaryMessenger,
    val id: Int,
    val params: HashMap<String, Any>
) : PlatformView, MethodChannel.MethodCallHandler, DefaultLifecycleObserver {
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
//            mapView?.init()
//            map3DView?.onResume()
        }
        return mapView

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


}
