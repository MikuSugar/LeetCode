package JavaCode.random_records;

public class N845_longestMountain {

    public int longestMountain(int[] A) {
        if(A.length<3) return 0;

        int left=0;
        int right=1;
        boolean isUp=true;//当前方向
        int up_cnt=0;//上升的高度（用于判断是否存在⛰️顶
        int res=0;
        while (right<A.length)
        {
            if(A[right]>A[right-1])
            {
                if(isUp)
                {
                    up_cnt++;
                    right++;
                }
                else
                {
                    if(up_cnt>0) res=Math.max(right-left,res);
                    left=right-1;
                    isUp=true;
                    up_cnt=0;
                }
            }
            else if(A[right]==A[right-1])
            {
                if(isUp)
                {
                    left=right;
                    right++;
                    up_cnt=0;
                }
                else
                {
                    if(up_cnt>0) res=Math.max(right-left,res);
                    left=right;
                    right++;
                    isUp=true;
                    up_cnt=0;
                }
            }
            else
            {
                isUp=false;
                right++;
            }
        }
        if (up_cnt>0&&!isUp) res=Math.max(res,right-left);
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
