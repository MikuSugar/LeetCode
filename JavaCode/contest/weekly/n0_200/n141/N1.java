package JavaCode.contest.weekly.n0_200.n141;

public class N1 {
    public void duplicateZeros(int[] arr) {
        int[] res=new int[arr.length];
        int idx=0;
        for (int i:arr)
        {
            if(idx==arr.length)break;
            if(i==0)
            {
                res[idx++]=i;
                if(idx==arr.length)break;
            }
            res[idx++]=i;
        }
        for (int i=0;i<arr.length;i++)
        {
            arr[i]=res[i];
        }
    }
}
/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 *
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Note:
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
