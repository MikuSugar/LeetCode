package JavaCode.contest.biweekly_n9;

import java.util.HashMap;
import java.util.Map;

/**
 * author:fangjie
 * time:2019/9/23
 */
public class N3 {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<mat[0].length;i++)
        {
            for (int j=0;j<mat.length;j++)
            {
                int key=mat[j][i];
                int cnt=map.getOrDefault(key, 0);
                if(cnt==mat.length-1)return key;
                map.put(key,cnt+1);
            }
        }
        return -1;
    }

}
/**
 * 给你一个矩阵 mat，其中每一行的元素都已经按 递增 顺序排好了。请你帮忙找出在所有这些行中 最小的公共元素。
 *
 * 如果矩阵中没有这样的公共元素，就请返回 -1。
 *
 *
 *
 * 示例：
 *
 * 输入：mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
 * 输出：5
 *
 *
 * 提示：
 *
 * 1 <= mat.length, mat[i].length <= 500
 * 1 <= mat[i][j] <= 10^4
 * mat[i] 已按递增顺序排列。
 */
