package JavaCode.contest.n133;

import java.util.ArrayList;
import java.util.List;

public class N4 {
    class StreamChecker {

        private Node root;
        private List<Integer> inq;
        public StreamChecker(String[] words) {
            root=new Node();
            inq=new ArrayList<>();
            for (String s:words)
            {
                Node cur=root;
                for (int i=s.length()-1;i>=0;i--)
                {
                    char c=s.charAt(i);
                    if(cur.childs[c-'a']==null)cur.childs[c-'a']=new Node();
                    cur=cur.childs[c-'a'];
                }
                cur.isStart=true;
            }
        }

        public boolean query(char letter) {
            inq.add(letter-'a');
            Node cur=root;
            for (int i=inq.size()-1;i>=0;i--)
            {
                if(cur.childs[inq.get(i)]==null)return false;
                cur=cur.childs[inq.get(i)];
                if(cur.isStart)return true;
            }
            return false;
        }

        class Node
        {
            Node[] childs;
            boolean isStart;
            public Node()
            {
                childs=new Node[26];
                isStart=false;
            }
        }
    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
}
/**
 *  1032. 字符流  显示英文描述
 * 用户通过次数 35
 * 用户尝试次数 135
 * 通过次数 38
 * 提交次数 361
 * 题目难度 Hard
 * 按下述要求实现 StreamChecker 类：
 *
 * StreamChecker(words)：构造函数，用给定的字词初始化数据结构。
 * query(letter)：如果存在某些 k >= 1，可以用查询的最后 k个字符（按从旧到新顺序，包括刚刚查询的字母）拼写出给定字词表中的某一字词时，返回 true。否则，返回 false。
 *
 *
 * 示例：
 *
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // 初始化字典
 * streamChecker.query('a');          // 返回 false
 * streamChecker.query('b');          // 返回 false
 * streamChecker.query('c');          // 返回 false
 * streamChecker.query('d');          // 返回 true，因为 'cd' 在字词表中
 * streamChecker.query('e');          // 返回 false
 * streamChecker.query('f');          // 返回 true，因为 'f' 在字词表中
 * streamChecker.query('g');          // 返回 false
 * streamChecker.query('h');          // 返回 false
 * streamChecker.query('i');          // 返回 false
 * streamChecker.query('j');          // 返回 false
 * streamChecker.query('k');          // 返回 false
 * streamChecker.query('l');          // 返回 true，因为 'kl' 在字词表中。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * 字词只包含小写英文字母。
 * 待查项只包含小写英文字母。
 * 待查项最多 40000 个。
 */
