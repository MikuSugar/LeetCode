package JavaCode.random_records.N1_100;

public class N60_permutation_sequence {

    private String res;
    private int cnt;
    public String getPermutation(int n, int k) {
        cnt=0;
        dfs(n,new boolean[n+1],k,new StringBuilder());
        return res;
    }

    private void dfs(int n, boolean[] book, int k,StringBuilder sb) {
        if(cnt>k)return;
        if(sb.length()==n)
        {
            cnt++;

            if(cnt==k)
            {
                this.res=sb.toString();
            }
            return;
        }
        for (int i=1;i<=n;i++)
        {
            if(book[i])continue;
            book[i]=true;
            sb.append(i);
            dfs(n,book,k,sb);
            sb.deleteCharAt(sb.length()-1);
            book[i]=false;
        }
    }
}
/**
 * https://leetcode-cn.com/problems/permutation-sequence/
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 在真实的面试中遇到过这道题？
 *
 * 是
 *
 * 否
 */
