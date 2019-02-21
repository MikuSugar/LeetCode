package JavaCode.top_interview_questions_hard.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {


    private List<Integer> list=new ArrayList<>();
    private int index;
    private int size;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list=new ArrayList<>();
        this.index=0;
        fun(nestedList);
        this.size=list.size();
    }

    //递归扁平化
    private void fun(List<NestedInteger> nestedList )
    {
        for (NestedInteger it:nestedList)
        {
            if(it.isInteger())
            {
                this.list.add(it.getInteger());
            }
            else
            {
                fun(it.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<size;
    }
}

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/61/design/163/
 * 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 *
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */


//方便代码编写
interface NestedInteger
{
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

