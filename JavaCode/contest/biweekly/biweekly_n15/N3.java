package JavaCode.contest.biweekly.biweekly_n15;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/12/14
 */
public class N3 {
    public static void main(String[] args) {
        CombinationIterator abc=new N3().new CombinationIterator("chp", 1);
        System.out.println(abc.list);
    }
    class CombinationIterator {
        private List<String> list=new ArrayList<>(1000);
        private int idx;
        public CombinationIterator(String characters, int combinationLength) {
            char[] strs=characters.toCharArray();
            build(strs,combinationLength,0,new StringBuilder());
            idx=0;
        }

        private void build(char[] str, int len, int idx, StringBuilder sb) {
            if(sb.length()==len)
            {
                list.add(sb.toString());
                return;
            }
            for (int i=idx;i<str.length;i++)
            {
                sb.append(str[i]);
                build(str,len,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }

        public String next() {
           return list.get(idx++);
        }

        public boolean hasNext() {
           return idx<list.size();
        }
    }

/*
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
/*
请你设计一个迭代器类，包括以下内容：

一个构造函数，输入参数包括：一个 有序且字符唯一 的字符串 characters（该字符串只包含小写英文字母）和一个数字 combinationLength 。
函数 next() ，按 字典序 返回长度为 combinationLength 的下一个字母排列。
函数 hasNext() ，只有存在长度为 combinationLength 的下一个字母排列时，才返回 True；否则，返回 False。


示例：

CombinationIterator iterator = new CombinationIterator("abc", 2); // 创建迭代器 iterator

iterator.next(); // 返回 "ab"
iterator.hasNext(); // 返回 true
iterator.next(); // 返回 "ac"
iterator.hasNext(); // 返回 true
iterator.next(); // 返回 "bc"
iterator.hasNext(); // 返回 false


提示：

1 <= combinationLength <= characters.length <= 15
每组测试数据最多包含 10^4 次函数调用。
题目保证每次调用函数 next 时都存在下一个字母排列。

 */
