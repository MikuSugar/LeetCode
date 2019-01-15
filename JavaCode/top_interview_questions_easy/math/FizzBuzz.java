package JavaCode.top_interview_questions_easy.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz
{
    class Solution {
        public List<String> fizzBuzz(int n) {

            List<String> list=new ArrayList<>();
            for(int i=1;i<=n;i++)
            {
                list.add(fun(i));
            }
            return list;
        }

        String fun(int n)
        {
            if(n%3==0&&n%5==0)
            {
                return "FizzBuzz";
            }
            else if(n%3==0)
            {
                return "Fizz";
            }
            else if(n%5==0)
            {
                return "Buzz";
            }
            else
            {
                return Integer.toString(n);
            }
        }
    }
}

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/60/
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 示例：
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */
