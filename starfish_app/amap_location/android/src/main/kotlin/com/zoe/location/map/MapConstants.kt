package com.zoe.location.map

object MapConstants {

    //初始化
    const val Method_init = "init"

    //viewTypeId 与flutter层统一
    const val Platform_AMap_viewTypeId = "com.zoe.location.map.Map3DView"

    //通信channel地址
    const val Method_AMap_channelPath = "com.zoe.location.map.platform/MapViewChannel"

    //以下是参数名称
    const val ParamName_Url = "url"


    const val Method_Spline_init = "spline_init"
    const val Method_Spline_loadRes = "spline_loadRes"
    const val Method_Spline_loadUrl = "spline_loadUrl"
    const val Method_Spline_loadBuffer = "spline_loadBuffer"
}
