package JavaCode.random_records.N1301_1400

/**
 * author:fangjie
 * time:2020/1/13
 */
object N1313_decompress_run_length_encoded_list {
    def decompressRLElist(nums: Array[Int]): Array[Int] = {
        nums.sliding(2,2).flatMap(v=>for (_ <- 0 until v(0)) yield v(1)).toArray
    }
}
/*
给你一个以行程长度编码压缩的整数列表 nums 。

考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。

请你返回解压后的列表。

 

示例：

输入：nums = [1,2,3,4]
输出：[2,4,4,4]
 

提示：

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decompress-run-length-encoded-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */