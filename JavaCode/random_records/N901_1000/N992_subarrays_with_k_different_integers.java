package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/11/18
 */
public class N992_subarrays_with_k_different_integers {
    public int subarraysWithKDistinct(int[] A, int K) {
       MyCollection collection=new MyCollection(A.length+1);
       int left=0,right=0,res=0;
       while (right<A.length)
       {
           collection.add(A[right++]);
           while (collection.size()>K)
           {
               collection.remove(A[left++]);
           }
           int preLeft=left;
           while (collection.size()==K)
           {
               res++;
               collection.remove(A[left++]);
           }
           while (left>preLeft)
           {
               collection.add(A[--left]);
           }
       }
       return res;
    }

    class MyCollection
    {
        private int[] book;
        private int cnt;
        MyCollection(int k)
        {
            book=new int[k];
            cnt=0;
        }
        void add(int x)
        {
            if(++book[x]==1)cnt++;
        }
        void remove(int x)
        {
            if(--book[x]==0)cnt--;
        }
        int size()
        {
            return cnt;
        }
    }
}
/*
给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。

（例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）

返回 A 中好子数组的数目。

 

示例 1：

输出：A = [1,2,1,2,3], K = 2
输入：7
解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
示例 2：

输入：A = [1,2,1,3,4], K = 3
输出：3
解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 

提示：

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
