package JavaCode.top_interview_questions_hard.trees_and_graphs;

import java.util.*;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //bfs
        Map<String,Integer> map=new HashMap<>();//已走过的节点和层数
        Queue<String> queue=new LinkedList<>();
        map.put(beginWord,1);
        queue.add(beginWord);

        while (!queue.isEmpty())
        {
            String word=queue.poll();
            int level=map.get(word);
            Iterator<String> it=wordList.iterator();
            while (it.hasNext())
            {
                String temp=it.next();
                int cnt=0;
                for(int i=0;i<temp.length();i++)
                {
                    if(word.charAt(i)!=temp.charAt(i))
                    {
                        cnt++;
                    }
                    if(cnt>1) break;
                }
                if(cnt==1)
                {
                    if(temp.equals(endWord))
                    {
                        return level+1;
                    }
                    it.remove();
                    map.put(temp,level+1);
                    queue.add(temp);
                }
            }
        }
        return 0;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/137/
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
