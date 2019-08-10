package JavaCode.random_records.N601_700;

import java.util.Arrays;

public class N670_maximum_swap {
    public int maximumSwap(int num) {
        char[] s =Integer.toString(num).toCharArray();
        char[] s2=Integer.toString(num).toCharArray();
        Arrays.sort(s);
        int idx=0;
        while (idx<s.length&&s[s.length-1-idx]==s2[idx])
        {
            idx++;
        }
        for (int i=s.length-1;i>idx;i--)
        {
            if(s2[i]==s[s.length-1-idx])
            {
                swap(idx,i,s2);
                break;
            }
        }
        return Integer.parseInt(new String(s2));
    }

    private void swap(int j, int i, char[] s) {
        s[j]^=s[i];
        s[i]^=s[j];
        s[j]^=s[i];
    }
}
/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
