package JavaCode.top_interview_questions_easy.strings;

public class eight {
    class Solution {
        private String[] strings=new String[31];
        public String countAndSay(int n) {
           strings[1]="1";
           if(strings[n]!=null)
           {
               return strings[n];
           }
           else
           {
               for(int i=2;i<=n;i++)
               {
                   if(strings[i]!=null)
                   {
                       continue;
                   }
                   char[] s=strings[i-1].toCharArray();
                   char a=' ';
                   int cnt=0;
                   StringBuilder sb=new StringBuilder();
                   for(int k=0;k<s.length;k++)
                   {
                       if(s[k]!=a)
                       {
                           if(cnt!=0)
                           {
                               sb.append(cnt);
                               sb.append(a);
                           }
                           cnt=1;
                           a=s[k];
                       }
                       else if(s[k]==a)
                       {
                           cnt++;
                       }
                   }
                   if(cnt!=0)
                   {
                       sb.append(cnt);
                       sb.append(a);
                   }
                   strings[i]=sb.toString();

               }
           }
           return strings[n];
        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/39/
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 */
