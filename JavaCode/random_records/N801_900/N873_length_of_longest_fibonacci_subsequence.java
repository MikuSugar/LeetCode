package JavaCode.random_records.N801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * author:fangjie
 * time:2019/12/13
 */
public class N873_length_of_longest_fibonacci_subsequence {
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i=0;i<A.length;i++)
        {
            map.putIfAbsent(A[i],new ArrayList<>());
            map.get(A[i]).add(i);
        }
        Map<String,Integer> dp=new HashMap<>();
        int res=0;
        for (int i=0;i<A.length-1;i++)
        {
            for (int j=i+1;j<A.length;j++)
            {
                int s=slove(A[i]+A[j],j,A,map,dp);
                if(s==0)continue;
                res=Math.max(res,s+2);
            }
        }
        return res;
    }

    private int slove(int sum, int idx, int[] a, Map<Integer, List<Integer>> map, Map<String, Integer> dp) {
        if(!map.containsKey(sum))return 0;
        String key=sum+","+idx;
        if(dp.containsKey(key))return dp.get(key);
        List<Integer> list=map.get(sum);
        int next=search(list,idx);
        int res=0;
        if(next!=list.size())
        {
            res=Math.max(res,slove(sum+a[idx],list.get(next),a,map,dp)+1);
        }
        dp.put(key,res);
        return res;
    }

    private int search(List<Integer> list, int idx) {
        int left=0,right=list.size()-1;
        int res=list.size();
        while (left<=right)
        {
            int mid=(left+right)/2;
            int cur=list.get(mid);
            if(cur>idx)
            {
                res=mid;
                right=mid-1;
            }else if(cur==idx) return mid+1;
            else left=mid+1;
        }
        return res;
    }

}
/*
如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

n >= 3
对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

（回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）

 

示例 1：

输入: [1,2,3,4,5,6,7,8]
输出: 5
解释:
最长的斐波那契式子序列为：[1,2,3,5,8] 。
示例 2：

输入: [1,3,7,11,12,14,18]
输出: 3
解释:
最长的斐波那契式子序列有：
[1,11,12]，[3,11,14] 以及 [7,11,18] 。
 

提示：

3 <= A.length <= 1000
1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
（对于以 Java，C，C++，以及 C# 的提交，时间限制被减少了 50%）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
