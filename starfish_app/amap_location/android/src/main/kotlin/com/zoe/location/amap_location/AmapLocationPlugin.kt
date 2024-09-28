package com.zoe.location.amap_location

import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.blankj.utilcode.util.GsonUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.zoe.location.amap_location.PluginConstants.EVENT_CALLBACK_LOCATION
import com.zoe.location.amap_location.PluginConstants.EVENT_NAME
import com.zoe.location.amap_location.PluginConstants.METHOD_DESTROY_LOCATION
import com.zoe.location.amap_location.PluginConstants.METHOD_INIT_LOCATION
import com.zoe.location.amap_location.PluginConstants.METHOD_NAME
import com.zoe.location.amap_location.PluginConstants.METHOD_SET_API_KEY
import com.zoe.location.amap_location.PluginConstants.METHOD_START_LOCATION
import com.zoe.location.amap_location.PluginConstants.METHOD_STOP_LOCATION
import com.zoe.location.amap_location.PluginConstants.METHOD_UPDATE_PRIVACY

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.EventChannel
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** AmapLocationPlugin */
class AmapLocationPlugin : FlutterPlugin, MethodCallHandler, EventChannel.StreamHandler {
    private var methodChannel: MethodChannel? = null
    private var eventChannel: EventChannel? = null
    private var context: Context? = null
    private var eventSink: EventChannel.EventSink? = null

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        context = flutterPluginBinding.applicationContext
        methodChannel = MethodChannel(flutterPluginBinding.binaryMessenger, METHOD_NAME)
        methodChannel?.setMethodCallHandler(this)
        eventChannel = EventChannel(flutterPluginBinding.binaryMessenger, EVENT_NAME)
        eventChannel?.setStreamHandler(this)
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {

        when (call.method) {

            METHOD_SET_API_KEY -> {
                val key: String? = call.argument("key")
                Log.d("METHOD_SET_API_KEY", key.toString())
                AMapLocationClient.setApiKey(key)
                result.success(true)
                return
            }

            //更新用户隐私政策
            METHOD_UPDATE_PRIVACY -> {
                context?.let {
                    LocationInstance.instance().updatePrivacy(it)
                }
                result.success(true)
                return
            }

            //初始化
            METHOD_INIT_LOCATION -> {

                val interval: Int? = call.argument("interval")
                val httpTimeOut: Int? = call.argument("httpTimeOut")

                context?.let {
                    LocationInstance.instance().setLocation(context = it,
                        option = LocationOption(
                            interval = (interval?.toLong()) ?: 2000,
                            httpTimeOut = (httpTimeOut?.toLong()) ?: 30000
                        ), locationCallback = {location->
                            LogUtils.i("METHOD_INIT_LOCATION  location=${location.toString()}")
                            try {
                                //将返回的定位数据转为json处理，回调给flutter
                                val json: String = GsonUtils.toJson(location)
                                val map = mutableMapOf<String, String>()
                                map[EVENT_CALLBACK_LOCATION] = json
                                eventSink?.success(map)
                            } catch (e: Exception) {
                                LogUtils.i("METHOD_INIT_LOCATION  error=${e.toString()}")
                            }
                        })
                }
                result.success(true)
                return
            }

            //开启定位
            METHOD_START_LOCATION -> {
                LocationInstance.instance().startLocation()
                result.success(true)
                return
            }

            //停止定位
            METHOD_STOP_LOCATION -> {
                LocationInstance.instance().stopLocation()
                result.success(true)
                return
            }

            //销毁定位
            METHOD_DESTROY_LOCATION -> {
                LocationInstance.instance().destroyLocation()
                result.success(true)
                return
            }

            else -> {
                result.notImplemented()
            }

        }

    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        methodChannel?.setMethodCallHandler(null)
        eventChannel?.setStreamHandler(null)
    }

    override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
        LogUtils.i("onListen eventSink=$events")
        eventSink = events
    }

    override fun onCancel(arguments: Any?) {
        eventSink = null
    }

}
