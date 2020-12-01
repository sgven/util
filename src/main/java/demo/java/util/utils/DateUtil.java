package demo.java.util.utils;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    /**
     * 通过正则表达式检查字符串是否符合日期格式yyyy-MM-dd
     * @param date
     * @return
     */
    public static boolean checkDateStrByRegEx(String date) {
        Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2}).*");
        Matcher matcher = pattern.matcher(date);
        if (matcher.matches()) {
            int y = Integer.valueOf(matcher.group(1));
            int m = Integer.valueOf(matcher.group(2));
            int d = Integer.valueOf(matcher.group(3));
            if (m > 12) {
                return false;
            }
            if (d > 28) {
                Calendar c = Calendar.getInstance();
                c.set(y, m-1, 1);
                //每个月的最大天数
                int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                return (lastDay >= d);
            }
            return true;
        }
        return false;
    }
}
