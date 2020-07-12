package demo.java.util.utils;

import java.math.BigDecimal;

public class MathUtil {

    /**
     * 默认舍入模式：
     * BigDecimal.ROUND_DOWN    截取
     * BigDecimal.ROUND_HALF_UP 四舍五入
     */
//    private static final int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_DOWN;
    private static final int DEFAULT_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;

    public static String format(Double value, int scale) {
        BigDecimal format = new BigDecimal(""+value).setScale(scale, DEFAULT_ROUNDING_MODE);
        return format.toString();
    }

    public static String format(Double value, int scale, int roundingMode) {
        BigDecimal format = new BigDecimal(""+value).setScale(scale, roundingMode);
        return format.toString();
    }

    /**
     * 精确加法运算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        if (v1 == null) {
            v1 = BigDecimal.ZERO;
        }
        if (v2 == null) {
            v2 = BigDecimal.ZERO;
        }
        return v1.add(v2);
    }

    /**
     * 精确减法运算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal subtract(BigDecimal v1, BigDecimal v2) {
        if (v1 == null) {
            v1 = BigDecimal.ZERO;
        }
        if (v2 == null) {
            v2 = BigDecimal.ZERO;
        }
        return v1.subtract(v2);
    }

    /**
     * 精确乘法运算
     *
     * @param v1
     * @param v2
     * @return
     */
    public static BigDecimal multiply(BigDecimal v1, BigDecimal v2) {
        if (v1 == null) {
            v1 = BigDecimal.ONE;
        }
        if (v2 == null) {
            v2 = BigDecimal.ONE;
        }
        return v1.multiply(v2);
    }

    /**
     * 精确除法运算
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度
     * @return
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale) {
        return doDivide(v1, v2, scale, DEFAULT_ROUNDING_MODE);
    }

    /**
     * 精确除法运算
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度
     * @param roundingMode  舍入模式
     * @return
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale, int roundingMode) {
        return doDivide(v1, v2, scale, roundingMode);
    }

    /**
     * 精确除法运算
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 精确度
     * @param roundingMode  舍入模式
     * @return
     */
    private static BigDecimal doDivide(BigDecimal v1, BigDecimal v2, int scale, int roundingMode) {
        if (v1 == null) {
            return BigDecimal.ZERO;
        }
        if (v2 == null) {
            v2 = BigDecimal.ONE;
        }
        if (v2.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        if (scale < 0) {
            throw new IllegalArgumentException("精确度不能小于0");
        }

        return v1.divide(v2, scale, roundingMode);
    }

}
