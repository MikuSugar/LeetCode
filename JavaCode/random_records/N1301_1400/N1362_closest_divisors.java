package JavaCode.random_records.N1301_1400;

/**
 * author:fangjie
 * time:2020/3/12
 */
public class N1362_closest_divisors {
    public int[] closestDivisors(int num) {
        for (int i=(int) Math.sqrt(num+2);i>0;i--)
        {
            if((num+1)%i==0)return new int[]{i,(num+1)/i};
            if((num+2)%i==0)return new int[]{i,(num+2)/i};
        }
        return null;
    }
}
/*
给你一个整数 num，请你找出同时满足下面全部要求的两个整数：

两数乘积等于  num + 1 或 num + 2
以绝对差进行度量，两数大小最接近
你可以按任意顺序返回这两个整数。

 

示例 1：

输入：num = 8
输出：[3,3]
解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
示例 2：

输入：num = 123
输出：[5,25]
示例 3：

输入：num = 999
输出：[40,25]
 

提示：

1 <= num <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/closest-divisors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
