package JavaCode.RandomRecords;

import java.util.Arrays;
import java.util.Comparator;

public class maximum_length_of_pair_chain {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            int ans=0;
            //排序
            Arrays.sort(pairs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            /**
             * 动态规划
             * dp[i]代表到第i个位置时的存在的最大数链对
             */

            int[] dp=new int[pairs.length];
            for(int i=0;i<pairs.length;i++)
            {
                dp[i]=1;
            }


            for(int i=0;i<pairs.length;i++)
            {
                for(int j=0;j<i;j++)
                {
                    if(pairs[i][0]>pairs[j][1])
                    {
                        dp[i]=Math.max(dp[i],dp[j]+1);
                        ans=Math.max(dp[i],ans);
                    }
                }
                //System.out.println(i+" "+dp[i]);
            }

            return ans;
        }
    }
}
/**
 * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 示例 :
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * 注意：
 * 给出数对的个数在 [1, 1000] 范围内。
 */
