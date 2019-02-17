package JavaCode.top_interview_questions_hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Partition {

    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        this.res=new ArrayList<>();
        if(s==null) return res;

        //动态规划求回文串 dp[i][j]代表i到j是否为回文串
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<dp.length;i++)
        {
            dp[i][i]=true;
        }
        for(int i=0;i<dp.length-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1)) dp[i][i+1]=true;
        }
        for(int i=dp.length-3;i>=0;i--)
        {
            for(int j=i+2;j<dp.length;j++)
            {
                if(dp[i+1][j-1]&&s.charAt(i)==s.charAt(j))
                    dp[i][j]=true;
            }
        }

        dfs(s,0,new ArrayList<Integer>(),dp);
        return res;
    }

    /**
     * 深度优先搜索
     * @param s
     * @param start 搜索开始的位置
     * @param index 储存可以形成回文串的索引
     * @param dp 判断是否是回文串的索引
     */
    private void dfs(String s,int start,List<Integer> index,boolean[][] dp)
    {
        if(start==s.length())
        {
            addRes(s,index);
            return;
        }

        for(int i=start;i<s.length();i++)
        {
            if(dp[start][i])
            {
                index.add(i);
                dfs(s,i+1,index,dp);
                index.remove(index.size()-1);
            }
        }
    }

    /**
     * 通过存储在index的索引对s进行分割并存入最终答案
     * @param s
     * @param index
     */
    private void addRes(String s,List<Integer> index)
    {
        List<String> ans=new ArrayList<>();
        int start=0;
        for(int i=0;i<index.size();i++)
        {
            ans.add(s.substring(start,index.get(i)+1));
            start=index.get(i)+1;
        }
        this.res.add(ans);
    }

}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/58/backtracking/146/
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
