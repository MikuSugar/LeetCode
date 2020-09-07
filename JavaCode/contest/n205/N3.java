package JavaCode.contest.n205;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/6 10:25 上午
 */
public class N3 {
    public int minCost(String s, int[] cost) {
        char[] strs=s.toCharArray();
        int res=0;
        int start=0;
        for (int i=1; i<strs.length; i++) {
            if (strs[i]!=strs[i-1]) {
                if (start!=i-1) {
                    res+=getMin(start, i, cost);
                }
                start=i;
            }
        }
        if (start!=strs.length-1) {
            res+=getMin(start, strs.length, cost);
        }
        return res;
    }

    private int getMin(int start, int end, int[] cost) {
        int[] arr=new int[end-start];
        int idx=0;
        for (int i=start; i<end; i++) {
            arr[idx++]=cost[i];
        }
        Arrays.sort(arr);
        int res=0;
        for (int i=0; i<arr.length-1; i++) res+=arr[i];
        return res;
    }
}
/*
给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。

返回使字符串任意相邻两个字母不相同的最小删除成本。

请注意，删除一个字符后，删除其他字符的成本不会改变。



示例 1：

输入：s = "abaac", cost = [1,2,3,4,5]
输出：3
解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
示例 2：

输入：s = "abc", cost = [1,2,3]
输出：0
解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
示例 3：

输入：s = "aabaa", cost = [1,2,3,4,1]
输出：2
解释：删除第一个和最后一个字母，得到字符串 ("aba") 。


提示：

s.length == cost.length
1 <= s.length, cost.length <= 10^5
1 <= cost[i] <= 10^4
s 中只含有小写英文字母

 */
