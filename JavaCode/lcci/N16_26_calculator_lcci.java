package JavaCode.lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * author:fangjie
 * time:2020/3/3
 */
public class N16_26_calculator_lcci {

    public int calculate(String s) {
        String[] strs=s.replaceAll(" ","").replaceAll("-", "+-").split("\\+");
        int res=0;
        for (String str:strs)
        {
            res+=slove(str);
        }
        return res;
    }

    private int slove(String str) {
        char[] chars=str.toCharArray();
        int res=1;
        char op='*';
        int start=0;
        for (int i=0;i<chars.length;i++)
        {
            if(chars[i]=='*'||chars[i]=='/')
            {
                int num=Integer.parseInt(str.substring(start, i));
                if(op=='*')res*=num;
                else res/=num;
                op=chars[i];
                start=i+1;
            }
        }
        int num=Integer.parseInt(str.substring(start));
        if(op=='*')res*=num;
        else res/=num;
        return res;
    }
}
/*
给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/calculator-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
