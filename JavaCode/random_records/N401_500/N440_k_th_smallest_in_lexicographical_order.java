package JavaCode.random_records.N401_500;

/**
 * author:fangjie
 * time:2019/11/6
 */
public class N440_k_th_smallest_in_lexicographical_order {
    public int findKthNumber(int n, int k) {
        return dfs(1,k-1,n);
    }

    private int dfs(int cur, int k, int n) {
        if(k==0)return cur;
        int cnt=getCount(cur,cur+1, n);
        if(cnt<=k)return dfs(cur+1,k-cnt,n);
        return dfs(cur*10,k-1,n);
    }

    private int getCount(long pre,long last,int n)
    {
        if(pre>n)return 0;
        return (int) (Math.min(n+1,last)-pre+getCount(pre*10,last*10,n));
    }
}
/*
给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。

注意：1 ≤ k ≤ n ≤ 109。

示例 :

输入:
n: 13   k: 2

输出:
10

解释:
字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
