package utils;

import java.util.Arrays;
import java.util.Collection;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/10/27 6:12 下午
 */
public  class Show {

    public static  void showRow(){
        System.out.println("===================");
    }

    public static <T> void showT(Collection<T []> collection ) {
        showRow();
        collection.forEach(v->System.out.println(Arrays.toString(v)));
        showRow();
    }

    public static  void showInt(Collection<int[]> collection ) {
        showRow();
        collection.forEach(v->System.out.println(Arrays.toString(v)));
        showRow();
    }

    public static <T> void show(T[] arr) {
        showRow();
        System.out.println(Arrays.toString(arr));
        showRow();
    }

    public static <T> void show(T[][] arr) {
       showRow();
        for (T[] a:arr)
        {
            System.out.println(Arrays.toString(a));
        }
       showRow();
    }

    public static void show(int[] arr) {
        showRow();
        System.out.println(Arrays.toString(arr));
        showRow();
    }

    public static void show(int[][] arr) {
        showRow();
        for (int[] a:arr)
        {
            System.out.println(Arrays.toString(a));
        }
        showRow();
    }

}
