package com.zoe.location.amap_location

/**
 *  mOption.setLocationMode(AMapLocationMode.Hight_Accuracy) //可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
 *         mOption.setGpsFirst(op.gpsFirst) //可选，设置是否gps优先，只在高精度模式下有效。默认关闭
 *         mOption.setHttpTimeOut(op.httpTimeOut) //可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
 *         mOption.setInterval(op.interval) //可选，设置定位间隔。默认为2秒
 *         mOption.setNeedAddress(op.needAddress) //可选，设置是否返回逆地理地址信息。默认是true
 *         mOption.setOnceLocation(op.onceLocation) //可选，设置是否单次定位。默认是false
 *         mOption.setOnceLocationLatest(op.onceLocationLatest) //可选，设置是否等待wifi刷新，默认为false.如果设置为true,
 *         // 会自动变为单次定位，持续定位时不要使用
 *         AMapLocationClientOption.setLocationProtocol(AMapLocationProtocol.HTTP) //可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
 *         mOption.setSensorEnable(op.sensorEnable) //可选，设置是否使用传感器。默认是false
 *         mOption.setWifiScan(op.wifiScan)
 *         //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
 *         mOption.setLocationCacheEnable(op.locationCacheEnable) //可选，设置是否使用缓存定位，默认为true
 *         mOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT) //可选，设置逆地理信息的语言，默认值为默认语言（根据所在地区选择语言）
 */
data class LocationOption(var gpsFirst: Boolean = false,
                          var httpTimeOut: Long = 30000,
                          var interval: Long = 2000,
                          var needAddress: Boolean = true,
                          var onceLocation: Boolean = false,
                          var onceLocationLatest: Boolean = false,
                          var sensorEnable: Boolean = false,
                          var wifiScan: Boolean = true,
                          var locationCacheEnable: Boolean = true)
