package JavaCode.random_records.N1301_1400;

/**
 * author:fangjie
 * time:2020/3/30
 */
public class N1395_count_number_of_teams {
    public int numTeams(int[] rating) {
        int res=0;
        for (int i=0;i<rating.length;i++)
        {
            res+=minCnt(0,i-1,rating[i],rating)*maxCnt(i+1,rating.length-1,rating[i],rating);
            res+=maxCnt(0,i-1,rating[i],rating)*minCnt(i+1,rating.length-1,rating[i],rating);
        }
        return res;
    }

    private int maxCnt(int left, int right, int tar, int[] arr) {
        int res=0;
        for (int i=left;i<=right;i++)
        {
            if(arr[i]>tar)res++;
        }
        return res;
    }

    private int minCnt(int left, int right, int tar, int[] arr) {
        int res=0;
        for (int i=left;i<=right;i++)
        {
            if(arr[i]<tar)res++;
        }
        return res;
    }

}
/*
 n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。

每 3 个士兵可以组成一个作战单位，分组规则如下：

从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。

 

示例 1：

输入：rating = [2,5,3,4,1]
输出：3
解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
示例 2：

输入：rating = [2,1,3]
输出：0
解释：根据题目条件，我们无法组建作战单位。
示例 3：

输入：rating = [1,2,3,4]
输出：4
 

提示：

n == rating.length
1 <= n <= 200
1 <= rating[i] <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-number-of-teams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
