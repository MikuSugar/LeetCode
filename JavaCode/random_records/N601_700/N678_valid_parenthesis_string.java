package JavaCode.random_records.N601_700;

import java.util.Queue;

public class N678_valid_parenthesis_string {
    public boolean checkValidString(String s) {
        if(!check('(',s))return false;
        if(!check(')',new StringBuilder(s).reverse().toString()))return false;
        return true;
    }

    private boolean check(char target, String s) {
        int cnt0=0,cnt1=0;
        for (char c:s.toCharArray())
        {
            if(c==target)++cnt0;
            else if(c=='*')++cnt1;
            else
            {
                if(cnt0>0)--cnt0;
                else if(cnt1>0)--cnt1;
                else return false;
            }
        }
        return true;
    }

}
/**
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * 注意:
 *
 * 字符串大小将在 [1，100] 范围内。
 */
