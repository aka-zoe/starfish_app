package com.zoe.starfish_server.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * The type Time utils.
 */
public class TimeUtils {

    /**
     * The constant sdf.
     */
    public final static String sdf = "yyyy-MM-dd HH:mm:ss";

    public static final String sdf_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss:SSS";

    /**
     * The constant defaultSdf.
     */
    public final static String defaultSdf = "yyyy-MM-dd HH:00:00";
    /**
     * The constant defaultDaySdf.
     */
    public final static String defaultDaySdf = "yyyy-MM-dd 00:00:00";
    /**
     * The constant sdf1.
     */
    public final static String sdf1 = "yyyy-MM-dd";
    /**
     * The constant sdf2.
     */
    public final static String sdf2 = "yyyyMMdd HHmmss";
    /**
     * The constant sdf3.
     */
    public final static String sdf3 = "yyyy-MM-dd HH:mm";
    /**
     * The constant sdf4.
     */
    public final static String sdf4 = "yyyy-MM-dd HH";
    /**
     * The constant hourFormat.
     */
    public final static String hourFormat = "HH:mm";
    /**
     * The constant SECONDSTR.
     */
    // 时间格式
    public final static String SECONDSTR = "yyyy-MM-dd HH:mm:ss";
    /**
     * The constant MINUTESTR.
     */
    public final static String MINUTESTR = "yyyy-MM-dd HH:mm";
    /**
     * The constant HOURSTR.
     */
    public final static String HOURSTR = "yyyy-MM-dd HH";
    /**
     * The constant DAYSTR.
     */
    public final static String DAYSTR = "yyyy-MM-dd";
    /**
     * The constant DEFAULTMINUTESTR.
     */
    public final static String DEFAULTMINUTESTR = "yyyy-MM-dd HH:mm:00";
    /**
     * The constant DEFAULTHOURSTR.
     */
    public final static String DEFAULTHOURSTR = "yyyy-MM-dd HH:00:00";
    /**
     * The constant DEFAULTDAYSTR.
     */
    public final static String DEFAULTDAYSTR = "yyyy-MM-dd 00:00:00";
    /**
     * The constant time.
     */
    public final static String time = "yyyyMMdd";
    /**
     * The constant YEARMONTH.
     */
    public final static String YEARMONTH = "yyyyMM";
    private static ThreadLocal<DateFormat> threadLocal_day = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_defaultday = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_hour = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_defaulthour = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_minute = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_defaultminute = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_second = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_time = new ThreadLocal<DateFormat>();
    private static ThreadLocal<DateFormat> threadLocal_yearmonth = new ThreadLocal<DateFormat>();

    private static List<String> last3months = Collections.synchronizedList(new ArrayList<>());


