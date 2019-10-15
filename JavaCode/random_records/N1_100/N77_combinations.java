package JavaCode.random_records.N1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/10/15
 */
public class N77_combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] book=new boolean[n+1];
        dfs(0,res,book,new ArrayList<>(),k,n);
        return res;
    }

    private void dfs(final int start,List<List<Integer>> res, boolean[] book, List<Integer> list, final int k, final int n) {
        if(list.size()==k)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start+1;i<=n;i++)
        {
            if(book[i])continue;
            book[i]=true;
            list.add(i);
            dfs(i,res,book,list,k,n);
            list.remove(list.size()-1);
            book[i]=false;
        }
    }
}
/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
