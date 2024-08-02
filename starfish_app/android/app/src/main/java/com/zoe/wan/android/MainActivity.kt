package com.zoe.wan.android

import android.os.Bundle
import com.umeng.commonsdk.UMConfigure
import io.flutter.embedding.android.FlutterActivity

class MainActivity: FlutterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UMConfigure.preInit(this,"66a64da0192e0574e74d5585","Android")
    }
}
