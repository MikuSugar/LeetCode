package JavaCode.contest.n138;


public class N2 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res=0;
        for (int i=0;i<customers.length;i++)
        {
            res+=grumpy[i]==0?customers[i]:0;
        }
        int left=0,right=0;
        int d=0;
        int sum=res;
        while (right<customers.length)
        {
            if(right-left<X)
            {
                if(grumpy[right++]==1)
                {
                    d+=customers[right-1];
                }
            }else if(right-left==X)
            {
                res=Math.max(res,sum+d);
                if(grumpy[left++]==1)
                {
                    d-=customers[left-1];
                }
            }
        }
        return res;
    }
}
/**
 *今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，否则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，可以让自己连续 X 分钟不生气，但只能使用一次。
 *
 * 返回全天可满足的最大客户数量。
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 可满足的最大客户数 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 *
 * 提示：
 *
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 */
