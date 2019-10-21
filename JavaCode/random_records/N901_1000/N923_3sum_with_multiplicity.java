package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/10/21
 */
public class N923_3sum_with_multiplicity {
    private final static int MOD=(int) (1e9+7);
    public int threeSumMulti(int[] A, int target) {
        int[] book=new int[target+1];
        int res=0;
        for (int i=0;i<A.length;i++)
        {
            int find=target-A[i];
            if(find<0)continue;
            res+=book[find];
            res%=MOD;
            for (int j=0;j<i;j++)
            {
                int sum=A[i]+A[j];
                if(sum<=target)book[sum]++;
            }
        }
        return res;
    }
}
/**
 * 给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 *
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举（A[i]，A[j]，A[k]）：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * 示例 2：
 *
 * 输入：A = [1,1,2,2,2,2], target = 5
 * 输出：12
 * 解释：
 * A[i] = 1，A[j] = A[k] = 2 出现 12 次：
 * 我们从 [1,1] 中选择一个 1，有 2 种情况，
 * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 3000
 * 0 <= A[i] <= 100
 * 0 <= target <= 300
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-with-multiplicity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
