package JavaCode.top_interview_questions_hard.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreakTwo {
    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict=new HashSet<>();
        dict.addAll(wordDict);

        //动态规划判断是否可以切分
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i=1;i<=s.length();i++)
        {
            for (int j=0;j<i;j++)
            {
                if(dp[j]&&dict.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }

        List<String> res=new ArrayList<>();
        if(!dp[s.length()])return res;
        dfs(s,dict,new ArrayList<String>(),res,0,dp);
        return res;

    }

    /**
     * 深度优先搜索
     * @param s
     * @param dict 字典
     * @param word 储存已经拆分的单词
     * @param res 结果集
     * @param index 索引
     * @param dp 能否切分依据
     */
    private void dfs(String s, Set<String> dict, List<String> word, List<String> res, int index, boolean[] dp)
    {
        int len=s.length();
        if(index==len)//到末尾了，将结果添加到res
        {
            StringBuilder sb=new StringBuilder();
            for (String str:word)
            {
                sb.append(str);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }
        if(!dp[index])//剪枝操作
        {
            return;
        }
        for (int i=index;i<len;i++)
        {
            String temp=s.substring(index,i+1);
            if(dict.contains(temp))
            {
                word.add(temp);
                dfs(s,dict,word,res,i+1,dp);
                word.remove(word.size()-1);
            }
        }
    }

}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/60/dynamic-programming/158/
 * 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 */
