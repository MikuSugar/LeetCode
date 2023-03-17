package JavaCode.random_records.N2101_N2200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/17 15:32
 */
public class N2160_minimum_sum_of_four_digit_number_after_splitting_digits {
    public static void main(String[] args) {
        System.out.println(new N2160_minimum_sum_of_four_digit_number_after_splitting_digits().minimumSum(4009));
    }

    public int minimumSum(int num) {
        final String numStr = String.valueOf(num);
        List<Integer> nums = new ArrayList<>();
        for (char c : numStr.toCharArray()) {
            final int i = c - '0';
            if (i > 0) {
                nums.add(i);
            }
        }
        StringBuilder left = new StringBuilder();
        left.append('0');
        StringBuilder right = new StringBuilder();
        right.append('0');

        nums.sort(Integer::compareTo);
        for (int i = 0; i < nums.size(); i++) {
            if (i % 2 == 0) {
                left.append(nums.get(i));
            } else {
                right.append(nums.get(i));
            }
        }
        return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString());
    }
}
/*
给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 前导 0 ，且 num 中 所有 数位都必须使用。

比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]，[23, 92]，[223, 9] 和 [2, 329] 。
请你返回可以得到的 new1 和 new2 的 最小 和。

 

示例 1：

输入：num = 2932
输出：52
解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
最小和为数对 [29, 23] 的和：29 + 23 = 52 。
示例 2：

输入：num = 4009
输出：13
解释：可行的 [new1, new2] 数对为 [0, 49] ，[490, 0] 等等。
最小和为数对 [4, 9] 的和：4 + 9 = 13 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-sum-of-four-digit-number-after-splitting-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
