package JavaCode.recursion_i.recurrence_relation;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle_II {
    public List<Integer> getRow(int rowIndex) {
        return help(rowIndex,new ArrayList<Integer>());
    }

    private List<Integer> help(int flag, List<Integer> pre) {
        if(flag==0)return pre;
        if(pre.size()==0)
        {
            pre.add(1);
            return help(flag-1,pre);
        }
        else
        {
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for (int i=0;i<pre.size()-1;i++)
            {
                cur.add(pre.get(i)+pre.get(i+1));
            }
            cur.add(1);
            return help(flag-1,cur);
        }
    }
}
/**
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
