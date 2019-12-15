package JavaCode.contest.n167;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author:fangjie
 * time:2019/12/15
 */
public class N2 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        dfs(res,new StringBuilder(),0,low,high);
        Collections.sort(res);
        return res;
    }

    private void dfs(List<Integer> res, StringBuilder sb,int idx,int low, int high) {
        if(sb.length()==0)
        {
            for (int i=1;i<10;i++)
            {
                sb.append(i);
                dfs(res,sb,i,low,high);
                sb.deleteCharAt(sb.length()-1);
            }
            return;
        }
        int cur=Integer.parseInt(sb.toString());
        if(cur>high)return;
        if(cur>=low) res.add(cur);
        int next=idx+1;
        if(next>9)return;
        sb.append(next);
        dfs(res,sb,next,low,high);
        sb.deleteCharAt(sb.length()-1);
    }
}
/*
我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。

请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。



示例 1：

输出：low = 100, high = 300
输出：[123,234]
示例 2：

输出：low = 1000, high = 13000
输出：[1234,2345,3456,4567,5678,6789,12345]


提示：

10 <= low <= high <= 10^9
 */
