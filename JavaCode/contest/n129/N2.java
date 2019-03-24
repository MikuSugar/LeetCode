package JavaCode.contest.n129;

public class N2 {

    public int smallestRepunitDivByK(int K) {

        int sum=0;
        for (int i=1;i<=10*K;i++){
            sum=(sum*10+1)%K;
            if (sum==0) return i;
        }
        return -1;
    }
}
/**
 *  1022. 可被 K 整除的最小整数  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Medium
 * 给定正整数 K，你需要找出可以被 K 整除的、仅包含每位上都是数字 1 的最小的正整数 N。
 *
 * 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：1
 * 输出：1
 * 解释：最小的答案是 N = 1，其长度为 1。
 * 示例 2：
 *
 * 输入：2
 * 输出：-1
 * 解释：There is no such positive integer N divisible by 2.
 * 示例 3：
 *
 * 输入：3
 * 输出：3
 * 解释：最小的答案是 N = 111，其长度为 3。
 */
