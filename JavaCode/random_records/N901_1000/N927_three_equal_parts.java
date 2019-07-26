package JavaCode.random_records.N901_1000;


public class N927_three_equal_parts {
    public int[] threeEqualParts(int[] A) {
        int[] res={-1,-1};
        int[] book=new int[A.length];
        int cnt=0,idx=0;
        for (int i=0;i<A.length;i++)
        {
            if(A[i]==1)
            {
                cnt++;
                book[idx++]=i;
            }
        }
        if(cnt==0)
        {
            res[0]=0;
            res[1]=A.length-1;
            return res;
        }
        if(cnt%3!=0)return res;
        int len=cnt/3;
        for (int i=1;i<len;i++)
        {
            int tar=book[i]-book[i-1];
            if(book[i+len]-book[i+len-1]!=tar||book[i+2*len]-book[i+2*len-1]!=tar)return res;
        }
       //最后一段尾巴零的个数
        int tar=A.length-1-book[cnt-1];
        if(tar<=book[len]-book[len-1]-1&&tar<=book[2*len]-book[2*len-1]-1)
        {
            res[0]=book[len-1]+tar;
            res[1]=book[2*len-1]+tar+1;
        }
        return res;

    }
}
/**
 * 给定一个由 0 和 1 组成的数组 A，将数组分成 3 个非空的部分，使得所有这些部分表示相同的二进制值。
 *
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 *
 * A[0], A[1], ..., A[i] 组成第一部分；
 * A[i+1], A[i+2], ..., A[j-1] 作为第二部分；
 * A[j], A[j+1], ..., A[A.length - 1] 是第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 *
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,0,1,0,1]
 * 输出：[0,3]
 * 示例 2：
 *
 * 输出：[1,1,0,1,1]
 * 输出：[-1,-1]
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 30000
 * A[i] == 0 或 A[i] == 1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
