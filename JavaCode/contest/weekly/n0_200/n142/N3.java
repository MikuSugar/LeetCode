package JavaCode.contest.weekly.n0_200.n142;

public class N3 {
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */
    private int res=-1;
    private int target;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len=mountainArr.length();
        this.target=target;
        int topIdx=-1;
        topIdx=findTop(0,len-1,mountainArr);
        if(res!=-1)return res;
        findleft(0,topIdx-1,mountainArr);
        if(res!=-1)return res;
        findRight(topIdx,len-1,mountainArr);
        return res;
    }

    //查找右边
    private void findRight(int i, int j, MountainArray array) {
        int left=i;
        int right=j;
        while (left<=right)
        {
            int mid=(left+right)/2;
            int m=array.get(mid);
            if(m<target)
            {
                right=mid-1;
            }
            else if(m==target)
            {
                res=mid;
                return;
            }
            else
            {
                left=mid+1;
            }
        }
    }

    //查找左边
    private void findleft(int i, int j,MountainArray array) {
        int left=i;
        int right=j;
        while (left<=right)
        {
            int mid=(left+right)/2;
            int m=array.get(mid);
            if(m<target)
            {
                left=mid+1;
            }
            else if(m==target)
            {
                res=mid;
                return;
            }
            else
            {
                right=mid-1;
            }
        }
    }

    //寻找峰顶
    private int findTop(int i, int j, MountainArray mountainArr) {
        int mid=(i+j)/2;
        int l=mountainArr.get(mid - 1);
        if(l==target) {
            res = mid-1;
            return mid;
        }
        int m=mountainArr.get(mid);
        int r=mountainArr.get(mid+1);
        if(l<m&&m>r)
        {
            if(m==target)res=mid;
            return mid;
        }
        else if(l<m&&m<r)
        {
            return findTop(mid,j,mountainArr);
        }
        else
        {
            return findTop(i,mid,mountainArr);
        }
    }

}

//无实际意义，方便写题
interface MountainArray
{
    int get(int index);
    int length();
}
/**
 *（这是一个 交互式问题 ）
 *
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 *
 * 如果不存在这样的下标 index，就请返回 -1。
 *
 *
 *
 * 所谓山脉数组，即数组 A 假如是一个山脉数组的话，需要满足如下条件：
 *
 * 首先，A.length >= 3
 *
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 *
 *
 * 注意：
 *
 * 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。
 *
 * 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：array = [1,2,3,4,5,3,1], target = 3
 * 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * 示例 2：
 *
 * 输入：array = [0,1,2,4,2,1], target = 3
 * 输出：-1
 * 解释：3 在数组中没有出现，返回 -1。
 *
 *
 * 提示：
 *
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 */
