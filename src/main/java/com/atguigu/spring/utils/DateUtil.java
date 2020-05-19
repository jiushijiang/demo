package com.atguigu.spring.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {

    public static String formatDateByPattern(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
    /***
     * convert Date to cron ,eg.  "0 06 10 15 1 ? 2014"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date  date){
        String dateFormat="ss mm HH dd MM ?";
        return formatDateByPattern(date, dateFormat);
    }

    public static String convertToString(LocalDateTime localDateTime , String dateFormat) throws Exception {

        try {
            if (localDateTime == null){

                return null;
            }
            DateTimeFormatter sdf = DateTimeFormatter.ofPattern(dateFormat);
            String date = localDateTime.format(sdf);
            return date;
        }catch (Exception e){

            throw new Exception("Time conversion error:"+e.getMessage());

        }

    }

    public static String formatLocalDateDateByPattern(LocalDateTime localDateTime, String dateFormat) throws Exception {

        try {
            if (localDateTime == null){

                return null;
            }
            DateTimeFormatter sdf = DateTimeFormatter.ofPattern(dateFormat);
            String date = localDateTime.format(sdf);
            return date;
        }catch (Exception e){

            throw new Exception("Time conversion error:"+e.getMessage());

        }

    }

    public static String getCron(LocalDateTime  date)  {

        String dateFormat="ss mm HH dd MM ?";
        String dateTimeStr;
        try {
            dateTimeStr=formatLocalDateDateByPattern(date, dateFormat);

        }catch (Exception e){

            e.printStackTrace();
            return  null;

        }
        return dateTimeStr;
    }


    public static String getCronStr(LocalDateTime  date)  {

        String dateFormat="ss mm HH dd MM ?";
        String dateTimeStr;
        try {
            dateTimeStr=formatLocalDateDateByPattern(date, dateFormat);

        }catch (Exception e){

            e.printStackTrace();
            return  null;

        }
        return dateTimeStr;
    }
}
