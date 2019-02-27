package JavaCode.RandomRecords;

public class number_of_segments_in_a_string {
    class Solution {
        //题意描述不好，题意就是以空格作为单词的分割
        public int countSegments(String s) {

            //求掉前面多余的空格
            s=s.trim();
            /**
             * 特殊情况
             */
            if(s.equals(""))
            {
                System.out.println();
                return 0;
            }
            return s.split(" +").length;
        }
    }
}
/**
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 */