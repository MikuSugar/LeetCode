package JavaCode.top_interview_questions_medium.math;

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public static void main(String[] args) {
        System.out.println(new FractionToDecimal().new Solution().fractionToDecimal(2,3));
    }

    class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            Map<Long,Integer> map=new HashMap<>();
            StringBuilder sb=new StringBuilder();
            if((long)numerator*denominator<0) sb.append('-');
            long n=Math.abs((long)numerator);
            long d=Math.abs((long)denominator);
            sb.append(n/d);
            n%=d;
            if(n==0)return sb.toString();
            sb.append('.');
            while (n!=0)
            {
                if(map.containsKey(n))
                {
                    sb.insert(map.get(n).intValue(),'(');
                    sb.append(')');
                    return sb.toString();
                }
                map.put(n,sb.length());
                sb.append(n*10/d);
                n=n*10%d;
            }
            return sb.toString();
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/118/
 * 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 */
