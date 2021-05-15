package Stream.Date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

public class Date02 {
    //localDate
    //localTime
    //localDateTime
//    使用方式一样
    public static void test01(){
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        LocalDateTime of = LocalDateTime.of(2021, 5, 2, 13, 12, 10);
        System.out.println(of);
        //添加年
        System.out.println(dateTime.plusYears(2));
        //减少月份
        System.out.println(dateTime.minusMonths(2));
    }
    //时间矫正器
    public static void test02(){
        //TemporalAdjusters：时间校正器
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);
        //指定日期时间中的 年 月 日 ...
        //指定本月十号
        LocalDateTime ldt2 = ldt1.withDayOfMonth(10);
        //System.out.println(ldt2);
        //指定下一个时间点(下一个星期天)
        LocalDateTime with = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        //System.out.println(with);
        //自定义（下一个时间点）
        LocalDateTime with1 = ldt1.with(l -> {
            LocalDateTime ldt3 = (LocalDateTime) l;
            DayOfWeek dow = ldt3.getDayOfWeek();
            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt3.plusDays(3);
            } else if (dow.equals(DayOfWeek.SUNDAY)) {
                return ldt3.plusDays(1);
            } else {
                return ldt3.plusDays(1);
            }
        });
        System.out.println(with1);
    }
    //时间格式化
    public static void test03(){
        //默认格式化
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt1 = LocalDateTime.now();
        String str1 = ldt1.format(dtf1);
        System.out.println(str1);
        //自定义格式化 ofPattern
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt2 = LocalDateTime.now();
        String str2 = ldt2.format(dtf2);
        System.out.println(str2);
        //解析
        LocalDateTime newDate = ldt1.parse(str1, dtf1);
        System.out.println(newDate);
    }
    //时区
    public static void test04(){
        //查看支持的时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);

        //指定时区
        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        System.out.println(ldt1);

        //在已构建好的日期时间上指定时区
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Tallinn"));
        ZonedDateTime zdt1 = ldt2.atZone(ZoneId.of("Europe/Tallinn"));
        System.out.println(zdt1);
    }
    //时间转换
    public static void test05(){
        // Date 转 LocalDateTime
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        // LocalDateTime 转 Date
        LocalDateTime local = LocalDateTime.now();
        ZoneId zi = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date ds = Date.from(zdt.toInstant());
    }

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }
}
