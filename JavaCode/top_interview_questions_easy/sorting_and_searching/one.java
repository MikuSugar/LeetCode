package JavaCode.top_interview_questions_easy.sorting_and_searching;

import java.util.Arrays;

public class one {
    class Solution
    {
        public void merge(int[] nums1, int m, int[] nums2, int n)
        {
            int i = 0;
            int j = 0;
            int k = 0;
            int[] temps = new int[nums1.length];
            while (true)
            {
                if (i < m && j < n)
                {
                    if (nums1[i] < nums2[j])
                    {
                        temps[k] = nums1[i];
                        i++;
                    }
                    else
                    {
                        temps[k] = nums2[j];
                        j++;
                    }
                    k++;
                }
                else if (i == m)
                {
                    for (; j < n; k++, j++)
                    {
                        temps[k] = nums2[j];
                    }
                    break;
                }
                else if (j == n)
                {
                    for (; i < m; i++, k++)
                    {
                        temps[k] = nums1[i];
                    }
                }
            }
            System.arraycopy(temps, 0, nums1, 0, nums1.length);
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/8/sorting-and-searching/52/
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
