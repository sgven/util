package demo.java.util.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TimeUnitEnum {

    // 纳秒
    NANOSECONDS(0) {
        public double toNanos(long d)   { return d; }
        public double toMicros(long d)  { return d/(C1/C0); }
        public double toMillis(long d)  { return d/(C2/C0); }
        public double toSeconds(long d) { return d/(C3/C0); }
        public double toMinutes(long d) { return d/(C4/C0); }
        public double toHours(long d)   { return d/(C5/C0); }
        public double toDays(long d)    { return d/(C6/C0); }
    },

    // 微秒
    MICROSECONDS(1) {
        public double toNanos(long d)   { return x(d, C1/C0, MAX/(C1/C0)); }
        public double toMicros(long d)  { return d; }
        public double toMillis(long d)  { return d/(C2/C1); }
        public double toSeconds(long d) { return d/(C3/C1); }
        public double toMinutes(long d) { return d/(C4/C1); }
        public double toHours(long d)   { return d/(C5/C1); }
        public double toDays(long d)    { return d/(C6/C1); }
    },

    // 毫秒
    MILLISECONDS(2) {
        public double toNanos(long d) { return x(d, C2/C0, MAX/(C2/C0)); }
        public double toMicros(long d) { return x(d, C2/C1, MAX/(C2/C1)); }
        public double toMillis(long d) { return d; }
        public double toSeconds(long d) { return d/(C3/C2); }
        public double toMinutes(long d) { return d/(C4/C2); }
        public double toHours(long d) { return d/(C5/C2); }
        public double toDays(long d) { return d/(C6/C2); }
    },

    // 秒
    SECONDS(3) {
        public double toNanos(long d)   { return x(d, C3/C0, MAX/(C3/C0)); }
        public double toMicros(long d)  { return x(d, C3/C1, MAX/(C3/C1)); }
        public double toMillis(long d)  { return x(d, C3/C2, MAX/(C3/C2)); }
        public double toSeconds(long d) { return d; }
        public double toMinutes(long d) { return d/(C4/C3); }
        public double toHours(long d)   { return d/(C5/C3); }
        public double toDays(long d)    { return d/(C6/C3); }
    },

    // 分钟
    MINUTES(4) {
        public double toNanos(long d)   { return x(d, C4/C0, MAX/(C4/C0)); }
        public double toMicros(long d)  { return x(d, C4/C1, MAX/(C4/C1)); }
        public double toMillis(long d)  { return x(d, C4/C2, MAX/(C4/C2)); }
        public double toSeconds(long d) { return x(d, C4/C3, MAX/(C4/C3)); }
        public double toMinutes(long d) { return d; }
        public double toHours(long d)   { return d/(C5/C4); }
        public double toDays(long d)    { return d/(C6/C4); }
    },

    // 小时
    HOURS(5) {
        public double toNanos(long d)   { return x(d, C5/C0, MAX/(C5/C0)); }
        public double toMicros(long d)  { return x(d, C5/C1, MAX/(C5/C1)); }
        public double toMillis(long d)  { return x(d, C5/C2, MAX/(C5/C2)); }
        public double toSeconds(long d) { return x(d, C5/C3, MAX/(C5/C3)); }
        public double toMinutes(long d) { return x(d, C5/C4, MAX/(C5/C4)); }
        public double toHours(long d)   { return d; }
        public double toDays(long d)    { return d/(C6/C5); }
    },

    // 天
    DAYS(6) {
        public double toNanos(long d)   { return x(d, C6/C0, MAX/(C6/C0)); }
        public double toMicros(long d)  { return x(d, C6/C1, MAX/(C6/C1)); }
        public double toMillis(long d)  { return x(d, C6/C2, MAX/(C6/C2)); }
        public double toSeconds(long d) { return x(d, C6/C3, MAX/(C6/C3)); }
        public double toMinutes(long d) { return x(d, C6/C4, MAX/(C6/C4)); }
        public double toHours(long d)   { return x(d, C6/C5, MAX/(C6/C5)); }
        public double toDays(long d)    { return d; }
    };

    static final double C0 = 1;
    static final double C1 = C0 * 1000;
    static final double C2 = C1 * 1000;
    static final double C3 = C2 * 1000;
    static final double C4 = C3 * 60;
    static final double C5 = C4 * 60;
    static final double C6 = C5 * 24;

    static final double MAX = Double.MAX_VALUE;

    static double x(long d, double m, double over) {
        if (d >  over) return Double.MAX_VALUE;
        if (d < -over) return Double.MIN_VALUE;
        return d * m;
    }

    public double toNanos(long d)   { throw new AbstractMethodError(); }
    public double toMicros(long d)  { throw new AbstractMethodError(); }
    public double toMillis(long d)  { throw new AbstractMethodError(); }
    public double toSeconds(long d) { throw new AbstractMethodError(); }
    public double toMinutes(long d) { throw new AbstractMethodError(); }
    public double toHours(long d)   { throw new AbstractMethodError(); }
    public double toDays(long d)    { throw new AbstractMethodError(); }

    private int unit;

    TimeUnitEnum(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    private static final Map<Integer, TimeUnitEnum> lookup = new HashMap<Integer, TimeUnitEnum>();
    static {
        for (TimeUnitEnum item : EnumSet.allOf(TimeUnitEnum.class)) {
            lookup.put(item.getUnit(), item);
        }
    }

    public static TimeUnitEnum getItem(Integer v) {
        return lookup.get(v);
    }
}