    public static String convertTimestampToDateStr(String dateStr, String format) {
        if (dateStr == null) {
            return null;
        }
        if (format == null) {
            format = sdf;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.parseLong(dateStr)));
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyyMMdd
     *
     * @return date format by time
     */
    public static DateFormat getDateFormatByTime() {
        DateFormat df = threadLocal_time.get();
        if (df == null) {
            df = new SimpleDateFormat(time);
            threadLocal_time.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyy-MM-dd
     *
     * @return date format by day
     */
    public static DateFormat getDateFormatByDay() {
        DateFormat df = threadLocal_day.get();
        if (df == null) {
            df = new SimpleDateFormat(DAYSTR);
            threadLocal_day.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyy-MM-dd 00:00:00
     *
     * @return date format by default day
     */
    public static DateFormat getDateFormatByDefaultDay() {
        DateFormat df = threadLocal_defaultday.get();
        if (df == null) {
            df = new SimpleDateFormat(DEFAULTDAYSTR);
            threadLocal_defaultday.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyy-MM-dd HH
     *
     * @return date format by hour
     */
    public static DateFormat getDateFormatByHour() {
        DateFormat df = threadLocal_hour.get();
        if (df == null) {
            df = new SimpleDateFormat(HOURSTR);
            threadLocal_hour.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyy-MM-dd HH:00:00
     *
     * @return date format by default hour
     */
    public static DateFormat getDateFormatByDefaultHour() {
        DateFormat df = threadLocal_defaulthour.get();
        if (df == null) {
            df = new SimpleDateFormat(DEFAULTHOURSTR);
            threadLocal_defaulthour.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyy-MM-dd HH:mm
     *
     * @return date format by minute
     */
    public static DateFormat getDateFormatByMinute() {
        DateFormat df = threadLocal_minute.get();
        if (df == null) {
            df = new SimpleDateFormat(MINUTESTR);
            threadLocal_minute.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyy-MM-dd HH:mm:00
     *
     * @return date format by default minute
     */
    public static DateFormat getDateFormatByDefaultMinute() {
        DateFormat df = threadLocal_defaultminute.get();
        if (df == null) {
            df = new SimpleDateFormat(DEFAULTMINUTESTR);
            threadLocal_defaultminute.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyy-MM-dd HH:mm:ss
     *
     * @return date format by second
     */
    public static DateFormat getDateFormatBySecond() {
        DateFormat df = threadLocal_second.get();
        if (df == null) {
            df = new SimpleDateFormat(SECONDSTR);
            threadLocal_second.set(df);
        }
        return df;
    }

    /**
     * 获取线程安全的DateFormat 时间格式:yyyyMM
     *
     * @return the date format by yearmonth
     */
    public static DateFormat getDateFormatByYearmonth() {
        DateFormat df = threadLocal_yearmonth.get();
        if (df == null) {
            df = new SimpleDateFormat(YEARMONTH);
            threadLocal_yearmonth.set(df);
        }
        return df;
    }

    /**
     * Gets date format.
     *
     * @param str the str
     * @return the date format
     */
    public static DateFormat getDateFormat(String str) {
        if (str.equals(DAYSTR) || str.equals(sdf1)) {
            return getDateFormatByDay();
        } else if (str.equals(DEFAULTDAYSTR) || str.equals(defaultDaySdf)) {
            return getDateFormatByDefaultDay();
        } else if (str.equals(HOURSTR) || str.equals(sdf4)) {
            return getDateFormatByHour();
        } else if (str.equals(DEFAULTHOURSTR) || str.equals(defaultSdf)) {
            return getDateFormatByDefaultHour();
        } else if (str.equals(MINUTESTR) || str.equals(sdf3)) {
            return getDateFormatByMinute();
        } else if (str.equals(DEFAULTMINUTESTR)) {
            return getDateFormatByDefaultMinute();
        } else if (str.equals(SECONDSTR) || str.equals(sdf)) {
            return getDateFormatBySecond();
        } else {
            return getDateFormatBySecond();
        }
    }

    /**
     * Gets format time.
     *
     * @return the format time
     */
    public static Date getFormatTime() {
        Date ts = new Date(System.currentTimeMillis());
        return ts;
    }

    /**
     * Gets format time by str.
     *
     * @param time the time
     * @return the format time by str
     * @throws ParseException the parse exception
     */
    public static Date getFormatTimeByStr(String time) throws ParseException {
        // sdf.parse(time);
        return getDateFormatBySecond().parse(time);
    }

    /**
     * Gets format time by str.
     *
     * @param time the time
     * @param sdf  the sdf
     * @return the format time by str
     * @throws ParseException the parse exception
     */
    public static Date getFormatTimeByStr(String time, String sdf) throws ParseException {
        return getDateFormat(sdf).parse(time);
        // return sdf.parse(time);
    }

    /**
     * Parse to format time string.
     *
     * @param date the date
     * @return the string
     */
    public static String parseToFormatTime(Date date) {
        SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
        return sdf.format(date);
    }

    /**
     * Parse to format time string.
     *
     * @param date the date
     * @param sdf  the sdf
     * @return the string
     */
    public static String parseToFormatTime(Date date, String sdf) {
        return getDateFormat(sdf).format(date);
        // return sdf.format(date);
    }


    /**
     * Parse time long.
     *
     * @param time the time
     * @return the long
     * @throws Exception the exception
     */
    public static Long parseTime(String time) throws Exception {
        Long result = null;
        try {
            result = getDateFormat(SECONDSTR).parse(time.toString()).getTime();
        } catch (Exception e) {
            try {
                result = getDateFormat(MINUTESTR).parse(time.toString()).getTime();
            } catch (ParseException e1) {
                result = getDateFormat(HOURSTR).parse(time.toString()).getTime();
            }
        }
        return result;
    }

    /**
     * Parse to date date.
     *
     * @param time the time
     * @param sdf  the sdf
     * @return the date
     * @throws Exception the exception
     */
    public static Date parseToDate(String time, String sdf) throws Exception {
        return getDateFormat(sdf).parse(time);
    }

    /**
     * Parse to long long.
     *
     * @param date the date
     * @return the long
     * @throws Exception the exception
     */
    public static Long parseToLong(Date date) throws Exception {
        String timeStr = getDateFormat(TimeUtils.DEFAULTMINUTESTR).format(date);
        Long time = parseToDate(timeStr, TimeUtils.DEFAULTMINUTESTR).getTime();
        return time;
    }

    /**
     * 格式化时间:XX小时xx分XX秒
     *
     * @param timeLen the time len
     * @return string string
     */
    public static String parseTimeStamp(long timeLen) {
        // 余数超过500则进位
        long remainder = timeLen % 1000;
        timeLen = timeLen / 1000;
        if (remainder >= 500) {
            timeLen += 1;
        }
        if (timeLen < 60) {
            return timeLen + "秒";
        } else if (timeLen > 60 && timeLen < 3600) {
            long minute = timeLen / 60;
            return minute + "分" + timeLen % 60 + "秒";
        } else if (timeLen > 3600) {
            long hour = timeLen / (60 * 60);
            long minute = (timeLen % (60 * 60)) / 60;
            return hour + "时" + minute + "分" + (timeLen % (60 * 60)) % 60 + "秒";
        }
        return null;
    }

    /**
     * Format default time string.
     *
     * @param timeStr the time str
     * @return the string
     * @throws Exception the exception
     */
    public static String formatDefaultTime(String timeStr) throws Exception {
        Date date = parseToDate(timeStr, TimeUtils.SECONDSTR);
        String string = TimeUtils.getDateFormatBySecond().format(date);
        return string;
    }

    /**
     * Gets date add days.
     *
     * @param date     the date
     * @param add_days the add days
     * @return the date add days
     */
    public static Date getDateAddDays(Date date, int add_days) {
        Calendar time = Calendar.getInstance();
        time.setTime(date);
        time.add(5, add_days);
        return time.getTime();
    }

    /**
     * Curr time stamp long.
     *
     * @return the long
     */
    public static Long currTimeStamp() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long nowTimeStamp = c.getTimeInMillis();
        return nowTimeStamp;
    }

    /**
     * 获取连续3个月
     *
     * @return list
     */
    public static List<String> getLast3Months() {
        last3months.clear();
        for (int i = 0; i <= 2; i++) {
            last3months.add(getLastMonths(i));
        }
        return last3months;
    }

    /**
     * 传入偏移量获取月份
     *
     * @param i the
     * @return last months
     */
    public static String getLastMonths(int i) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        Date m = c.getTime();
        return getDateFormatByYearmonth().format(m);
    }

    /**
     * 传入日期转为long值
     *
     * @param time
     * @return
     */
    public static Long convertTimeToLong(String time) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern(sdf);
        LocalDateTime parse = LocalDateTime.parse(time + " 00:00:00", formatter);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
