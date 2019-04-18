package JavaCode.random_records.N701_800;

public class N762_prime_number_of_set_bits_in_binary_representation {

    //10^6<2^20
    static private boolean isPrime(int num)
    {
        return num==2||num==3||num==5||num==7||num==11||num==13||num==17||num==19;
    }

    public int countPrimeSetBits(int L, int R) {
        int res=0;
        for (int i=L;i<=R;i++)
        {
            res+=isPrime(getCnt(i))?1:0;
        }
        return res;
    }

    private int getCnt(int i) {
        int cnt=0;
        while (i!=0)
        {
            cnt+=i%2==1?1:0;
            i/=2;
        }
        return cnt;
    }
}
/**
 * https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * 示例 1:
 *
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 示例 2:
 *
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 注意:
 *
 * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * R - L 的最大值为 10000。
 */
