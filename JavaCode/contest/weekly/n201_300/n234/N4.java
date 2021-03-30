package JavaCode.contest.weekly.n201_300.n234;


/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/28 10:17 上午
 */
public class N4 {

    private final static int MOD=(int) (1e9+7);

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors<=3) return primeFactors;
        if (primeFactors%3==1) return (int) (powMod(3, (primeFactors-4)/3, MOD)*4%MOD);
        if (primeFactors%3==2) return (int) (powMod(3, primeFactors/3, MOD)*2%MOD);
        return (int) (powMod(3, primeFactors/3, MOD));
    }

    long powMod(long a, long b, final long mod) {
        if (b==0) return 1L;
        long res=powMod(a, b/2, mod)%mod;
        if (b%2==0) return res*res%mod;
        return res*res*a%mod;
    }

}
/*
给你一个正整数 primeFactors 。你需要构造一个正整数 n ，它满足以下条件：

n 质因数（质因数需要考虑重复的情况）的数目 不超过 primeFactors 个。
n 好因子的数目最大化。如果 n 的一个因子可以被 n 的每一个质因数整除，我们称这个因子是 好因子 。比方说，如果 n = 12 ，那么它的质因数为 [2,2,3] ，那么 6 和 12 是好因子，但 3 和 4 不是。
请你返回 n 的好因子的数目。由于答案可能会很大，请返回答案对 109 + 7 取余 的结果。

请注意，一个质数的定义是大于 1 ，且不能被分解为两个小于该数的自然数相乘。一个数 n 的质因子是将 n 分解为若干个质因子，且它们的乘积为 n 。



示例 1：

输入：primeFactors = 5
输出：6
解释：200 是一个可行的 n 。
它有 5 个质因子：[2,2,2,5,5] ，且有 6 个好因子：[10,20,40,50,100,200] 。
不存在别的 n 有至多 5 个质因子，且同时有更多的好因子。
示例 2：

输入：primeFactors = 8
输出：18


提示：

1 <= primeFactors <= 109
 */
