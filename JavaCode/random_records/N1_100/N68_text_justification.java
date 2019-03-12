package JavaCode.random_records.N1_100;

import java.util.ArrayList;
import java.util.List;

public class N68_text_justification
{

    public static void main(String[] args)
    {
        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
        List<String> list=new N68_text_justification().fullJustify(words,16);
        for (String s:list)
        {
            System.out.println(s);
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int left;
        int right;
        for (int i=0;i<words.length;)
        {
            left=i;
            right=left+1;
            int cnt=words[left].length();
            //贪心
            while (right<words.length)
            {
                cnt+=1+words[right].length();
                if(cnt<=maxWidth){right++;}
                else
                {
                    cnt-=1+words[right].length();
                    right--;
                    break;
                }
            }
            right=right==words.length?right-1:right;
            //一个单词一行和最后一行左对齐
            if(right==words.length-1||left==right)
            {
                StringBuilder sb=new StringBuilder();
                for (int j=left;j<=right;j++)
                {
                    sb.append(words[j]+" ");
                }
                sb.deleteCharAt(sb.length()-1);
                while (sb.length()<maxWidth)
                {
                    sb.append(" ");
                }
                res.add(sb.toString());
            }
            //一般情况
            else
            {
                int space_cnt=maxWidth-cnt+(right-left);
                int minspace=space_cnt/(right-left);//单词之间的最少空格数
                int maxspace_index=space_cnt%(right-left);//余下的空格数
                StringBuilder sb=new StringBuilder();
                for(int j=left;j<right;j++)
                {
                    sb.append(words[j]);
                    for (int k=0;k<minspace;k++)
                    {
                        sb.append(" ");
                    }
                    if(j-left<maxspace_index)
                    {
                        sb.append(" ");
                    }

                }
                sb.append(words[right]);
                res.add(sb.toString());
            }
            i=right+1;
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/text-justification/
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
