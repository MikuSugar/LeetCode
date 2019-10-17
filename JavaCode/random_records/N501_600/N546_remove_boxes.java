package JavaCode.random_records.N501_600;

/**
 * author:fangjie
 * time:2019/10/17
 */
public class N546_remove_boxes {
    public int removeBoxes(int[] boxes) {
        int[][][] dp=new int[boxes.length][boxes.length][boxes.length];
        return slove(0,0,boxes.length-1,boxes,dp);
    }

    private int slove(int k, int left, int right, int[] boxes, int[][][] dp) {
        if(left>right)return 0;
        if(dp[k][left][right]!=0)return dp[k][left][right];
        while (right>left&&boxes[right]==boxes[right-1])
        {
            right--;
            k++;
        }
        int res=slove(0,left,right-1,boxes,dp)+(k+1)*(k+1);
        for (int i=left;i<right;i++)
        {
            if(boxes[i]==boxes[right])
            {
                res=Math.max(res,slove(k+1,left,i,boxes,dp)+slove(0,i+1,right-1,boxes,dp));
            }
        }
        return dp[k][left][right]=res;
    }
}
/**
 * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 *
 * 示例 1：
 * 输入:
 *
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * 输出:
 *
 * 23
 * 解释:
 *
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
 * ----> [1, 3, 3, 3, 1] (1*1=1 分)
 * ----> [1, 1] (3*3=9 分)
 * ----> [] (2*2=4 分)
 *  
 *
 * 提示：盒子的总数 n 不会超过 100。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-boxes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
