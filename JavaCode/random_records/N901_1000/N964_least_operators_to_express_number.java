package JavaCode.random_records.N901_1000;

import java.util.HashMap;
import java.util.Map;

public class N964_least_operators_to_express_number {
    public int leastOpsExpressTarget(int x, int target) {
        return dp(new HashMap<String,Integer>(),x,target,0)-1;
    }

    private int dp(Map<String, Integer> book, int x, int target, int i) {
        String key=i+"#"+target;
        if(book.containsKey(key))return book.get(key);

        int res;
        if(target==0)
        {
            res=0;
        }
        else if(target==1)
        {
            res=help(i);
        }
        else if (i>=39)
        {
            res=target+1;
        }
        else
        {
            int t=target/x;
            int r=target%x;
            res=Math.min(r*help(i)+dp(book,x,t,i+1),(x-r)*help(i)+dp(book,x,t+1,i+1));
        }
        book.put(key,res);
        return res;
    }

    private int help(int i) {
        return i>0?i:2;
    }
}
/**
 * https://leetcode-cn.com/problems/least-operators-to-express-number/
 * 给定一个正整数 x，我们将会写出一个形如 x (op1) x (op2) x (op3) x ... 的表达式，其中每个运算符 op1，op2，… 可以是加、减、乘、除（+，-，*，或是 /）之一。例如，对于 x = 3，我们可以写出表达式 3 * 3 / 3 + 3 - 3，该式的值为 3 。
 *
 * 在写这样的表达式时，我们需要遵守下面的惯例：
 *
 * 除运算符（/）返回有理数。
 * 任何地方都没有括号。
 * 我们使用通常的操作顺序：乘法和除法发生在加法和减法之前。
 * 不允许使用一元否定运算符（-）。例如，“x - x” 是一个有效的表达式，因为它只使用减法，但是 “-x + x” 不是，因为它使用了否定运算符。
 * 我们希望编写一个能使表达式等于给定的目标值 target 且运算符最少的表达式。返回所用运算符的最少数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 3, target = 19
 * 输出：5
 * 解释：3 * 3 + 3 * 3 + 3 / 3 。表达式包含 5 个运算符。
 * 示例 2：
 *
 * 输入：x = 5, target = 501
 * 输出：8
 * 解释：5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5 。表达式包含 8 个运算符。
 * 示例 3：
 *
 * 输入：x = 100, target = 100000000
 * 输出：3
 * 解释：100 * 100 * 100 * 100 。表达式包含 3 个运算符。
 *
 *
 * 提示：
 *
 * 2 <= x <= 100
 * 1 <= target <= 2 * 10^8
 *
 */
