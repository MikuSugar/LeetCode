package JavaCode.contest.other.cnunionpay_2022spring;

import utils.Parse;

import java.util.*;

/**
 * @author mikusugar
 */
public class N3 {


    public static void main(String[] args) {
        System.out.println(new N3().maxInvestment(
                Parse.parseToIntArray("[43877,10848,10442,48132,83395,71523,60275,39527]")
                , 345056
        ));
    }

    private static final int MOD = 1000000007;

    public int maxInvestment(int[] product, int limit) {
        //init
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : product) map.put(i, map.getOrDefault(i, 0) + 1);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
        }

        long res = 0L;

        while (!pq.isEmpty() && limit > 0) {
            if (pq.size() == 1) {
                final int[] poll = pq.poll();
                int cnt = Math.min(limit, poll[1]);
                limit -= cnt;
                res += (long) cnt % MOD * poll[0] % MOD;
                if (poll[0] - 1 >= 1) {
                    pq.add(new int[]{poll[0] - 1, poll[1]});

                }
            } else {
                final int[] f = pq.poll();
                final int[] s = pq.poll();
                int cnt = Math.min(limit / f[1], f[0] - s[0]);
                if (cnt == 0) {
                    cnt = Math.min(limit, f[1]);
                    limit -= cnt;
                    res += (long) cnt % MOD * f[0] % MOD;
                    //TODO 这里好像有问题
                    if (f[0] - 2 != s[0]) {
                        pq.add(new int[]{f[0] - 2, f[1]});
                    } else {
                        s[1] += f[1];
                    }
                    pq.add(s);
                } else {
                    limit -= cnt * f[1];
                    res += (long) f[1] % MOD * cnt % MOD * (f[0] + f[0] - cnt + 1) / 2 % MOD;
                    if (f[0] - cnt != s[0]) {
                        pq.add(new int[]{f[0] - cnt, f[1]});
                    } else {
                        s[1] += f[1];
                    }
                    pq.add(s);
                }

            }

        }


        return (int) (res % MOD);
    }
}
/*
某公司计划推出一批投资项目。 product[i] = price 表示第 i 个理财项目的投资金额 price 。客户在按需投资时，需要遵循以下规则：

客户在首次对项目 product[i] 投资时，需要投入金额 price
对已完成首次投资的项目 product[i] 可继续追加投入，但追加投入的金额需小于上一次对该项目的投入(追加投入为大于 0 的整数)
为控制市场稳定，每人交易次数不得大于 limit。(首次投资和追加投入均记作 1 次交易)
若对所有理财项目中最多进行 limit 次交易，使得投入金额总和最大，请返回这个最大值的总和。

注意：

答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
示例 1：

输入：product = [4,5,3], limit = 8

输出：26

解释：满足条件的一种情况为：
第一个理财项目进行金额为 4，3，2 的交易；
第二个理财项目进行金额为 5，4，3 的交易；
第三个理财项目进行金额为 3，2 的交易；
得到最大投入金额总和为 5 + 4 * 2 + 3 * 3 + 2 * 2 = 26。

示例 2：

输入：product = [2,1,3], limit = 20

输出：10

解释：可交易总次数小于 limit，因此进行所有交易
第一个理财项目可交易 2 次，交易的金额分别为 2，1；
第二个理财项目可交易 1 次，交易的金额分别为 1；
第三个理财项目可交易 3 次，交易的金额分别为 3，2，1；
因此所得最大投入金额总和为 3 + 2 * 2 + 1 * 3 = 10。

提示：

1 <= product.length <= 10^5
1 <= product[i] <= 10^7
1 <= limit <= 10^9
 */
