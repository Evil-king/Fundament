package com.hwq.fundamment.tools;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: wenqing
 * @date: 2019/5/27 4:53 PM
 * @description:
 */
@Slf4j
public class DateUtil {

    private DateUtil() {

    }

    /**
     * 线程安全的日期格式类
     */
    static final ThreadLocal<DateFormat> yyyyMMddHHmmssWithLine = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    /**
     * 线程安全的日期格式类
     */
    static final ThreadLocal<DateFormat> yyyyMMddHHmmssNoLine = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMddHHmmss"));

    /**
     * 线程安全的日期格式类
     */
    static final ThreadLocal<DateFormat> yyyyMMddWithLine = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    /**
     * 线程安全的日期格式类
     */
    static ThreadLocal<DateFormat> yyyyMMddNoLine = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

    /**
     * 线程安全的日期格式类
     */
    static ThreadLocal<DateFormat> HHmmssLine = ThreadLocal.withInitial(() -> new SimpleDateFormat("HH:mm"));

    /**
     * 线程安全的日期格式类
     */
    static ThreadLocal<DateFormat> HHmmssNoLine = ThreadLocal.withInitial(() -> new SimpleDateFormat("HHmmss"));

    /**
     * 获取当天指定时分秒的时间
     * 如：传 00:00:00或23:59:59
     *
     * @return
     */
    public static Date getCurrentStartOrEndTime(String period) {
        String s = yyyyMMddWithLine.get().format(new Date()) + " " + period;
        try {
            return yyyyMMddHHmmssWithLine.get().parse(s);
        } catch (ParseException e) {
            log.error("获取失败", e);
            return null;
        }
    }

    /**
     * 获取指定日期0点
     *
     * @param date
     * @return
     */
    public static Date getBeginDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获取当天的0点
     *
     * @return
     */
    public static Date getBeginDay() {
        return getBeginDay(new Date());
    }

    /**
     * 获取指定日期23:59:59秒日期
     *
     * @param date
     * @return
     */
    public static Date getEndDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    /**
     * 获取指定日期23:59:59秒日期
     *
     * @return
     */
    public static Date getEndDay() {
        return getEndDay(new Date());
    }

    /**
     * 拼接指定的时分秒,年月日为当前时间
     *
     * @param hhmmss
     * @return
     */
    public static Date appendHhmmss(String hhmmss) {
        Date now = new Date();
        StringBuilder sb = new StringBuilder(yyyyMMddWithLine.get().format(now)).append(" ").append(hhmmss);
        try {
            return yyyyMMddHHmmssWithLine.get().parse(sb.toString());
        } catch (ParseException e) {
            log.error("处理失败", e);
        }
        return null;
    }


    /**
     * 获取当天中午12点的时间
     *
     * @return
     */
    public static Date getMiddleTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取从现在开始的一天
     *
     * @return
     */
    public static String get1DayByNowTime() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return yyyyMMddHHmmssWithLine.get().format(cal.getTime());
    }

    /**
     * 获取当前日期基础上增加指定分数后的日期
     *
     * @param minute
     * @return
     */
    public static Date addMinute(int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    /**
     * 获取当前日期基础上增加指定天数后的日期
     *
     * @param day
     * @return
     */
    public static Date addDay(int day) {
        long addTime = (60L * 1000L * 60L * 24L) * (long) day;//一天
        String nowDay = yyyyMMddWithLine.get().format(new Date());
        try {
            Date currentDate = yyyyMMddHHmmssWithLine.get().parse(nowDay + " 00:00:00");
            long currentTime = currentDate.getTime();
            long resultTime = currentTime + addTime;
            return new Date(resultTime);
        } catch (ParseException e) {
            log.error("处理失败", e);
            return null;
        }
    }

    public static String changeTimes(Long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     * @author jqlin
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }


    public static boolean isEffectiveDateStr(String nowTime, String sTime, String eTime) {
        if (nowTime.compareTo(sTime) >= 0 && nowTime.compareTo(eTime) <= 0) {
            return false;
        }
        return true;
    }


    /**
     * 判断时间是否在某个时间段内
     *
     * @param s1 时间段开始时间,形如22:30:00
     * @param s2 时间段结束时间,形如06:00:00
     * @return boolean
     */
    public static boolean isInTimeRange(String s1, String s2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String localTime = LocalTime.now().format(formatter);
//        String localTime = "04:03:46";
        int set = Integer.valueOf(localTime.replaceAll(":", ""));
        int begin = Integer.valueOf(s1.replaceAll(":", ""));
        int end = Integer.valueOf(s2.replaceAll(":", ""));
        if (begin >= end) {
            return set <= end || set >= begin;
        } else {
            return set >= begin && set <= end;
        }
    }

    public static void main(String[] args) {
        String sTime = "13:08:45";
        String eTime = "04:03:45";
        System.out.println(isInTimeRange(sTime, eTime));
    }

    /**
     * 此处的time格式必须为时间，不能包含日期
     *
     * @param time
     * @return
     */
    public static Date getNowDate(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date now = new Date();
        SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd ");
        Date date = new Date();
        try {
            date = df.parse(ds.format(now) + time);
        } catch (ParseException e) {
            log.error("处理失败", e);
        }
        return date;
    }

    /**
     * 判断传入时间是否是当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        return yyyyMMddNoLine.get().format(date).equals(yyyyMMddNoLine.get().format(new Date()));
    }

    /**
     * 将时间字符串转为毫秒值（以HH:mm:ss格式）
     *
     * @param date
     * @return
     */
    public static long strToLong(String date) {
        long timeInMillis = 0L;
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new SimpleDateFormat("HH:mm:ss").parse(date));
            timeInMillis = calendar.getTimeInMillis();
        } catch (ParseException e) {
            log.error("处理失败", e);
        }
        return timeInMillis;
    }

    /**
     * 字符串转时间（以yyyy-MM-dd HH:mm:ss格式）
     *
     * @param date
     * @return
     */
    public static Date strToDate(String date) {
        Date time = null;
        try {
            time = DateUtil.yyyyMMddHHmmssWithLine.get().parse(date);
        } catch (ParseException e) {
            log.error("处理失败", e);
        }
        return time;
    }

}
