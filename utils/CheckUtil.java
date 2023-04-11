package utils;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/30 16:52
 * @description CheckUtil
 */
public class CheckUtil {
    public static <T> void check(T v1, T v2) throws LeetCodeResultErrorException {
        if (v1 == null || v2 == null) {
            throw new LeetCodeResultErrorException("v1:" + v1 + " v2:" + v2 + "有指为空");
        }
        if (v1.equals(v2)) {
            System.out.println("pass: v1:" + v1 + " == v2:" + v2);
        } else {
            throw new LeetCodeResultErrorException("error: v1:" + v1 + " != v2:" + v2);
        }
    }

}
