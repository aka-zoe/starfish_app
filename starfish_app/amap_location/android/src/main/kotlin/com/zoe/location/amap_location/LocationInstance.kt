package com.zoe.location.amap_location

import android.content.Context
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode
import com.amap.api.location.AMapLocationClientOption.AMapLocationProtocol
import com.amap.api.location.AMapLocationListener
import com.blankj.utilcode.util.LogUtils

/**
 * 定位工具
 */
class LocationInstance private constructor() {

    companion object {
        @Volatile
        private var instance: LocationInstance? = null

        @Synchronized
        fun instance(): LocationInstance {
            if (instance == null) {
                instance = LocationInstance()
            }
            return instance!!
        }
    }

    private var locationClient: AMapLocationClient? = null
    private var locationOption: AMapLocationClientOption? = null
    private var locationListener: LocationChangeListener? = null

    interface LocationChangeListener {
        fun onLocationChanged(location: AMapLocation?)
    }

    fun updatePrivacy(context: Context){
        //隐私合规更新
        AMapLocationClient.updatePrivacyShow(context.applicationContext, true, true)
        AMapLocationClient.updatePrivacyAgree(context.applicationContext, true)
    }

    /**
     * 初始化定位组件
     * [context]   上下文
     * [option]    可不填，默认定位配置
     * [listener]  定位回调
     */
    fun setLocation(
        context: Context, option: LocationOption? = buildDefaultOption(), listener:
        LocationChangeListener?
    ) {

        try {

            locationClient = AMapLocationClient(context.applicationContext)

            locationOption = getDefaultOption(option ?: buildDefaultOption())
            locationClient?.setLocationOption(locationOption)
            if (null != locationListener) {
                this.locationListener = listener
            }
            locationClient?.setLocationListener(object : AMapLocationListener {
                override fun onLocationChanged(location: AMapLocation?) {
                    locationListener?.onLocationChanged(location)
                }
            })
        } catch (e: Exception) {
            LogUtils.e("LocationInstance setLocation error=$e")
        }

    }

    /**
     * 开启定位功能，通过 [LocationChangeListener] 回调定位结果
     */
    fun startLocation() {
        try {
            locationClient?.setLocationOption(locationOption)
            locationClient?.startLocation()
        } catch (e: Exception) {
            LogUtils.e("LocationInstance startLocation error=$e")
        }
    }

    /**
     * 停止定位，但不是销毁
     */
    fun stopLocation() {
        try {
            locationClient?.stopLocation()
        } catch (e: Exception) {
            LogUtils.e("LocationInstance stopLocation error=$e")
        }
    }

    /**
     * 销毁定位
     */
    fun destroyLocation() {
        if (null != locationClient) {
            locationClient?.onDestroy()
            locationClient = null
            locationOption = null
            locationListener = null
        }
    }

    /**
     * 重新设置定位相关参数
     * [option]   设置参数
     */
    fun resetLocationOption(option: LocationOption) {
        val op = getDefaultOption(option)
        locationClient?.setLocationOption(op)
    }

    /**
     * 设置默认配置
     */
    private fun getDefaultOption(op: LocationOption): AMapLocationClientOption {
        val mOption = AMapLocationClientOption()
        mOption.setLocationMode(AMapLocationMode.Hight_Accuracy) //可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setGpsFirst(op.gpsFirst) //可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setHttpTimeOut(op.httpTimeOut) //可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setInterval(op.interval) //可选，设置定位间隔。默认为2秒
        mOption.setNeedAddress(op.needAddress) //可选，设置是否返回逆地理地址信息。默认是true
        mOption.setOnceLocation(op.onceLocation) //可选，设置是否单次定位。默认是false
        mOption.setOnceLocationLatest(op.onceLocationLatest) //可选，设置是否等待wifi刷新，默认为false.如果设置为true,
        // 会自动变为单次定位，持续定位时不要使用
        AMapLocationClientOption.setLocationProtocol(AMapLocationProtocol.HTTP) //可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        mOption.setSensorEnable(op.sensorEnable) //可选，设置是否使用传感器。默认是false
        mOption.setWifiScan(op.wifiScan)
        //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setLocationCacheEnable(op.locationCacheEnable) //可选，设置是否使用缓存定位，默认为true
        mOption.setGeoLanguage(AMapLocationClientOption.GeoLanguage.DEFAULT) //可选，设置逆地理信息的语言，默认值为默认语言（根据所在地区选择语言）
        return mOption
    }

    /**
     * 默认配置
     */
    private fun buildDefaultOption(
        gpsFirst: Boolean = false,
        httpTimeOut: Long = 30000,
        interval: Long = 2000,
        needAddress: Boolean = true,
        onceLocation: Boolean = false,
        onceLocationLatest: Boolean = false,
        sensorEnable: Boolean = false,
        wifiScan: Boolean = true,
        locationCacheEnable: Boolean = true
    ): LocationOption {
        return LocationOption(
            gpsFirst = gpsFirst,
            httpTimeOut = httpTimeOut,
            interval = interval,
            needAddress = needAddress,
            onceLocation = onceLocation,
            onceLocationLatest = onceLocationLatest,
            sensorEnable = sensorEnable,
            wifiScan = wifiScan,
            locationCacheEnable = locationCacheEnable
        )
    }
}
