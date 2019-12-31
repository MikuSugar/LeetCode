package JavaCode.contest.biweekly_n16;

/**
 * author:fangjie
 * time:2019/12/30
 */
public class N1 {
    public int[] replaceElements(int[] arr) {
        int[] res=new int[arr.length];
        res[arr.length-1]=-1;
        for (int i=arr.length-2;i>=0;i--)
        {
            res[i]=Math.max(res[i+1],arr[i+1]);
        }
        return res;
    }
}
/*
给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。

完成所有替换操作后，请你返回这个数组。

 

示例：

输入：arr = [17,18,5,4,6,1]
输出：[18,6,6,6,1,-1]
 

提示：

1 <= arr.length <= 10^4
1 <= arr[i] <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
