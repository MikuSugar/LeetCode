package JavaCode.random_records.N801_900;

public class N896_monotonic_array {
    public boolean isMonotonic(int[] A) {
        if(A.length<=2)return true;
        int cur=1;
        while (cur<A.length&&A[cur]==A[cur-1])
        {
            cur++;
        }
        if(cur==A.length)return true;
        if(A[cur]>A[cur-1])
        {
            while (cur<A.length)
            {
                if(A[cur]<A[cur-1])return false;
                cur++;
            }
            return true;
        }
        else
        {
            while (cur<A.length)
            {
                if(A[cur]>A[cur-1])return false;
                cur++;
            }
            return true;
        }
    }
}
/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：[6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：[1,3,2]
 * 输出：false
 * 示例 4：
 *
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 *
 * 输入：[1,1,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotonic-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
