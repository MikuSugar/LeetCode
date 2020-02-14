package JavaCode.lcci;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/2/14
 */
public class N17_11_find_closest_lcci {
    public  int findClosest(String[] words, String word1, String word2) {
        List<Integer> list1=new ArrayList<>(words.length/2+5);
        List<Integer> list2=new ArrayList<>(words.length/2+5);
        for (int i=0;i<words.length;i++)
        {
            if(word1.equals(words[i]))list1.add(i);
            else if(word2.equals(words[i]))list2.add(i);
        }
        int res=words.length;
        for (int cur:list1)
        {
            int idx=search(list2,cur);
            res=Math.min(res,Math.abs(cur-list2.get(idx)));
            if(idx>0)res=Math.min(res,Math.abs(cur-list2.get(idx-1)));
        }
        return res;
    }

    private int search(List<Integer> list, int cur) {
        int left=0,right=list.size()-1;
        int res=right;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if(list.get(mid)>=cur)
            {
                res=mid;
                right=mid-1;
            }
            else left=mid+1;
        }
        return res;
    }
}
/*
有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?

示例：

输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
输出：1
提示：

words.length <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-closest-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
