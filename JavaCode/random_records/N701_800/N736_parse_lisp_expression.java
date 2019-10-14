package JavaCode.random_records.N701_800;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/14
 */
public class N736_parse_lisp_expression {
    
    public int evaluate(String expression) {
        return slove(expression,new HashMap<>());
    }

    private int slove(String exp, Map<String,Integer> pre_map) {
        String[] exps=getExps(exp);
        if(exps[0].equals("let"))
        {
            Map<String,Integer> map=new HashMap<>(pre_map);
            for (int i=1;i<exps.length-2;i+=2)
            {
                int v=0;
                if(exps[i+1].charAt(0)=='(')v=slove(exps[i+1],map);
                else v=getValue(map,exps[i+1]);
                map.put(exps[i],v);
            }
            if(exps[exps.length-1].charAt(0)=='(')return slove(exps[exps.length-1],map);
            return getValue(map,exps[exps.length-1]);
        }
        else
        {
            int[] res=new int[2];
            for (int i=1;i<=2;i++)
            {
                if(exps[i].charAt(0)=='(')res[i-1]=slove(exps[i],pre_map);
                else res[i-1]=getValue(pre_map,exps[i]);
            }
            if(exps[0].equals("add"))return res[0]+res[1];
            return res[0]*res[1];
        }
    }

    private int getValue(Map<String, Integer> map, String exp) {
        if(map.containsKey(exp))return map.get(exp);
        return Integer.parseInt(exp);
    }

    private String[] getExps(String exp) {
        List<String> res=new ArrayList<>();
        char[] strs=exp.substring(1, exp.length()-1).toCharArray();
        int idx=0,pre=0;
        while (idx<strs.length)
        {
            if(strs[idx]==' ')
            {
                res.add(new String(strs,pre,idx-pre));
                pre=idx+1;
            }
            else if(strs[idx]=='(')
            {
                int cnt=0;
                while (idx<strs.length)
                {
                    if(strs[idx]=='(')cnt++;
                    else if(strs[idx]==')')cnt--;
                    idx++;
                    if(cnt==0)break;
                }
                res.add(new String(strs,pre,idx-pre));
                pre=idx+1;
            }
            idx++;
        }
        if(pre<strs.length)res.add(new String(strs,pre,strs.length-pre));
        return res.toArray(new String[res.size()]);
    }


}
/**
 * 给定一个类似 Lisp 语句的表达式 expression，求出其计算结果。
 *
 * 表达式语法如下所示:
 *
 * 表达式可以为整数，let 语法，add 语法，mult 语法。表达式的结果总是一个整数。
 * (整数可以是正整数、负整数、0)
 * let 语法表示为 (let v1 e1 v2 e2 ... vn en expr), 其中 let语法总是以字符串 "let"来表示，接下来会跟随一个或多个交替变量或表达式，也就是说，第一个变量 v1被分配为表达式 e1 的值，第二个变量 v2 被分配为表达式 e2 的值，以此类推；最终 let 语法的值为 expr表达式的值。
 * add语法表示为 (add e1 e2)，其中 add 语法总是以字符串 "add"来表示，该语法总是有两个表达式e1、e2, 该语法的最终结果是 e1 表达式的值与 e2 表达式的值之和。
 * mult语法表示为 (mult e1 e2) ，其中 mult 语法总是以字符串"mult"表示， 该语法总是有两个表达式 e1、e2，该语法的最终结果是 e1 表达式的值与 e2 表达式的值之积。
 * 在该题目中，变量的命名以小写字符开始，之后跟随0个或多个小写字符或数字。为了方便，"add"，"let"，"mult"会被定义为"关键字"，不会在表达式的变量命名中出现。
 * 最后，要说一下范围的概念。在做计算时，需要注意优先级，在最内层(根据括号)的表达式的值应该先计算,然后依次计算外层的表达式。我们将保证每一个测试的表达式都是合法的。有关范围的更多详细信息，请参阅示例。
 *  
 *
 * 示例:
 *
 * 输入: (add 1 2)
 * 输出: 3
 *
 * 输入: (mult 3 (add 2 3))
 * 输出: 15
 *
 * 输入: (let x 2 (mult x 5))
 * 输出: 10
 *
 * 输入: (let x 2 (mult x (let x 3 y 4 (add x y))))
 * 输出: 14
 * 解释:
 * 表达式 (add x y), 在获取 x 值时, 我们应当由最内层依次向外计算, 首先遇到了 x=3, 所以此处的 x 值是 3.
 *
 *
 * 输入: (let x 3 x 2 x)
 * 输出: 2
 * 解释: let 语句中的赋值运算按顺序处理即可
 *
 * 输入: (let x 1 y 2 x (add x y) (add x y))
 * 输出: 5
 * 解释:
 * 第一个 (add x y) 计算结果是 3，并且将此值赋给了 x 。
 * 第二个 (add x y) 计算结果就是 3+2 = 5 。
 *
 * 输入: (let x 2 (add (let x 3 (let x 4 x)) x))
 * 输出: 6
 * 解释:
 * (let x 4 x) 中的 x 的作用范围仅在()之内。所以最终做加法操作时，x 的值是 2 。
 *
 * 输入: (let a1 3 b2 (add a1 1) b2)
 * 输出: 4
 * 解释:
 * 变量命名时可以在第一个小写字母后跟随数字.
 *
 *  
 *
 * 注意:
 *
 * 我们给定的 expression 表达式都是格式化后的：表达式前后没有多余的空格，表达式的不同部分(关键字、变量、表达式)之间仅使用一个空格分割，并且在相邻括号之间也没有空格。我们给定的表达式均为合法的且最终结果为整数。
 * 我们给定的表达式长度最多为 2000 (表达式也不会为空，因为那不是一个合法的表达式)。
 * 最终的结果和中间的计算结果都将是一个 32 位整数。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/parse-lisp-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
