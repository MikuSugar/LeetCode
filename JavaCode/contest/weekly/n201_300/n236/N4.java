package JavaCode.contest.weekly.n201_300.n236;

import java.util.*;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/4/11 11:03 上午
 */
public class N4 {
    //["MKAverage","addElement","addElement","calculateMKAverage","addElement","addElement","calculateMKAverage","addElement","addElement","calculateMKAverage","addElement"]
    //[[3,1],[58916],[61899],[],[85406],[49757],[],[27520],[12303],[],[63945]]
    public static void main(String[] args) {
        MKAverage mkAverage = new MKAverage(3, 1);
        mkAverage.addElement(58916);
        mkAverage.addElement(61899);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(85406);
        mkAverage.addElement(49757);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(27520);
        mkAverage.addElement(12303);
        System.out.println(mkAverage.calculateMKAverage());
        mkAverage.addElement(63945);
    }
}
class MKAverage {

    private final int m;
    private final int k;

    private int sum;
    private int size;

    private Queue<int[]> queue;
    private int minSum;
    private TreeSet<int[]> min;
    private TreeSet<int[]> minT;

    private int maxSum;
    private TreeSet<int[]> max;
    private TreeSet<int[]> maxT;


    public MKAverage(int m, int k) {
        this.m=m;
        this.k=k;
        this.sum=this.maxSum=this.minSum=this.size=0;
        this.queue=new ArrayDeque<>();
        min=new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }
        });
        minT=new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }
        });
        max=new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o2[0],o1[0]);
            }
        });
        maxT=new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o2[0],o1[0]);
            }
        });
    }

    public void addElement(int num) {
        size++;
        int[] cur = {num, size};


        sum+=num;
        queue.add(cur);
        if(queue.size()>m){
            int[] c = queue.poll();
            sum-=c[0];
            minT.remove(c);
            if(min.remove(c))minSum-=c[0];
            maxT.remove(c);
            if(max.remove(c))maxSum-=c[0];

        }

        while (min.size()<k&&!minT.isEmpty()){
            int[] c = minT.pollFirst();
            minSum+=c[0];
            min.add(c);
        }
        min.add(cur);
        minSum+=num;
        while (min.size()>k){
            int[] c = min.pollLast();
            minSum-=c[0];
            minT.add(c);
        }
        while (max.size()<k&&!maxT.isEmpty()){
            int[] c=maxT.pollFirst();
            maxSum+=c[0];
            max.add(c);
        }
        max.add(cur);
        maxSum+=num;
        while (max.size()>k){
            int[] c=max.pollLast();
            maxSum-=c[0];
            maxT.add(c);
        }

    }

    public int calculateMKAverage() {
        if(queue.size()<m)return -1;
        System.out.println(Arrays.toString(new int[]{sum,minSum,maxSum}));
        return (sum-minSum-maxSum)/(m-2*k);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
/*
给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。

MK 平均值 按照如下步骤计算：

如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。
从这个容器中删除最小的 k 个数和最大的 k 个数。
计算剩余元素的平均值，并 取整到最近的整数 。
请你实现 MKAverage 类：

MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。
void addElement(int num) 往数据流中插入一个新的元素 num 。
int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 取整到最近的整数 。


示例 1：

输入：
["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", "calculateMKAverage", "addElement", "addElement", "addElement", "calculateMKAverage"]
[[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
输出：
[null, null, null, -1, null, 3, null, null, null, 5]

解释：
MKAverage obj = new MKAverage(3, 1);
obj.addElement(3);        // 当前元素为 [3]
obj.addElement(1);        // 当前元素为 [3,1]
obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
obj.addElement(10);       // 当前元素为 [3,1,10]
obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
                          // 删除最小以及最大的 1 个元素后，容器为 [3]
                          // [3] 的平均值等于 3/1 = 3 ，故返回 3
obj.addElement(5);        // 当前元素为 [3,1,10,5]
obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
                          // 删除最小以及最大的 1 个元素后，容器为 [5]
                          // [5] 的平均值等于 5/1 = 5 ，故返回 5


提示：

3 <= m <= 105
1 <= k*2 < m
1 <= num <= 105
addElement 与 calculateMKAverage 总操作次数不超过 105 次。
 */
