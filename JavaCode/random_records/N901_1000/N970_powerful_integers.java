package JavaCode.random_records.N901_1000;

import java.util.*;

public class N970_powerful_integers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res=new HashSet<>();
        List<Integer> list_x=help(x,bound);
        List<Integer> list_y=help(y,bound);
        for (int i:list_x)
        {
            for (int j:list_y)
            {
                int sum=i+j;
                if(sum>bound)break;
                res.add(sum);
            }
        }
        List<Integer> ans=new ArrayList<>(res.size());
        ans.addAll(res);
        return ans;
    }

    private List<Integer> help(int x, int bound) {
        List<Integer> res=new ArrayList<>();
        if(x<=1)
        {
            res.add(1);
            return res;
        }
        int t=0;
        while (true)
        {
            int pow = (int) Math.pow(x, t++);
            if(pow>=bound)break;
            res.add(pow);
        }
        return res;
    }
}
/**
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 *
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 *
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * 示例 2：
 *
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *  
 *
 * 提示：
 *
 * 1 <= x <= 100
 * 1 <= y <= 100
 * 0 <= bound <= 10^6
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powerful-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
