package com.zoe.location.amap_location

import android.content.Context
import androidx.annotation.NonNull
import com.amap.api.location.AMapLocation
import com.blankj.utilcode.util.GsonUtils
import com.zoe.location.amap_location.PluginConstants.EVENT_CALLBACK_LOCATION
import com.zoe.location.amap_location.PluginConstants.EVENT_NAME
import com.zoe.location.amap_location.PluginConstants.METHOD_DESTROY_LOCATION
import com.zoe.location.amap_location.PluginConstants.METHOD_INIT_LOCATION
import com.zoe.location.amap_location.PluginConstants.METHOD_NAME
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
                        ),
                        listener = object
                            : LocationInstance.LocationChangeListener {
                            override fun onLocationChanged(location: AMapLocation?) {
                                runCatching {
                                    //将返回的定位数据转为json处理，回调给flutter
                                    val json: String = GsonUtils.toJson(location)
                                    val map = mutableMapOf<String, String>()
                                    map[EVENT_CALLBACK_LOCATION] = json
                                    eventSink?.success(map)
                                }
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

            else ->{
                result.notImplemented()
            }

        }

    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        methodChannel?.setMethodCallHandler(null)
        eventChannel?.setStreamHandler(null)
    }

    override fun onListen(arguments: Any?, events: EventChannel.EventSink?) {
        eventSink = events
    }

    override fun onCancel(arguments: Any?) {
        eventSink = null
    }

}
