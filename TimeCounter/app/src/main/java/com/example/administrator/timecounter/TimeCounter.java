package com.example.administrator.timecounter;

import android.util.Log;

/**
 * Create by MichaelCS on 2018/8/27 14:33
 * Email: junhong@turingpic.com
 */
public class TimeCounter {

    final String TAG = "MichaelCS";

    private StringBuffer timeCost;

    final int HOUR_MINUTES = 60;
    final int DAY_MINUTES = 60 * 24;
    final int MONTH_MINUTES = 60 * 24 * 30;
    final int YEAR_MINUTES = 60 * 24 * 365;

    int year = 0;
    int month = 0;
    int day = 0;
    int hour = 0;
    int minute = 0;
    int[] values = new int[]{
            year,
            month,
            day,
            hour,
            minute,
    };

    //每计算完一个时间阶段剩余的时间（分钟）
    int Remainder = 0;
    //更新基数
    int radix;
    //更新时间间隔
    int span;
    //更新总数
    int total;
    //总共更新次数
    int totalFrequency;
    //每天更新次数（日更新频率）
    int dayFrequency;
    //月更新次数（月更新平率）
    int monthFrequency;

    public TimeCounter(int radix, int span, int total) {
        this.radix = radix;
        this.span = span;
        this.total = total;
        timeCost = new StringBuffer();
    }
    public void countTimeCost() {


        if ((total % radix) != 0) {
            totalFrequency = total / radix + 1;
        } else {
            totalFrequency = total / radix;
        }

        //计算总需要的共时间（分钟）
        int totalMinutes = totalFrequency * span;
        //时间大于一年，计算year
        if (totalMinutes > YEAR_MINUTES) {
            year = totalMinutes / YEAR_MINUTES;
            Remainder = totalMinutes % YEAR_MINUTES;
        } else {
            Remainder = totalMinutes;
        }
        //时间大于一个月，计算month
        if (Remainder > MONTH_MINUTES) {
            month = Remainder / MONTH_MINUTES;
            Remainder = Remainder % MONTH_MINUTES;
        }

        //时间大于一天，计算day
        if (Remainder > DAY_MINUTES) {
            day = Remainder / DAY_MINUTES;
            Remainder = Remainder % DAY_MINUTES;
        }
        Log.i(TAG, "Remainder: " + Remainder);
        //时间大于一小时，计算hour
        if (Remainder > HOUR_MINUTES) {
            hour = Remainder / HOUR_MINUTES;
            Remainder = Remainder % HOUR_MINUTES;
        }
        //获取最后剩余的minute
        minute = Remainder;
    }

    public String showTimeCost() {

        String[] units = new String[]{
                "年 ",
                "个月 ",
                "天 ",
                "小时 ",
                "分钟"
        };
        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0) {
                timeCost.append(Integer.toString(values[i]));
                timeCost.append(units[i]);
            }
        }


//        // todo 判定非法输入
//        if (year!=0){
//            timeCost.append(Integer.toString(year));
//            timeCost.append("年 ");
//        }
//        if (month!=0){
//            timeCost.append(Integer.toString(month));
//            timeCost.append("个月 ");
//        }
//
//        if (day!= 0){
//            timeCost.append(Integer.toString(day));
//            timeCost.append("天 ");
//        }
//        if (hour!= 0){
//            timeCost.append(Integer.toString(hour));
//            timeCost.append("小时 ");
//        }
//        if (minute!= 0){
//            timeCost.append(Integer.toString(minute));
//            timeCost.append("分钟");
//        }
        return timeCost.toString();
    }
}
