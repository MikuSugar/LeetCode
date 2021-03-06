package JavaCode.contest.weekly.n0_200.n159;

/**
 * author:fangjie
 * time:2019/10/20
 */
public class N3 {
    public int balancedString(String s) {
        int[][] sum=new int[4][s.length()+1];
        char[] strs=s.toCharArray();
        for (int i=0;i<strs.length;i++)
        {
            for (int k=0;k<sum.length;k++) sum[k][i+1]=sum[k][i];
            sum[getIdx(strs[i])][i+1]++;
        }

        int tar=0;
        for (int i=0;i<sum.length;i++) tar+=sum[i][s.length()];
        tar/=4;

        int[] find=new int[4];
        for (int i=0;i<sum.length;i++) find[i]=sum[i][s.length()]-tar;
        if(find[0]==find[1]&&find[1]==find[2]&&find[3]==find[2])return 0;

        int left=0,right=0,res=Integer.MAX_VALUE;
        while (right<s.length())
        {
            if(check(left,right,sum,find))
            {
                res=Math.min(res,right-left+1);
                if(right>left)left++;
                else right++;
            }
            else right++;
        }
        return res;
    }

    private boolean check(int left, int right, int[][] sum, int[] find) {
        for (int i=0;i<sum.length;i++)
        {
            if(sum[i][right+1]-sum[i][left]<find[i])return false;
        }
        return true;
    }

    private int getIdx(char c) {
        if(c=='Q')return 0;
        if(c=='W')return 1;
        if(c=='E')return 2;
        return 3;
    }
}
/**
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 *
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 *
 *
 *
 * 给你一个这样的字符串 s，请通过「替换子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 *
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 *
 * 请返回待替换子串的最小可能长度。
 *
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 *
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 *
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 *
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 */
