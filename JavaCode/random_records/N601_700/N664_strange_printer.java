package JavaCode.random_records.N601_700;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/10/17
 */
public class N664_strange_printer {
    public int strangePrinter(String s) {
        if(s==null||s.isEmpty())return 0;
        char[] strs=getChars(s);
        int[][] dp=new int[strs.length+1][strs.length+1];
        for (int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return slove(strs,0,strs.length-1,dp);
    }

    private int slove(char[] strs, int left, int right, int[][] dp) {
        if(left>right)return 0;
        if(dp[left][right]!=-1)return dp[left][right];
        int res=1+slove(strs,left,right-1,dp);
        for (int i=left;i<right;i++)
        {
            if(strs[i]==strs[right])
            {
                res=Math.min(res,slove(strs,left,i,dp)+slove(strs,i+1,right-1,dp));
            }
        }
        return dp[left][right]=res;
    }

    private char[] getChars(String s) {
        StringBuilder sb=new StringBuilder();
        char[] chars=s.toCharArray();
        sb.append(chars[0]);
        for (int i=1;i<chars.length;i++)
        {
            if(chars[i]==chars[i-1])continue;
            else sb.append(chars[i]);
        }
        return sb.toString().toCharArray();
    }
}
/**
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印同一个字符序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
 *
 * 示例 1:
 *
 * 输入: "aaabbb"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2:
 *
 * 输入: "aba"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 * 提示: 输入字符串的长度不会超过 100。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
