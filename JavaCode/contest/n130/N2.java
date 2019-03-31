package JavaCode.contest.n130;

public class N2 {
    public String baseNeg2(int N) {
        if(N==0) return "0";

        String res="";
        int k=1;
        while (N!=0)
        {
            if(N%2==1)
            {
                res+="1";
                N-=k;
            }
            else res+="0";
            N/=2;
            k*=-1;
        }
        return new StringBuilder(res).reverse().toString();
    }
}
/**
 * 1028. 负二进制转换  显示英文描述
 * 用户通过次数 5
 * 用户尝试次数 7
 * 通过次数 5
 * 提交次数 9
 * 题目难度 Medium
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 *
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 * 示例 2：
 *
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * 示例 3：
 *
 * 输入：4
 * 输出："100"
 * 解释：(-2) ^ 2 = 4
 *
 *
 * 提示：
 *
 * 0 <= N <= 10^9
 */
