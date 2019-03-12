package JavaCode.random_records.N301_400;

import java.util.ArrayList;
import java.util.List;

public class N386_lexicographical_numbers
{
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for (int i=1;i<=9;i++)
        {
            fun(n,i,res);
        }
        return res;
    }
    private void fun(int max,int n,List<Integer> res)
    {
        if(n>max)return;
        res.add(n);
        n*=10;
        for (int i=0;i<=9;i++)
        {
            fun(max,n+i,res);
        }
    }
}
/**
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
