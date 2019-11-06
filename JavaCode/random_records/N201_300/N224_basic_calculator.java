package JavaCode.random_records.N201_300;

/**
 * author:fangjie
 * time:2019/11/6
 */
public class N224_basic_calculator {
    private int idx;
    public int calculate(String s) {
        char[] str=s.toCharArray();
        idx=0;
        return slove(str);
    }

    private int slove(char[] str) {
        int res=0;
        int sign=1;
        while (idx<str.length)
        {
            if(str[idx]=='(')
            {
                idx++;
                res+=sign*slove(str);
            }
            else if(str[idx]==')')
            {
                idx++;
                return res;
            }
            else if(str[idx]==' ')idx++;
            else if(str[idx]=='+')
            {
                idx++;
                sign=1;
            }
            else if(str[idx]=='-')
            {
                idx++;
                sign=-1;
            }
            else if(Character.isDigit(str[idx]))
            {
                res+=sign*getNum(str);
            }
        }
        return res;
    }

    private int getNum(char[] str) {
        StringBuilder sb=new StringBuilder();
        while (idx<str.length&&Character.isDigit(str[idx]))sb.append(str[idx++]);
        return Integer.parseInt(sb.toString());
    }
}
/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

示例 1:

输入: "1 + 1"
输出: 2
示例 2:

输入: " 2-1 + 2 "
输出: 3
示例 3:

输入: "(1+(4+5+2)-3)+(6+8)"
输出: 23
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
