package JavaCode.RandomRecords;

import java.util.ArrayList;
import java.util.List;

public class N6_zigzag_conversion
{
    public String convert(String s, int numRows) {
        if(numRows==1) return s;

        List<StringBuilder> rows=new ArrayList<>();
        int n=Math.min(s.length(),numRows);
        for(int i=0;i<n;i++)
        {
            rows.add(new StringBuilder());
        }

        int cur_row=0;//当前函数的指针
        boolean flag=false;//判断当前的方向
        for (char c:s.toCharArray())
        {
            rows.get(cur_row).append(c);
            if(cur_row==0) flag=true;
            else if(cur_row==numRows-1) flag=false;
            //根据方向对行数变换
            cur_row+=flag?1:-1;
        }
        StringBuilder res=new StringBuilder();
        for (StringBuilder row:rows)
        {
            res.append(row);
        }
        return res.toString();
    }
}
/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
