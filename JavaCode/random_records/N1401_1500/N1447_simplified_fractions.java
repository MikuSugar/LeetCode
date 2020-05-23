package JavaCode.random_records.N1401_1500;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:fangjie
 * @Date:2020/5/23 4:24 下午
 */
public class N1447_simplified_fractions {
    public List<String> simplifiedFractions(int n) {
        List<String> res=new ArrayList<>();
        for (int i=2;i<=n;i++)
        {
            res.add("1/"+i);
            for (int j=2;j<i;j++)
            {
                if(gcd(j,i)==1)res.add(j+"/"+i);
            }
        }
        return res;
    }

    private int gcd(int n, int m) {
        return m==0?n:gcd(m,n%m);
    }
}
/*
给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。

 

示例 1：

输入：n = 2
输出：["1/2"]
解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
示例 2：

输入：n = 3
输出：["1/2","1/3","2/3"]
示例 3：

输入：n = 4
输出：["1/2","1/3","1/4","2/3","3/4"]
解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
示例 4：

输入：n = 1
输出：[]
 

提示：

1 <= n <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/simplified-fractions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
