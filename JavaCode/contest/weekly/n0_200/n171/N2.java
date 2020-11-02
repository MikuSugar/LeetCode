package JavaCode.contest.weekly.n0_200.n171;

/**
 * author:fangjie
 * time:2020/1/12
 */
public class N2 {
    public int minFlips(int a, int b, int c) {
        char[] s1=Integer.toBinaryString(a).toCharArray();
        char[] s2=Integer.toBinaryString(b).toCharArray();
        char[] s3=Integer.toBinaryString(c).toCharArray();
        int res=0;
        int idx1=s1.length-1,idx2=s2.length-1,idx3=s3.length-1;
        while (idx1>=0||idx2>=0||idx3>=0)
        {
            int aa=0,bb=0,cc=0;
            if(idx1>=0)aa=s1[idx1]-'0';
            if(idx2>=0)bb=s2[idx2]-'0';
            if(idx3>=0)cc=s3[idx3]-'0';
            if((aa|bb)!=cc)
            {
                if(cc==0)
                {
                    if(aa!=0)res++;
                    if(bb!=0)res++;
                }
                else if(cc==1)res++;
            }
            idx1--;
            idx2--;
            idx3--;
        }
        return res;
    }
}
/*
给你三个正整数 a、b 和 c。

你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。

「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。



示例 1：



输入：a = 2, b = 6, c = 5
输出：3
解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
示例 2：

输入：a = 4, b = 2, c = 7
输出：1
示例 3：

输入：a = 1, b = 2, c = 3
输出：0


提示：

1 <= a <= 10^9
1 <= b <= 10^9
1 <= c <= 10^9

 */
