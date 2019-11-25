package demo.java.util.utils;

import demo.java.util.enums.TimeUnitEnum;
import java.math.BigDecimal;

/**
 * 天、时、分、秒、毫秒、微秒、纳秒等时间单位转换工具类
 */
public class TimeUtil {

    // 默认舍入模式：
    // BigDecimal.ROUND_DOWN    截取
    // BigDecimal.ROUND_HALF_UP 四舍五入
    private static int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_DOWN;

    // 纳秒
    public static final int NANOSECOND = 0;
    // 微秒
    public static final int MICROSECOND = 1;
    // 毫秒
    public static final int MILLISECOND = 2;
    // 秒
    public static final int SECOND = 3;
    // 分钟
    public static final int MINUTE = 4;
    // 小时
    public static final int HOUR = 5;
    // 天
    public static final int DAY = 6;

    /**
     * 转为纳秒
     * @param duration  持续时间
     * @param from  表示原本的时间单位
     * @return
     */
    public static double toNanos(long duration, int from) {
        return toTime(duration, from, MICROSECOND, 0);
    }

    /**
     * 转为微秒
     * @param duration  持续时间
     * @param from  表示原本的时间单位
     * @param scale 精度，保留的小数位
     * @return
     */
    public static double toMicros(long duration, int from, int scale) {
        return toTime(duration, from, MICROSECOND, scale);
    }

    /**
     * 转为毫秒
     * @param duration  持续时间
     * @param from  表示原本的时间单位
     * @param scale 精度，保留的小数位
     * @return
     */
    public static double toMillis(long duration, int from, int scale)  {
        return toTime(duration, from, MILLISECOND, scale);
    }

    /**
     * 转为秒
     * @param duration  持续时间
     * @param from  表示原本的时间单位
     * @param scale  精度，保留的小数位
     * @return
     */
    public static double toSeconds(long duration, int from, int scale) {
        return toTime(duration, from, SECOND, scale);
    }

    /**
     * 转为分钟
     * @param duration  持续时间
     * @param from  表示原本的时间单位
     * @param scale  精度，保留的小数位
     * @return
     */
    public static double toMinutes(long duration, int from, int scale) {
        return toTime(duration, from, MINUTE, scale);
    }

    /**
     * 转为小时
     * @param duration  持续时间
     * @param from  表示原本的时间单位
     * @param scale  精度，保留的小数位
     * @return
     */
    public static double toHours(long duration, int from, int scale) {
        return toTime(duration, from, HOUR, scale);
    }

    /**
     * 转为天
     * @param duration  持续时间
     * @param from  表示原本的时间单位
     * @param scale  精度，保留的小数位
     * @return
     */
    public static double toDays(long duration, int from, int scale) {
        return toTime(duration, from, DAY, scale);
    }

    private static double toTime(long duration, int from, int to, int scale) {
        return toTime(duration, from, to, scale, DEFAULT_ROUNDING_MODE);
    }

    private static double toTime(long duration, int from, int to, int scale, int roundingMode) {
        double time = toTime(duration, from, to);
        // BigDecimal构造函数参数 +""，解决精度丢失问题
        BigDecimal back = new BigDecimal("" + time).setScale(scale, roundingMode);
        return back.doubleValue();
    }

    private static double toTime(long duration, int from, int to) {
        TimeUnitEnum item = TimeUnitEnum.getItem(from);
        switch (to) {
            case NANOSECOND:
                return item.toNanos(duration);
            case MICROSECOND:
                return item.toMicros(duration);
            case MILLISECOND:
                return item.toMillis(duration);
            case SECOND:
                return item.toSeconds(duration);
            case MINUTE:
                return item.toMinutes(duration);
            case HOUR:
                return item.toHours(duration);
            case DAY:
                return item.toDays(duration);
        }
        return duration;
    }

}
