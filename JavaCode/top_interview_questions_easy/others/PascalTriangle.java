package JavaCode.top_interview_questions_easy.others;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle
{
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> lists=new ArrayList<>();

            if(numRows>=1)
            {
                List<Integer> list = new ArrayList<>();
                list.add(1);
                lists.add(list);

                for(int i=2;i<=numRows;i++)
                {
                    List<Integer> list1=new ArrayList<>();
                    list1.add(1);
                    List<Integer> list2=lists.get(i-2);

                    for(int j=0;j<list2.size()-1;j++)
                    {
                        list1.add(list2.get(j)+list2.get(j+1));
                    }
                    list1.add(1);
                    lists.add(list1);
                }
            }
            return lists;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/67/
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
