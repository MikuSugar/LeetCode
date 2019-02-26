package JavaCode.RandomRecords;

import java.util.HashSet;
import java.util.Set;

public class N260_single_number_iii
{
    public int[] singleNumber(int[] nums)
    {
        //return hash_fun(nums);
        return xor_fun(nums);
    }


    /**
     * 异或法
     * 相同的数异或结果都为 0, 0和任意数异或结果都为那个数
     */
    private int[] xor_fun(int[] nums)
    {
        int xor=0;
        int num1=0;
        int num2=0;

        for (int n:nums)
        {
            xor^=n;
        }

        int bit=1;
        while ((xor&1)==0)
        {
            xor>>=1;
            bit<<=1;
        }

        for (int n :nums)
        {
            if((n&bit)==0)
            {
                num1^=n;
            }
            else
            {
                num2^=n;
            }
        }

        return new int[]{num1,num2};
    }

    /**
     * 常规哈希方法
     */
    private int[] hash_fun(int[] nums)
    {
        Set<Integer> set=new HashSet<>();
        for (int n:nums)
        {
            if(set.contains(n))
            {
                set.remove(n);
            }
            else
            {
                set.add(n);
            }
        }
        int[] res=new int[2];
        int i=0;
        for (int n:set)
        {
            res[i++]=n;
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
