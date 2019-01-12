package JavaCode.top_interview_questions_easy.strings;

import java.util.HashMap;
import java.util.Map;

public class three {
    class Solution {


        /**
         * 索引和出现次数封装类
         */
        class Index{
            int cnt;
            int index;

            public Index(int index)
            {
                this.index=index;
                this.cnt=1;
            }

            void addCnt()
            {
                this.cnt++;
            }
        }

        public int firstUniqChar(String s) {
            Map<Integer,Index> map=new HashMap<>();
            for(int i=0;i<s.length();i++)
            {
                int x=s.charAt(i);
                if(map.containsKey(x))
                {
                    map.get(x).addCnt();
                }
                else
                {
                    map.put(x,new Index(i));
                }
            }

            int index=Integer.MAX_VALUE;
            for(int key:map.keySet())
            {
                Index i=map.get(key);
                if(i.cnt==1&&i.index<index)
                {
                    index=i.index;
                }
            }

            if(index==Integer.MAX_VALUE)
            {
                return -1;
            }
            return index;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
