package JavaCode.contest.weekly.n0_200.n138;

public class N3 {

    public int[] prevPermOpt1(int[] A) {
        int index=-1;
        for (int i=A.length-1;i>0;i--)
        {
            if(A[i]<A[i-1])
            {
                index=i-1;
                break;
            }
        }
        if(index==-1)return A;
        int index1=index+1;
        for (int i=index+1;i<A.length;i++)
        {
            if(A[i]>=A[index1]&&A[i]<A[index])
            {
                index1=i;
            }
        }
        int t=A[index];
        A[index]=A[index1];
        A[index1]=t;
        return A;

    }
}
/**
 *1053. 前一个排列交换一次  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Medium
 * 给出一个正整数数组 A（元素不一定不同），返回可以在一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的按字典序排列小于 A 的最大排列。如果无法这样做，就返回原数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,2,1]
 * 输出：[3,1,2]
 * 解释：
 * 交换 2 和 1。
 * 示例 2：
 *
 * 输入：[1,1,5]
 * 输出：[1,1,5]
 * 解释：
 * 这已经是最小排列。
 * 示例 3：
 *
 * 输入：[1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：
 * 交换 9 和 7。
 * 示例 4：
 *
 * 输入：[3,1,1,3]
 * 输出：[1,1,3,3]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 1 <= A[i] <= 10000
 */
