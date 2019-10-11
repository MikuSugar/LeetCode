package JavaCode.random_records.N701_800;

import java.util.PriorityQueue;

/**
 * author:fangjie
 * time:2019/10/11
 */
public class N767_reorganize_string {

    public String reorganizeString(String S) {
        int[] book=new int[26];
        for (char c:S.toCharArray())book[c-'a']++;
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1, o2)->o2[0]-o1[0]);
        for (int i=0;i<book.length;i++)
        {
            if(book[i]>0)pq.add(new int[]{book[i],i});
        }
        char[] res=new char[S.length()];
        int idx=0;
        while (pq.size()>1)
        {
            int[] n1=pq.poll();
            int[] n2=pq.poll();
            res[idx++]=(char)(n1[1]+'a');
            res[idx++]=(char)(n2[1]+'a');
            n1[0]--;
            n2[0]--;
            if(n1[0]>0)pq.add(n1);
            if(n2[0]>0)pq.add(n2);
        }
        if(pq.isEmpty())return new String(res);
        int[] poll=pq.poll();
        if(poll[0]!=1)return "";
        res[idx++]=(char)(poll[1]+'a');
        return new String(res);
    }
}
/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorganize-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
