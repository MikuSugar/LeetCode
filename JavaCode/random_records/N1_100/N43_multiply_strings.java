package JavaCode.random_records.N1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟乘法计算
 * 用list存储每一层的结果
 * 最后相加
 */
public class N43_multiply_strings {
    private int max=0;//最长层的长度

    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2))return "0";

        List<String> list=new ArrayList<>(num2.length());//保存每一层的结果
        help(list,new StringBuilder(num1).reverse().toString(),new StringBuilder(num2).reverse().toString(),0);//计算每一层
        StringBuilder res=new StringBuilder();
        help(res,list);//相加每一层
        return res.toString();
    }

    private void help(StringBuilder res, List<String> list) {
        int carry=0;
        for (int i=0;i<max;i++)
        {
            int sum=carry;
            for (String s:list)
            {
                if(i<s.length())
                {
                    sum+=s.charAt(i)-'0';
                }
            }
            res.append(sum%10);
            carry=sum/10;
        }
        if(carry!=0)
        {
            res.append(new StringBuilder(Integer.toString(carry)).reverse().toString());
        }
        res.reverse();
        int i=0;
        while (res.charAt(i)=='0')
        {
            res.deleteCharAt(i);
        }
    }

    private void help(List<String> list, String num1, String num2, int index) {
        if(index==num2.length())return;
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<index;i++)
        {
            sb.append("0");
        }

        int carry=0;
        int m=num2.charAt(index)-'0';
        for (char c:num1.toCharArray())
        {
            int temp=(c-'0')*m+carry;
            sb.append(temp%10);
            carry=temp/10;
        }
        if(carry!=0)sb.append(new StringBuilder(Integer.toString(carry)).reverse().toString());
        max=Math.max(max,sb.length());
        list.add(sb.toString());
        help(list,num1,num2,index+1);
    }
}
/**
 * https://leetcode-cn.com/problems/multiply-strings/
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
