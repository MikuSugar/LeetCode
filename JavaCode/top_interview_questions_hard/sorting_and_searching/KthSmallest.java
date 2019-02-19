package JavaCode.top_interview_questions_hard.sorting_and_searching;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[i].length;j++)
            {

                queue.add(matrix[i][j]);
                if(queue.size()>k)
                {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/59/sorting-and-searching/152/
 * Kth Smallest Element in a Sorted Matrix
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 * 说明:
 * 你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */