package JavaCode.RandomRecords;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class implement_magic_dictionary {

    class MagicDictionary {


        /**
         * 通过map来存储字典
         * key是单词的长度，value是这个长度的单词的集合
         */
        private Map<Integer, List<String>> map;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            map=new HashMap<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for(String s:dict)
            {
                if(map.containsKey(s.length()))
                {
                    List list=map.get(s.length());
                    list.add(s);
                }
                else
                {
                    List<String> list=new ArrayList<>();
                    list.add(s);
                    map.put(s.length(),list);
                }
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {

            if(map.containsKey(word.length()))
            {
                List<String> list=map.get(word.length());
                for(String s:list)
                {
                    if(!s.equals(word))
                    {
                        int cnt=0;
                        for(int i=0;i<s.length();i++)
                        {
                            if(s.charAt(i)!=word.charAt(i))
                            {
                                cnt++;
                            }
                            if(cnt>1)
                            {
                                break;
                            }
                        }
                        if(cnt==1)
                        {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }
}

/**
 * https://leetcode-cn.com/problems/implement-magic-dictionary/
 * 实现一个带有buildDict, 以及 search方法的魔法字典。
 * 对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
 * 对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * 示例 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * 注意:
 * 你可以假设所有输入都是小写字母 a-z。
 * 为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
 * 请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。
 */
