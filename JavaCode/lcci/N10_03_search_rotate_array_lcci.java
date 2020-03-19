package JavaCode.lcci;

/**
 * author:fangjie
 * time:2020/3/19
 */
public class N10_03_search_rotate_array_lcci {
    public int search(int[] arr, int target) {
        return search(arr,target,0,arr.length-1);
    }

    private int search(int[] arr, int target, int left, int right) {
        if(left>right)return -1;
        int mid=(left+right)/2;
        int res=search(arr, target, left, mid-1);
        if(res!=-1)return res;
        if(arr[mid]==target) return mid;
        return search(arr,target,mid+1,right);
    }
}
/*
搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。

示例1:

 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 输出: 8（元素5在该数组中的索引）
示例2:

 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 输出：-1 （没有找到）
提示:

arr 长度范围在[1, 1000000]之间
 */
