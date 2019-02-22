package JavaCode.top_interview_questions_hard.math;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] str_nums=new String[nums.length];
        for (int i=0;i<nums.length;i++)
        {
            str_nums[i]=Integer.toString(nums[i]);
        }

        //3,30 330比303大，也就是"3"+"30"大于"30"+"3"
        Arrays.sort(str_nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return (o2+o1).compareTo(o1+o2);
            }
        });

        //最大为0，所以去除多余的0
        if("0".equals(str_nums[0])) return "0";

        StringBuilder sb=new StringBuilder();
        for (String s:str_nums)
        {
            sb.append(s);
        }
        return sb.toString();
    }

}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/62/math/164/
 *  最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
