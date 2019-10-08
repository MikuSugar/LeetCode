package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/10/8
 */
public class N944_delete_columns_to_make_sorted {
    public int minDeletionSize(String[] A) {
        final int n=A[0].length();
        int res=0;
        for (int i=0;i<n;i++)
        {
            for (int j=1;j<A.length;j++)
            {
                if(A[j].charAt(i)<A[j-1].charAt(i))
                {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
/**
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 *
 * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 *
 * 比如，有 A = ["abcdef", "uvwxyz"]，
 *
 *
 *
 * 要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
 *
 *
 *
 * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["cba", "daf", "ghi"]
 * 输出：1
 * 解释：
 * 当选择 D = {1}，删除后 A 的列为：["c","d","g"] 和 ["a","f","i"]，均为非降序排列。
 * 若选择 D = {}，那么 A 的列 ["b","a","h"] 就不是非降序排列了。
 * 示例 2：
 *
 * 输入：["a", "b"]
 * 输出：0
 * 解释：D = {}
 * 示例 3：
 *
 * 输入：["zyx", "wvu", "tsr"]
 * 输出：3
 * 解释：D = {0, 1, 2}
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-columns-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
