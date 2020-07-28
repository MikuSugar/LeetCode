package JavaCode.contest.n199;



/**
 * @Author: fangjie
 * @Date: 2020/7/26 10:13 上午
 */
public class N4 {

    public int getLengthOfOptimalCompression(String s, int k) {
        return slove(new int[s.length()][s.length()-k+1], 0, s.length()-k, s.toCharArray());
    }

    private final static int MAX=Integer.MAX_VALUE>>1;
    private int slove(int[][] dp, int idx, int count, char[] strs) {
        if(count==0)return 0;
        if(idx==strs.length)return MAX;
        if(dp[idx][count]!=0)return dp[idx][count];

        int res=MAX;
        boolean[] book=new boolean[26];
        for (int i=idx;i<strs.length;i++)
        {
            if(book[strs[i]-'a'])continue;
            if(idx>0&&strs[idx-1]==strs[i])continue;
            int lCount=0;
            book[strs[i]-'a']=true;
            for (int j=i;j<strs.length;j++)
            {
                if(strs[j]!=strs[i])continue;
                lCount++;
                if(lCount>count)break;
                int right=slove(dp,j+1,count-lCount,strs);
                if(right==MAX)continue;
                res=Math.min(res,getLen(lCount)+right);
            }
        }
        return dp[idx][count]=res;
    }

    private int getLen(int num) {
        if(num==1)return num;
        return 1+String.valueOf(num).length();
    }

}
/*
行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。

注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。

给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。

请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。



示例 1：

输入：s = "aaabcccd", k = 2
输出：4
解释：在不删除任何内容的情况下，压缩后的字符串是 "a3bc3d" ，长度为 6 。最优的方案是删除 'b' 和 'd'，这样一来，压缩后的字符串为 "a3c3" ，长度是 4 。
示例 2：

输入：s = "aabbaa", k = 2
输出：2
解释：如果删去两个 'b' 字符，那么压缩后的字符串是长度为 2 的 "a4" 。
示例 3：

输入：s = "aaaaaaaaaaa", k = 0
输出：3
解释：由于 k 等于 0 ，不能删去任何字符。压缩后的字符串是 "a11" ，长度为 3 。


提示：

1 <= s.length <= 100
0 <= k <= s.length
s 仅包含小写英文字母
 */
