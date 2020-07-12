package JavaCode.contest.n197;


/**
 * @Author: fangjie
 * @Date: 2020/7/13 1:04 上午
 */
public class N2_number_of_substrings_with_only_1s {
    public static void main(String[] args) {
        System.out.println(new N2_number_of_substrings_with_only_1s().numSub("0110111"));
    }
    public int numSub(String s) {
        char[] strs=s.toCharArray();
        int pre=0;
        long res=0L;

        for (int i=0;i<strs.length;i++)
        {
            if(strs[i]!='1')
            {
                res+=slove(i-pre);
                pre=i+1;
                res%=MOD;
            }
        }
        res+=slove(s.length()-pre);
        return (int) (res%MOD);
    }

    private long slove(int n) {
        if (n==0) return 0;
        return (n+1)*n/2%MOD;
    }

    private final static int MOD=(int) (1e9+7);
}
/*
给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。

返回所有字符都为 1 的子字符串的数目。

由于答案可能很大，请你将它对 10^9 + 7 取模后返回。

 

示例 1：

输入：s = "0110111"
输出：9
解释：共有 9 个子字符串仅由 '1' 组成
"1" -> 5 次
"11" -> 3 次
"111" -> 1 次
示例 2：

输入：s = "101"
输出：2
解释：子字符串 "1" 在 s 中共出现 2 次
示例 3：

输入：s = "111111"
输出：21
解释：每个子字符串都仅由 '1' 组成
示例 4：

输入：s = "000"
输出：0
 

提示：

s[i] == '0' 或 s[i] == '1'
1 <= s.length <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-substrings-with-only-1s
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
