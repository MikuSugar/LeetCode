package JavaCode.contest.weekly.n0_200.n126;

import java.util.LinkedList;
import java.util.Queue;

public class N3
{
    public static void main(String[] args)
    {
        int[] a={1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int k=8;
        System.out.println(new N3().longestOnes(a,k));
    }

    public int longestOnes(int[] A, int K) {
        int start=0;
        int end=0;
        int res=0;
        int zero_cnt=0;
        Queue<Integer> zero_index=new LinkedList<>();
        while (end<A.length)
        {
            if(A[end]==1)
            {
                end++;
            }
            else if(A[end]==0)
            {
                if(K>0)
                {
                    if(zero_cnt<K)
                    {
                        zero_index.add(end);
                        end++;
                        zero_cnt++;
                    }
                    else
                    {
                        res=Math.max(res,end-start);
                        start=zero_index.poll()+1;
                        zero_cnt--;
                    }
                }
                else if(K==0)
                {
                    res=Math.max(res,end-start);
                    end++;
                    start=end;
                }
            }
        }
        res=Math.max(res,end-start);
        return res;
    }
}
/**
 * https://leetcode-cn.com/contest/weekly-contest-126/problems/max-consecutive-ones-iii/
 * 1004. 最大连续1的个数 III
 * 题目难度 Medium
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 */
