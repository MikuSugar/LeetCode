package JavaCode.contest.biweekly_n11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * author:fangjie
 * time:2019/10/19
 */
public class N1 {
    public int missingNumber(int[] arr) {
        Set<Integer> set=new HashSet<>();
        int n=-1;
        for (int i=1;i<arr.length;i++)
        {
            int dif=arr[i]-arr[i-1];
            if(set.contains(dif))
            {
                n=dif;
            }
            set.add(dif);
        }
        if(set.size()==1)return 0;
        if(n==-1)n=arr[arr.length-1]-arr[arr.length-2];
        for (int i=1;i<arr.length;i++)
        {
            int dif=arr[i]-arr[i-1];
            if(n!=dif)
            {
                return arr[i]-n;
            }
        }
        return -1;
    }
}
/**
 * 数组 arr 中的值符合等差数列的数值规律：在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
 *
 * 然后，我们从数组中删去一个 既不是第一个也不是最后一个的值 。
 *
 * 给你一个缺失值的数组，请你帮忙找出那个被删去的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [5,7,11,13]
 * 输出：9
 * 解释：原来的数组是 [5,7,9,11,13]。
 * 示例 2：
 *
 * 输入：arr = [15,13,12]
 * 输出：14
 * 解释：原来的数组是 [15,14,13,12]。
 *
 *
 * 提示：
 *
 * 3 <= arr.length <= 1000
 * 0 <= arr[i] <= 10^5
 */
