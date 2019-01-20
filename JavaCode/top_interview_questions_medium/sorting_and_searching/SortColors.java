package JavaCode.top_interview_questions_medium.sorting_and_searching;

public class SortColors
{
    class Solution
    {
        public void sortColors(int[] nums)
        {
            fun1(nums);
        }

        //两趟扫描
        void fun0(int[] nums)
        {
            int[] book=new int[3];
            for(int i:nums)
            {
                book[i]++;
            }

            int cnt=0;
            for(int i=0;i<book.length;i++)
            {
                for(int j=0;j<book[i];j++)
                {
                    nums[cnt]=i;
                    cnt++;
                }
            }
        }

        /**
         * 一趟扫描
         * 三个指针
         * @param nums
         */
        void fun1(int[] nums)
        {
            int zero_index=0;//当前0结尾的下一个
            int index=0;//当前扫描的指针
            int two_index=nums.length-1;//当前2开始前的指针
            while (index<=two_index)
            {
                if(nums[index]==0)
                {
                    nums[index]=nums[zero_index];
                    nums[zero_index]=0;
                    zero_index++;
                    index=zero_index;
                }
                else if(nums[index]==1)
                {
                   index++;
                }
                else if(nums[index]==2)
                {
                   nums[index]=nums[two_index];
                   nums[two_index]=2;
                   two_index--;
                }
            }
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/96/
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
