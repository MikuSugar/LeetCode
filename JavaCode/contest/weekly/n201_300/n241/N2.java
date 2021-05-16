package JavaCode.contest.weekly.n201_300.n241;

public class N2 {
    public static void main(String[] args) {
        System.out.println(new N2().minSwaps("00011110110110000000000110110101011101111011111101010010010000000000000001101101010010001011110000001101111111110000110101101101001011000011111011101101100110011111110001100110001110000000001100010111110100111001001111100001000110101111010011001"));
    }
    public int minSwaps(String s) {
        final char[] strs = s.toCharArray();
        int cnt0,cnt1;
        cnt0=cnt1=0;
        for (char c:strs){
            if(c=='0')cnt0++;
            else cnt1++;
        }
        if(Math.abs(cnt0-cnt1)!=1&&cnt0!=cnt1)return -1;
        int res=0;
        if(cnt0>cnt1){
            for (int i=0;i<strs.length;i+=2){
                if(strs[i]=='1')res++;
            }
        }
        else if(cnt0==cnt1){
            int res1=0;
            int res2=0;
            for (int i=0;i<strs.length;i+=2){
                if(strs[i]=='0')res1++;
                else res2++;
            }
            res=Math.min(res1,res2);
        }
        else {
            for (int i=0;i<strs.length;i+=2){
                if(strs[i]=='0')res++;
            }
        }
        return res;

    }
}
/*
给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。

交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。

任意两个字符都可以进行交换，不必相邻 。



示例 1：

输入：s = "111000"
输出：1
解释：交换位置 1 和 4："111000" -> "101010" ，字符串变为交替字符串。
示例 2：

输入：s = "010"
输出：0
解释：字符串已经是交替字符串了，不需要交换。
示例 3：

输入：s = "1110"
输出：-1


提示：

1 <= s.length <= 1000
s[i] 的值为 '0' 或 '1'
 */
