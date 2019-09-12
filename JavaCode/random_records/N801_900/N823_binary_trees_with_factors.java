package JavaCode.random_records.N801_900;

import java.util.*;

public class N823_binary_trees_with_factors {
    private final static int MOD=(int) (1e9+7);
    public int numFactoredBinaryTrees(int[] A) {
        Set<Integer> book=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:A)
        {
            book.add(i);
        }
        Arrays.sort(A);
        long res=0;
        for (int i:A)
        {
            res+=slove(book,i,map,A);
            res%=MOD;
        }
        return (int) res;
    }

    private long slove(Set<Integer> book, int val, Map<Integer, Integer> map,int[] arr) {
        if(map.containsKey(val))return map.get(val);
        long res=1;
        int size=(int) Math.sqrt(val);
        int idx=0;
        while (idx<arr.length)
        {
            if(arr[idx]>size)break;
            else if(val%arr[idx]==0)
            {
                int j=val/arr[idx];
                if(book.contains(j))
                {
                    long s1=slove(book,arr[idx],map,arr)%MOD;
                    long s2=slove(book,j,map,arr)%MOD;
                    if(arr[idx]==j)res+=(s1*s2)%MOD;
                    else res+=(s1*s2)*2%MOD;
                }
            }
            idx++;
        }
        res%=MOD;
        map.put(val,(int)res);
        return res;
    }
}
/**
 * 给出一个含有不重复整数元素的数组，每个整数均大于 1。
 *
 * 我们用这些整数来构建二叉树，每个整数可以使用任意次数。
 *
 * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 *
 * 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: A = [2, 4]
 * 输出: 3
 * 解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
 * 示例 2:
 *
 * 输入: A = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 *  
 *
 * 提示:
 *
 * 1 <= A.length <= 1000.
 * 2 <= A[i] <= 10 ^ 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-trees-with-factors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
