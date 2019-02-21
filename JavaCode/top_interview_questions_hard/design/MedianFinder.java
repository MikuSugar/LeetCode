package JavaCode.top_interview_questions_hard.design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private int len;
    private PriorityQueue<Integer> queue1;
    private PriorityQueue<Integer> queue2;

    /** initialize your data structure here. */
    public MedianFinder() {
        queue1=new PriorityQueue<>();
        queue2=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        len=0;
    }

    public void addNum(int num) {
        if(len%2==0)
        {
            queue1.add(num);
            queue2.add(queue1.poll());
        }
        else
        {
            queue2.add(num);
            queue1.add(queue2.poll());
        }
        len++;
    }

    public double findMedian() {
        if(len%2==0)
        {
            return (queue1.peek()+queue2.peek())*1.0/2.0;
        }
        else
        {
            return queue2.peek();
        }
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
