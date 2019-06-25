package JavaCode.recursion_i.recurrence_relation;

import java.util.ArrayList;
import java.util.List;

public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if(numRows<1)return res;
        List<Integer> list=new ArrayList<>();
        list.add(1);
        res.add(list);
        help(numRows-1,res);
        return res;
    }

    private void help(int flag, List<List<Integer>> res) {
        if(flag<=0)return;
        List<Integer> pre = res.get(res.size() - 1);
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i=0;i<pre.size()-1;i++)
        {
            cur.add(pre.get(i)+pre.get(i+1));
        }
        cur.add(1);
        res.add(cur);
        help(flag-1,res);
    }
}
/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
