package JavaCode.random_records.N901_1000;

public class N915_partition_array_into_disjoint_intervals {
    public int partitionDisjoint(int[] A) {
        int idx=0,max=A[0],leftMax=A[0];
        for (int i=1;i<A.length;i++)
        {
            max=Math.max(max,A[i]);
            if(A[i]<leftMax)
            {
                leftMax=max;
                idx=i;
            }
        }
        return ++idx;
    }
}
/**
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 *
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 *
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
