package JavaCode.random_records.N2601_N3000;

import utils.CheckUtil;
import utils.Parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mikusugar
 * @version 1.0, 2024/7/30 下午4:24
 * @description N2961_double_modular_exponentiation
 */
public class N2961_double_modular_exponentiation {
    public static void main(String[] args) {
        CheckUtil.check(Arrays.asList(0, 2), new N2961_double_modular_exponentiation().getGoodIndices(
                Parse.toIntTwoArr("[[2,3,3,10],[3,3,3,1],[6,1,1,4]]"), 2
        ));
    }

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            if (check(variables[i], target)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean check(int[] variable, int target) {
        return fastPow(fastPow(variable[0], variable[1], 10), variable[2], variable[3]) == target;
    }

    private long fastPow(long num, int k, int mod) {
        if (k == 0) return 1;
        if (k == 1) return num % mod;
        return fastPow(num, k / 2, mod) % mod * fastPow(num, k - k / 2, mod) % mod;
    }
}
/*
给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。

如果满足以下公式，则下标 i 是 好下标：

0 <= i < variables.length
((ai^bi % 10)^ci) % mi == target
返回一个由 好下标 组成的数组，顺序不限 。



示例 1：

输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
输出：[0,2]
解释：对于 variables 数组中的每个下标 i ：
1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(23 % 10)3 % 10 = 2 。
2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(33 % 10)3 % 1 = 0 。
3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(61 % 10)1 % 4 = 2 。
因此，返回 [0,2] 作为答案。
示例 2：

输入：variables = [[39,3,1000,1000]], target = 17
输出：[]
解释：对于 variables 数组中的每个下标 i ：
1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(393 % 10)1000 % 1000 = 1 。
因此，返回 [] 作为答案。


提示：

1 <= variables.length <= 100
variables[i] == [ai, bi, ci, mi]
1 <= ai, bi, ci, mi <= 10^3
0 <= target <= 10^3
 */
