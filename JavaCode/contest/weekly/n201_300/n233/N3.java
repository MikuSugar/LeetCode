package JavaCode.contest.weekly.n201_300.n233;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/21 10:21 上午
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().maxValue(6, 1, 10));
    }

    public int maxValue(int n, int index, int maxSum) {
        int res=1;
        int left=res, right=maxSum;
        while (left<=right) {
            int mid=(left+right)/2;
            if (check(mid, n, index, maxSum)) {
                res=mid;
                left=mid+1;
            } else right=mid-1;
        }
        return res;
    }

    private boolean check(int max, int n, int index, int maxSum) {
        int sum=0;
        int l=max,lIdx=index;
        while (l>1&&lIdx>=0)
        {
            sum+=l;
            if(sum>maxSum)return false;
            l--;
            lIdx--;
        }
        if(lIdx>=0)sum+=lIdx+1;
        if(sum>maxSum)return false;
        sum-=max;
        int r=max,rIdx=index;
        while (r>1&&rIdx<n){
            sum+=r;
            if(sum>maxSum)return false;
            r--;
            rIdx++;
        }
        if(rIdx!=n)sum+=(n-rIdx);
        // System.out.println(sum);
        return sum<=maxSum;
    }
}
/*
给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：

nums.length == n
nums[i] 是 正整数 ，其中 0 <= i < n
abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
nums 中所有元素之和不超过 maxSum
nums[index] 的值被 最大化
返回你所构造的数组中的 nums[index] 。

注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。



示例 1：

输入：n = 4, index = 2,  maxSum = 6
输出：2
解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
示例 2：

输入：n = 6, index = 1,  maxSum = 10
输出：3


提示：

1 <= n <= maxSum <= 109
0 <= index < n
 */
