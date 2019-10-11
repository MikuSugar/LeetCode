package JavaCode.random_records.N401_500;

import java.util.HashSet;
import java.util.Set;

/**
 * author:fangjie
 * time:2019/10/10
 */
public class N421_maximum_xor_of_two_numbers_in_an_array {
    public int findMaximumXOR(int[] nums) {
        int res=0,mask=0;
        Set<Integer> set=new HashSet<>();
        for (int i=31;i>=0;i--)
        {
            mask|=(1<<i);
            set.clear();
            for (int n:nums)set.add(n&mask);
            int tmp = res|(1 << i);
            for(int prefix : set)
            {
                if(set.contains(tmp ^ prefix))
                {
                    res=tmp;
                    break;
                }
            }
        }
        return res;

    }
}
/**
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
