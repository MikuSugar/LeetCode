package JavaCode.random_records.N501_600;

import java.util.*;

public class N506_relative_ranks {
    public String[] findRelativeRanks(int[] nums) {
        int[][] a=new int[nums.length][2];
        for (int i=0;i<nums.length;i++)
        {
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        for (int i=0;i<a.length;i++)
        {
            a[i][0]=i;
        }
        String[] res=new String[nums.length];
        for (int i=0;i<a.length;i++)
        {
            int t=a[i][0];
            if(t<3)
            {
                res[a[i][1]]=help[t];
            }
            else
            {
                res[a[i][1]]=Integer.toString(t+1);
            }
        }
        return res;
    }
    private static String[] help={"Gold Medal", "Silver Medal", "Bronze Medal"};
}
/**
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 *
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 */
