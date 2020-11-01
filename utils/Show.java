package utils;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/10/27 6:12 下午
 */
public  class Show {
    public static <T> void show(T[] arr)
    {
        System.out.println("===================");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================");
    }
    public static <T> void show(T[][] arr)
    {
        System.out.println("===================");
        for (T[] a:arr)
        {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("===================");
    }
    public static void show(int[] arr)
    {
        System.out.println("===================");
        System.out.println(Arrays.toString(arr));
        System.out.println("===================");
    }
    public static void show(int[][] arr)
    {
        System.out.println("===================");
        for (int[] a:arr)
        {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("===================");
    }

}
