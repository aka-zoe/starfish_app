package com.zoe.wan.android

import android.os.Bundle
import com.umeng.commonsdk.UMConfigure
import com.zoe.location.map.platform.MapViewPlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UMConfigure.preInit(this,"66a64da0192e0574e74d5585","Android")

    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        //添加map地图插件
        flutterEngine.plugins.add(MapViewPlugin())
    }
}
