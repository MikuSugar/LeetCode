package JavaCode.contest.n146;

import java.util.HashMap;
import java.util.Map;

public class N3 {
    private Map<String,Integer> map;
    public int mctFromLeafValues(int[] arr) {
        map=new HashMap<>();
        return dfs(0,arr.length,arr);
    }

    private int dfs(int start, int end, int[] arr) {
        if(start>=end)return 0;
        String key=start+","+end;
        if(map.containsKey(key))
        {
            return map.get(key);
        }
        int res=-1;
        for (int i=start;i<end;i++)
        {
            int l=dfs(start,i,arr);
            int r=dfs(i+1,end,arr);
            int val=getMax(start,i,arr)*getMax(i+1,end,arr);
            if(res==-1)res=l+r+val;
            else res=Math.min(res,l+r+val);
        }
        map.put(key,res);
        return res;
    }

    private int getMax(int i, int end, int[] arr) {
        int res=0;
        for (int k=i;k<=end&&k<arr.length;k++)
        {
            res=Math.max(arr[k],res);
        }
        return res;
    }
}
/**
 *给你一个正整数数组 arr，考虑所有满足以下条件的二叉树：
 *
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组 arr 中的值与树的中序遍历中每个叶节点的值一一对应。（知识回顾：如果一个节点有 0 个子节点，那么该节点为叶节点。）
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个 32 位整数。
 *
 *
 *
 * 示例：
 *
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：
 * 有两种可能的树，第一种的非叶节点的总和为 36，第二种非叶节点的总和为 32。
 *
 *     24            24
 *    /  \          /  \
 *   12   4        6    8
 *  /  \               / \
 * 6    2             2   4
 *
 *
 * 提示：
 *
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * 答案保证是一个 32 位带符号整数，即小于 2^31。
 */
