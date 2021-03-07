package JavaCode.random_records.N1401_1500;

import utils.Parse;

import java.util.*;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/2/4 5:35 下午
 */
public class N1494_parallel_courses_ii {

    public static void main(String[] args) {
        //输入：n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
        //输出：3
        System.out.println(new N1494_parallel_courses_ii().minNumberOfSemesters(
                4,
                Parse.parseToIntTwoArray("[[2,1],[3,1],[1,4]]"),
                2));
    }

    //TODO
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        if(dependencies.length==0)return n/k+(n%k==0?0:1);
        int[] book=new int[n];
        Set<Integer>[] nexts=new Set[n];
        for (int i=0;i<n;i++)nexts[i]=new HashSet<>();

        for (int[] d:dependencies){
            book[d[1]-1]++;
            nexts[d[0]-1].add(d[1]-1);
        }
        int tar=(1<<n)-1;
        Map<String,Integer> dpMap=new HashMap<>();
        int res=slove(0, 0, tar, dpMap, book, nexts, k, new int[n], 0);
        System.out.println(dpMap);
        return res;
    }

    private int slove(int cur, int curK ,final int tar, Map<String, Integer> dpMap, int[] book, Set<Integer>[] nexts, final int k,int[] book2,int step)
    {
        final String key=curK+"$"+cur;
//        System.out.println(step);
        if(step>=book.length)return step;
        if(curK==k){
            for (int i=0;i<book.length;i++){
                book[i]-=book2[i];
            }
            int res=slove(cur, 0, tar, dpMap, book, nexts, k,new int[book.length],step+1);
            for (int i=0;i<book.length;i++){
                book[i]+=book2[i];
            }
            dpMap.put(key,res);
            return res;
        }
        if(cur==tar)return step+(curK>0?1:0);
        int res=dpMap.getOrDefault(key,Integer.MAX_VALUE);
        if(res!=Integer.MAX_VALUE)return res;
        res=Math.min(res,slove(cur,k,tar,dpMap,book,nexts,k,book2,step+1));
        for (int i=0;i<book.length;i++){
           if(book[i]==0&&((cur>>i)&1)==0){
               int nextCur=cur|(1<<i);
               for (int idx:nexts[i])book2[idx]++;
               res=Math.min(res,slove(nextCur,curK+1,tar,dpMap,book,nexts,k,book2,step));
               for (int idx:nexts[i])book2[idx]--;
           }
        }
        dpMap.put(key,res);
        //System.out.println(key+" "+ res+" "+" "+Integer.toBinaryString(cur)+" "+step);
        return res;
    }


}
/*
给你一个整数 n 表示某所大学里课程的数目，编号为 1 到 n ，数组 dependencies 中， dependencies[i] = [xi, yi]  表示一个先修课的关系，也就是课程 xi 必须在课程 yi 之前上。同时你还有一个整数 k 。

在一个学期中，你 最多 可以同时上 k 门课，前提是这些课的先修课在之前的学期里已经上过了。

请你返回上完所有课最少需要多少个学期。题目保证一定存在一种上完所有课的方式。

 

示例 1：



输入：n = 4, dependencies = [[2,1],[3,1],[1,4]], k = 2
输出：3
解释：上图展示了题目输入的图。在第一个学期中，我们可以上课程 2 和课程 3 。然后第二个学期上课程 1 ，第三个学期上课程 4 。
示例 2：



输入：n = 5, dependencies = [[2,1],[3,1],[4,1],[1,5]], k = 2
输出：4
解释：上图展示了题目输入的图。一个最优方案是：第一学期上课程 2 和 3，第二学期上课程 4 ，第三学期上课程 1 ，第四学期上课程 5 。
示例 3：

输入：n = 11, dependencies = [], k = 2
输出：6
 

提示：

1 <= n <= 15
1 <= k <= n
0 <= dependencies.length <= n * (n-1) / 2
dependencies[i].length == 2
1 <= xi, yi <= n
xi != yi
所有先修关系都是不同的，也就是说 dependencies[i] != dependencies[j] 。
题目输入的图是个有向无环图。
通过次数1,564提交次数4,546

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/parallel-courses-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
