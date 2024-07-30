package JavaCode.random_records.N3001_N3400;

import utils.CheckUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mikusugar
 * @version 1.0, 2024/7/29 下午4:57
 * @description N3233_find_the_count_of_numbers_which_are_not_special
 */
public class N3233_find_the_count_of_numbers_which_are_not_special {
    public static void main(String[] args) {
        CheckUtil.check(81630, new N3233_find_the_count_of_numbers_which_are_not_special().nonSpecialCount(3693, 85366));
    }

    public int nonSpecialCount(int l, int r) {
        int res = r - l + 1;
        List<Integer> primes = sieveOfEratosthenes((int) Math.sqrt(r));
        for (int prime : primes) {
            long square = (long) prime * prime;
            if (square >= l && square <= r) {
                res--;
            }
        }
        return res;
    }

    private static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

}
/*
给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。

如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如：

数字 4 是 特殊数字，因为它的真因数为 1 和 2。
数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。
返回区间 [l, r] 内 不是 特殊数字 的数字数量。



示例 1：

输入： l = 5, r = 7

输出： 3

解释：

区间 [5, 7] 内不存在特殊数字。

示例 2：

输入： l = 4, r = 16

输出： 11

解释：

区间 [4, 16] 内的特殊数字为 4 和 9。



提示：

1 <= l <= r <= 10^9
 */
