package com.zoe.location.map.platform

import com.zoe.location.map.MapConstants
import io.flutter.embedding.engine.plugins.FlutterPlugin

class MapViewPlugin : FlutterPlugin {
    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {

        //将 Android 控件进行注册，提供 flutter 层使用
        binding.platformViewRegistry.registerViewFactory(
            MapConstants.Platform_AMap_viewTypeId,
            MapViewFactory(binding.binaryMessenger)
        )

    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    }

}
