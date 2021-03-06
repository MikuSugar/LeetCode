package JavaCode.contest.weekly.n0_200.n126;
import java.util.ArrayList;
import java.util.List;

public class N1
{
    public List<String> commonChars(String[] A) {
        List<String> res=new ArrayList<>();
        int[] book=new int[26];
        for (char c:A[0].toCharArray())
        {
            book[c-'a']++;
        }

        for(int i=1;i<A.length;i++)
        {
            int[] tbook=new int[26];
            for (char c:A[i].toCharArray())
            {
                tbook[c-'a']++;
            }

            for(int j=0;j<book.length;j++)
            {
                book[j]=Math.min(book[j],tbook[j]);
            }
        }

        for(int i=0;i<book.length;i++)
        {
            for (int j=0;j<book[i];j++)
            {
                char c=(char) (i+'a');
                res.add(Character.toString(c));
            }
        }
        return res;
    }
}
/***
 * https://leetcode-cn.com/contest/weekly-contest-126/problems/find-common-characters/
 * 1002. 查找常用字符
 * 题目难度 Easy
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
