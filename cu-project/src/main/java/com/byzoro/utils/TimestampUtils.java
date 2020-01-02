package com.byzoro.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间戳获取
 *
 * @author msj
 */
public class TimestampUtils {

    /**
     * 获取今天早上0点0分0秒时间戳
     *
     * @return
     */
    public static long morningTime() {
        //当前时间毫秒数
        long current = System.currentTimeMillis();
        //今天零点零分零秒的毫秒数
        long zero = (current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset()) / 1000;
        return zero;
    }

    /**
     * 获取今天晚上23点59分59秒
     *
     * @return
     */
    public static long eveningTime() {
        //当前时间毫秒数
        long current = System.currentTimeMillis();
        //今天零点零分零秒
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
        //今天23点59分59秒
        long twelve = (zero + 24 * 60 * 60 * 1000 - 1) / 1000;
        return twelve;
    }

    /**
     * 当前时间戳
     */
    public static long currentTimestamp() {
        //当前时间秒数
        long current = System.currentTimeMillis() / 1000;
        return current;
    }

    /**
     * 获取前一天时间
     */
    public static long yesterDayTimestamp() {
        //昨天的这一时间
        long yesterday = (System.currentTimeMillis() - 24 * 60 * 60 * 1000) / 1000;
        return yesterday;
    }

    /**
     * 获取前一周时间戳
     */
    public static long weekDayTimestamp() {
        //前一周时间戳
        long weekDay = (System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000) / 1000;
        return weekDay;
    }

    /**
     * 获取前一月时间戳
     */
    public static long monthDayTimestamp() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(mon);
        long ts = date.getTime() / 1000;
        return ts;
    }

    /**
     * 自定义开始时间戳
     */
    public static long startTime(String startTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = simpleDateFormat.parse(startTime);
        long ts = date.getTime() / 1000;
        return ts;
    }

    /**
     * 自定义结束时间戳
     */
    public static long endTime(String startTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = simpleDateFormat.parse(startTime);
        long ts = date.getTime() / 1000;
        return ts;
    }

    /**
     * 根据数据类型处理时间返回页面
     * @param dateType 1.近一天、2.近一周、3.近一月、0.自定义、default.近一天
     * @param time  例： 2018/10/29 15:11:00 - 2018/10/29 23:59:00
     * @return startTime,endTime
     * @throws ParseException
     */
    public static Map<String,String> getTime(String dateType,String time) throws ParseException {
        Map<String,String> params = new HashMap<>(16);
        switch (dateType){
            case "1":
                params.put("startTime",String.valueOf(yesterDayTimestamp()));
                params.put("endTime",String.valueOf(currentTimestamp()));
                break;
            case "2":
                params.put("startTime",String.valueOf(weekDayTimestamp()));
                params.put("endTime",String.valueOf(currentTimestamp()));
                break;
            case "3":
                params.put("startTime",String.valueOf(monthDayTimestamp()));
                params.put("endTime",String.valueOf(currentTimestamp()));
                break;
            case "0":
                String[] startTimeAndEndTime = time.split("-");
                params.put("startTime",String.valueOf(startTime(startTimeAndEndTime[0])));
                params.put("endTime",String.valueOf(endTime(startTimeAndEndTime[1])));
                break;
            default:
                params.put("startTime",String.valueOf(yesterDayTimestamp()));
                params.put("endTime",String.valueOf(currentTimestamp()));
                break;
        }
        return params;
    }
    /**
     * string类型转时间戳
     */
    public static long toTimeStamp(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(time);
        long ts = date.getTime() / 1000;
        return ts;
    }

    public static long toTimeStampShot(String time) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(time);
        long ts = date.getTime() / 1000;
        return ts;
    }

    /**
     * 时间戳转时间
     * @param s
     * @return
     */
    public static String stampToDate(String s){
        long i = Long.parseLong(s);
        if (s.length() < 13) {
            i = (Long.parseLong(s) * 1000);
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(i);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     *
     * @param s
     * @return
     */
    public static String stampToDateFormat(String s){
        long i = Long.parseLong(s);
        if (s.length() < 13) {
            i = (Long.parseLong(s) * 1000);
        }
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        long lt = new Long(i);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}

