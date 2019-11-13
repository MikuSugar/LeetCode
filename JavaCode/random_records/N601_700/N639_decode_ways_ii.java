package JavaCode.random_records.N601_700;
/**
 * author:fangjie
 * time:2019/11/13
 */
public class N639_decode_ways_ii {
    private final static int MOD=(int) (1e9+7);
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        char[] strs=s.toCharArray();
        long[] dp=new long[s.length()+1];
        dp[0]=1;
        dp[1]=strs[0]=='*'?9:1;

        for (int i=2;i<dp.length;i++)
        {
            char pre=strs[i-2];
            char cur=strs[i-1];
            //dp[i-1]
            if(cur=='*') dp[i]+=9*dp[i-1];
            else if(cur>'0')dp[i]+=dp[i-1];
            //dp[i-2]
            if(pre=='*')
            {
                if(cur=='*')dp[i]+=15*dp[i-2];
                else if(cur<='6')dp[i]+=2*dp[i-2];
                else dp[i]+=dp[i-2];
            }
            else if(pre=='1'||pre=='2')
            {
                if (cur=='*')
                {
                    if (pre=='1') dp[i]+=9*dp[i-2];
                    else dp[i]+=6*dp[i-2];
                }
                else if (((pre-'0')*10+(cur-'0'))<=26) dp[i]+=dp[i-2];
            }
            dp[i]%=MOD;
        }
        return (int) (dp[s.length()]%MOD);
    }

}
/*
一条包含字母 A-Z 的消息通过以下的方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
除了上述的条件以外，现在加密字符串可以包含字符 '*'了，字符'*'可以被当做1到9当中的任意一个数字。

给定一条包含数字和字符'*'的加密信息，请确定解码方法的总数。

同时，由于结果值可能会相当的大，所以你应当对109 + 7取模。（翻译者标注：此处取模主要是为了防止溢出）

示例 1 :

输入: "*"
输出: 9
解释: 加密的信息可以被解密为: "A", "B", "C", "D", "E", "F", "G", "H", "I".
示例 2 :

输入: "1*"
输出: 9 + 9 = 18（翻译者标注：这里1*可以分解为1,* 或者当做1*来处理，所以结果是9+9=18）
说明 :

输入的字符串长度范围是 [1, 105]。
输入的字符串只会包含字符 '*' 和 数字'0' - '9'。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
