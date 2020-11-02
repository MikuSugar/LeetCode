package JavaCode.contest.weekly.n0_200.n143;

import java.util.LinkedList;
import java.util.Queue;

public class N4 {

    private int idx;
    public boolean parseBoolExpr(String expression) {
        char[] e = expression.toCharArray();
        idx=0;
        return dfs(e,'|');
    }

    private boolean dfs(char[] e, char flag) {
        Queue<Boolean> queue=new LinkedList<>();
        while (idx<e.length)
        {
            if(e[idx]==')')
            {
                idx++;
                break;
            }
            else if(e[idx]=='t')
            {
                idx++;
                queue.add(true);
            }
            else if(e[idx]=='f')
            {
                idx++;
                queue.add(false);
            }
            else if(e[idx]=='!'||e[idx]=='|'||e[idx]=='&')
            {
                queue.add(dfs(e,e[idx++]));
            }
            else {idx++;}
        }
        if(queue.isEmpty())return true;
        boolean res=queue.poll();
        if(flag=='|')
        {
            while (!queue.isEmpty())
            {
                res|=queue.poll();
            }
        }
        else if(flag=='&')
        {
            while (!queue.isEmpty())
            {
                res&=queue.poll();
            }
        }
        else if(flag=='!')
        {
            res=!res;
        }
        return res;
    }
}
/**
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 *
 * 有效的表达式遵循以下约定：
 *
 * "t"，运算结果为 True；
 * "f"，运算结果为 False;
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑非（NOT）运算；
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑与（AND）运算；
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑或（OR）运算
 *
 *
 * 示例 1：
 *
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 *
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 *
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 *
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 */
