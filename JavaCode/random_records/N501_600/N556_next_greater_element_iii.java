package JavaCode.random_records.N501_600;

import java.util.Arrays;

public class N556_next_greater_element_iii {
    public int nextGreaterElement(int n) {
        char[] number=Integer.toString(n).toCharArray();
        int index;
        for (index=number.length-1;index>0;index--)
        {
            if(number[index]>number[index-1])break;
        }
        if(index==0)return -1;
        int min_index;
        for (min_index=number.length-1;min_index>=index;min_index--)
        {
            if(number[min_index]>number[index-1])break;
        }
        char temp=number[min_index];
        number[min_index]=number[index-1];
        number[index-1]=temp;
        Arrays.sort(number,index,number.length);
        long res=Long.parseLong(new String(number));
        return (int) (res>Integer.MAX_VALUE?-1:res);
    }
}
/**
 * https://leetcode-cn.com/problems/next-greater-element-iii
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 * 示例 1:
 *
 * 输入: 12
 * 输出: 21
 * 示例 2:
 *
 * 输入: 21
 * 输出: -1
 */
