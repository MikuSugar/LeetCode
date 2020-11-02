package JavaCode.contest.weekly.n0_200.n108;

import java.util.*;

public class N4 {

    public static void main(String[] args) {
//        for (int i=3;i<=20;i++)
        {
            System.out.println(Arrays.toString(new N4().beautifulArray(50)));
        }
    }


    public int[] beautifulArray(int N) {
        List<Integer> res=new ArrayList<>();
        res.add(1);
        while (res.size()<N)
        {
            List<Integer> temp=new ArrayList<>();
            for (int i:res)
            {
                if (i*2-1<=N)temp.add(i*2-1);
            }
            for (int i:res)
            {
                if(i*2<=N)temp.add(i*2);
            }
            res=temp;
        }
        int[] result=new int[N];
        for (int i=0;i<result.length;i++)
        {
            result[i]=res.get(i);
        }
        return result;
    }


}
/**
 * https://leetcode-cn.com/contest/weekly-contest-108/problems/beautiful-array/
 * 932. 漂亮数组  显示英文描述
 * 用户通过次数 2
 * 用户尝试次数 24
 * 通过次数 2
 * 提交次数 53
 * 题目难度 Medium
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 *
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 *
 * 那么数组 A 是漂亮数组。
 *
 *
 *
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：4
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：5
 * 输出：[3,1,2,5,4]
 *
 *
 * 提示：
 *
 * 1 <= N <= 1000
 */
