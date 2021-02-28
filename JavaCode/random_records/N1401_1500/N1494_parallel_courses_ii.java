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
        //12
        //[[11,10],[6,3],[2,5],[9,2],[4,12],[8,7],[9,5],[6,2],[7,2],[7,4],[9,3],[11,1],[4,3]]
        //3
        System.out.println(new N1494_parallel_courses_ii().minNumberOfSemesters(12,
                Parse.parseToIntTwoArray("[[11,10],[6,3],[2,5],[9,2],[4,12],[8,7],[9,5],[6,2],[7,2],[7,4],[9,3],[11,1],[4,3]]"),
                3));
    }

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {

        int[] book=new int[n];
        Set<Integer>[] nexts=new Set[n];
        for (int i=0;i<n;i++)nexts[i]=new HashSet<>();

        for (int[] d:dependencies){
            book[d[1]-1]++;
            nexts[d[0]-1].add(d[1]-1);
        }

        int status=(1<<(n+1))-1;
        Map<String,Integer> map=new HashMap<>();

        return slove(status,k,k,book,nexts,map);
    }

    private int slove(int status, int cur, final int k, final int[] book,final Set<Integer>[] nexts,final Map<String, Integer> map) {
        String key=status+"#"+cur;
        if(map.containsKey(key))return map.get(key);
        if(cur==0)return 1+slove(status,k,k,book,nexts,map);
        if(status==0)return 0;

        int res=Integer.MAX_VALUE;
        for (int i=0;i<book.length;i++){
            if(book[i]==0&&1==((status >> i)&1)){

            }
        }
        //TODO
        return 0;
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
