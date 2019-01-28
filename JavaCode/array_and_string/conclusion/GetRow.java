package JavaCode.array_and_string.conclusion;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<=rowIndex;i++)
        {
            list.add(1);
            for(int j=i-1;j>=1;j--)
            {
                list.set(j,list.get(j)+list.get(j-1));
            }
        }
        return list;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/202/conclusion/792/
 * 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
