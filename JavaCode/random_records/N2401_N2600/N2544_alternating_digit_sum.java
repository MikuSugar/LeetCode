package JavaCode.random_records.N2401_N2600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikusugar
 * @version 1.0, 2023/4/11 16:44
 * @description N2544_alternating_digit_sum
 */
public class N2544_alternating_digit_sum {
    public int alternateDigitSum(int n) {
        int res = 0;
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        int flag = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            res += flag * nums.get(i);
            flag = -flag;
        }
        return res;
    }
}
/*
给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：

最高有效位 上的数字分配到 正 号。
剩余每位上数字的符号都与其相邻数字相反。
返回所有数字及其对应符号的和。

 

示例 1：

输入：n = 521
输出：4
解释：(+5) + (-2) + (+1) = 4
示例 2：

输入：n = 111
输出：1
解释：(+1) + (-1) + (+1) = 1
示例 3：

输入：n = 886996
输出：0
解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 

提示：

1 <= n <= 109
 



来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/alternating-digit-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
