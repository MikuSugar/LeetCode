package JavaCode.lcof;
import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/3/6
 */
public class 面试题57_II_和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int sum=0,left=1,right=1;
        while (right<target)
        {
            sum+=right;
            while (sum>target)
            {
                sum-=left++;
            }
            if(sum==target)
            {
                res.add(new int[]{left,right});
            }
            right++;
        }
        int[][] ans=new int[res.size()][];
        for (int i=0;i<ans.length;i++)
        {
            int[] size=res.get(i);
            ans[i]=new int[size[1]-size[0]+1];
            for (int idx=0;idx<ans[i].length;idx++)
            {
                ans[i][idx]=idx+size[0];
            }
        }
        return ans;
    }
}
/*
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
