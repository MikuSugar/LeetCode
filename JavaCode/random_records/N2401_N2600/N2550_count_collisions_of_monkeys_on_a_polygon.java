package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;

/**
 * @author mikusugar
 * @version 1.0, 2023/4/14 15:04
 * @description N2550_count_collisions_of_monkeys_on_a_polygon
 */
public class N2550_count_collisions_of_monkeys_on_a_polygon {

    public static void main(String[] args) {
        final N2550_count_collisions_of_monkeys_on_a_polygon algo = new N2550_count_collisions_of_monkeys_on_a_polygon();
        CheckUtil.check(algo.monkeyMove(3), 6);
        CheckUtil.check(algo.monkeyMove(4), 14);
        CheckUtil.check(algo.monkeyMove(49), 949480667);
        CheckUtil.check(algo.monkeyMove(500000003), 1000000006);
    }

    private final static int MOD = (int) (Math.pow(10, 9) + 7);

    public int monkeyMove(int n) {
        return (int) ((fastPow2(n) + MOD - 2) % MOD);
    }

    private long fastPow2(int n) {
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n % 2 == 1) {
            final long t = fastPow2((n - 1) / 2);
            return t * t % MOD * 2 % MOD;
        } else {
            final long t = fastPow2(n / 2) % MOD;
            return (t * t) % MOD;
        }
    }

}
/*
现在有一个正凸多边形，其上共有 n 个顶点。顶点按顺时针方向从 0 到 n - 1 依次编号。每个顶点上 正好有一只猴子 。下图中是一个 6 个顶点的凸多边形。



每个猴子同时移动到相邻的顶点。顶点 i 的相邻顶点可以是：

顺时针方向的顶点 (i + 1) % n ，或
逆时针方向的顶点 (i - 1 + n) % n 。
如果移动后至少有两只猴子停留在同一个顶点上或者相交在一条边上，则会发生 碰撞 。

返回猴子至少发生 一次碰撞 的移动方法数。由于答案可能非常大，请返回对 109+7 取余后的结果。

注意，每只猴子只能移动一次。

 

示例 1：

输入：n = 3
输出：6
解释：共计 8 种移动方式。
下面列出两种会发生碰撞的方式：
- 猴子 1 顺时针移动；猴子 2 逆时针移动；猴子 3 顺时针移动。猴子 1 和猴子 2 碰撞。
- 猴子 1 逆时针移动；猴子 2 逆时针移动；猴子 3 顺时针移动。猴子 1 和猴子 3 碰撞。
可以证明，有 6 种让猴子碰撞的方法。
示例 2：

输入：n = 4
输出：14
解释：可以证明，有 14 种让猴子碰撞的方法。
 

提示：

3 <= n <= 109


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/count-collisions-of-monkeys-on-a-polygon
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
