package JavaCode.contest.biweekly.biweekly_n15;

/**
 * author:fangjie
 * time:2019/12/14
 */
public class N1 {
    public int findSpecialInteger(int[] arr) {
        if(arr.length==1)return arr[0];
        int cnt=1;
        for (int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])cnt++;
            else cnt=1;
            if(cnt*4>arr.length)return arr[i];
        }
        return -1;
    }
}
/*
给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。

请你找到并返回这个整数



示例：

输入：arr = [1,2,2,6,6,6,6,7,10]
输出：6


提示：

1 <= arr.length <= 10^4
0 <= arr[i] <= 10^5
 */
