package JavaCode.random_records.N1401_1500;

import java.util.*;

/**
 * author:fangjie
 * time:2020/4/26
 */
public class N1414_find_the_minimum_number_of_fibonacci_numbers_whose_sum_is_k {
    private final static List<Integer> FP;
    static {
        TreeSet<Integer> set=new TreeSet<>();
        int a=1,b=1;
        set.add(1);
        while (b<1e9){
            int temp=b;
            b+=a;
            a=temp;
            set.add(b);
        }
        FP=new ArrayList<>(set);
    }
    public int findMinFibonacciNumbers(int k) {
        int idx=FP.size()-1;
        int res=0;
        while (k>0)
        {
            if(FP.get(idx)>k)idx--;
            else
            {
                k-=FP.get(idx);
                res++;
            }
        }
        return res;
    }
}
/*
给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。

斐波那契数字定义为：

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
数据保证对于给定的 k ，一定能找到可行解。

 

示例 1：

输入：k = 7
输出：2
解释：斐波那契数字为：1，1，2，3，5，8，13，……
对于 k = 7 ，我们可以得到 2 + 5 = 7 。
示例 2：

输入：k = 10
输出：2
解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
示例 3：

输入：k = 19
输出：3
解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 

提示：

1 <= k <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
