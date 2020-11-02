package JavaCode.contest.biweekly.biweekly_n11;

/**
 * author:fangjie
 * time:2019/10/19
 */
public class N4 {
    public int maximizeSweetness(int[] sweetness, int K) {
        int left=1,right=Integer.MAX_VALUE>>1;
        while (left<right-1)
        {
            int mid=(left+right)/2;
            if(slove(sweetness,mid)>=K+1)left=mid;
            else right=mid;
        }
        return slove(sweetness,right)>=K+1?right:left;
    }

    private int slove(int[] sweetness, int mid) {
        int cnt=0;
        for (int i=0,j=0;i<sweetness.length;i=j)
        {
            j=i;
            int sum=0;
            while (j<sweetness.length&&sum<mid)
            {
                sum+=sweetness[j++];
            }
            cnt+=sum>=mid?1:0;
        }
        return cnt;
    }
}
/**
 *你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一块的甜度。
 *
 * 你打算和你的 K 名朋友一起分享这块巧克力，所以你需要将它切割 K 次得到 K+1 块，每一块都由一些 连续 的小块组成。
 *
 * 为了表现出你的慷慨，你将会吃到 总甜度最小 的一块，并把其他几块分给你的朋友。
 *
 * 请你找出在最好的切割策略下你所能分到的巧克力的 最大总甜度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sweetness = [1,2,3,4,5,6,7,8,9], K = 5
 * 输出：6
 * 解释：你可以把巧克力分成 [1,2,3], [4,5], [6], [7], [8], [9]
 * 示例 2：
 *
 * 输入：sweetness = [5,6,7,8,9,1,2,3,4], K = 8
 * 输出：1
 * 解释：只有一种办法可以把巧克力分成 9 块。
 * 示例 3：
 *
 * 输入：sweetness = [1,2,2,1,2,2,1,2,2], K = 2
 * 输出：5
 * 解释：你可以把巧克力分成 [1,2,2], [1,2,2], [1,2,2]
 *
 *
 * 提示：
 *
 * 0 <= K < sweetness.length <= 10^4
 * 1 <= sweetness[i] <= 10^5
 */
