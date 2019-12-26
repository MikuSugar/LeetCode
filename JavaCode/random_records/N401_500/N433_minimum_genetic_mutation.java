package JavaCode.random_records.N401_500;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * author:fangjie
 * time:2019/12/24
 */
public class N433_minimum_genetic_mutation {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end))return 0;
        Set<String> set=new HashSet<>(bank.length*2);
        Set<String> used=new HashSet<>(bank.length*2);
        for (String s:bank)set.add(s);
        Queue<String> queue=new LinkedList<>();
        queue.add(start);
        used.add(start);
        int level=0;
        while (!queue.isEmpty())
        {
            level++;
            int size=queue.size();
            while (size-->0)
            {
                String cur=queue.poll();
                char[] s=cur.toCharArray();
                for (int i=0;i<s.length;i++)
                {
                    for (char c:NEXTS)
                    {
                        if(s[i]==c)continue;
                        char pre=s[i];
                        s[i]=c;
                        String temp=new String(s);
                        s[i]=pre;
                        if(set.contains(temp)&&!used.contains(temp))
                        {
                            if(temp.equals(end))return level;
                            queue.add(temp);
                            used.add(temp);
                        }
                    }
                }
            }
        }
        return -1;
    }
    final static char[] NEXTS={'A','C','G','T'};
}
/*
一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。

假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。

例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。

与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。

现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。

注意:

起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
所有的目标基因序列必须是合法的。
假定起始基因序列与目标基因序列是不一样的。
示例 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

返回值: 1
示例 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

返回值: 2
示例 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

返回值: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
