package JavaCode.contest.n160;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/10/27
 */
public class N1 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res=new ArrayList<>();
        for (int i=1;i<=1000;i++)
        {
            int left=1,right=1000;
            while (left<right)
            {
                int y=(left+right)/2;
                int f=customfunction.f(i,y);
                if(f==z)
                {
                    List<Integer> t=new ArrayList<>(2);
                    t.add(i);t.add(y);
                    res.add(t);
                    break;
                }
                else if(f>z)right=y;
                else left=y+1;
            }
        }
        return res;
    }
}
interface CustomFunction {
    public int f(int x, int y);
}

/*
给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。

给定函数是严格单调的，也就是说：

f(x, y) < f(x + 1, y)
f(x, y) < f(x, y + 1)
函数接口定义如下：

interface CustomFunction {
public:
  // Returns positive integer f(x, y) for any given positive integer x and y.
  int f(int x, int y);
};
如果你想自定义测试，你可以输入整数 function_id 和一个目标结果 z 作为输入，其中 function_id 表示一个隐藏函数列表中的一个函数编号，题目只会告诉你列表中的 2 个函数。

你可以将满足条件的 结果数对 按任意顺序返回。



示例 1：

输入：function_id = 1, z = 5
输出：[[1,4],[2,3],[3,2],[4,1]]
解释：function_id = 1 表示 f(x, y) = x + y
示例 2：

输入：function_id = 2, z = 5
输出：[[1,5],[5,1]]
解释：function_id = 2 表示 f(x, y) = x * y


提示：

1 <= function_id <= 9
1 <= z <= 100
题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。
在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。
 */
