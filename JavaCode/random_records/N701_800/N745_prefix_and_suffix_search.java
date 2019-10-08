package JavaCode.random_records.N701_800;

import scala.collection.mutable.StringBuilder;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/8
 */
public class N745_prefix_and_suffix_search {

    class WordFilter {
        public WordFilter(String[] words) {
            pre=new Node();
            suff=new Node();
            Map<String,Integer> map=new HashMap<>();
            for (int i=0;i<words.length;i++)
            {
                map.put(words[i],i);
            }
            for (Map.Entry<String,Integer> e:map.entrySet())
            {
                String s=e.getKey();
                bulidTree(pre,s.toCharArray(),0,e.getValue());
                bulidTree(suff,new StringBuilder(s).reverse().toString().toCharArray(),0,e.getValue());
            }
        }

        public int f(String prefix, String suffix) {
            List<Integer> pre=serach(prefix.toCharArray(), 0, this.pre);
            List<Integer> suff=serach(new StringBuilder(suffix).reverse().toString().toCharArray(), 0, this.suff);
            Set<Integer> set=new HashSet<>();
            set.addAll(pre);
            int res=-1;
            for (int i:suff)
            {
                if(!set.contains(i))continue;
                res=Math.max(res,i);
            }
            return res;
        }

        private List<Integer> serach(char[] strs,int i,Node root)
        {
            if(strs.length==i)return root.idxs;
            Node next=root.nexts[strs[i]-'a'];
            if(next==null)return new ArrayList<>();
            return serach(strs,i+1,next);
        }

        private Node pre;
        private Node suff;

        class Node
        {
            List<Integer> idxs;
            Node[] nexts;
            Node()
            {
                nexts=new Node[26];
                idxs=new ArrayList<>();
            }
        }
        private void bulidTree(Node root,char[] strs,int i,final int idx)
        {
            root.idxs.add(idx);
            if(i==strs.length)return;
            if(root.nexts[strs[i]-'a']==null)root.nexts[strs[i]-'a']=new Node();
            bulidTree(root.nexts[strs[i]-'a'],strs,i+1,idx);
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
/**
 * 给定多个 words，words[i] 的权重为 i 。
 *
 * 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。
 *
 * 例子:
 *
 * 输入:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // 返回 0
 * WordFilter.f("b", "") // 返回 -1
 * 注意:
 *
 * words的长度在[1, 15000]之间。
 * 对于每个测试用例，最多会有words.length次对WordFilter.f的调用。
 * words[i]的长度在[1, 10]之间。
 * prefix, suffix的长度在[0, 10]之前。
 * words[i]和prefix, suffix只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prefix-and-suffix-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
