package JavaCode.random_records.N901_1000;


import java.util.Stack;

public class N907_sum_of_subarray_minimums
{

    private final static int MOD= (int) (1e9+7);
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[A.length];
        int[] right=new int[A.length];
        for (int i=0,j=A.length;i<A.length;i++,j--)
        {
            left[i]=i+1;
            right[i]=j;
        }

        for (int i=0;i<A.length;i++)
        {
            while (!stack.isEmpty()&&A[stack.peek()]>A[i])
            {
                stack.pop();
            }
            left[i]=stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i=0;i<A.length;i++)
        {
            while (!stack.isEmpty()&&A[stack.peek()]>A[i])
            {
                right[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        int res=0;
        for (int i=0;i<A.length;i++)
        {
            res=(res+A[i]*left[i]*right[i])%MOD;
        }
        return res;
    }
}
/**
 * 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-subarray-minimums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
