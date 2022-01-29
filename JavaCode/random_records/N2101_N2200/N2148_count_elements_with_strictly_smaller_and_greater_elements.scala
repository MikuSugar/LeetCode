package JavaCode.random_records.N2101_N2200

/**
 * @author mikusugar
 */
object N2148_count_elements_with_strictly_smaller_and_greater_elements {

  def countElements(nums: Array[Int]): Int = {
    val max = nums.max
    val min = nums.min
    nums.filter(_ != min).count(_ != max)
  }

}
/*
给你一个整数数组 nums ，统计并返回在 nums 中同时具有一个严格较小元素和一个严格较大元素的元素数目。

 

示例 1：

输入：nums = [11,7,2,15]
输出：2
解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
示例 2：

输入：nums = [-3,3,3,90]
输出：2
解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 

提示：

1 <= nums.length <= 100
-105 <= nums[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-elements-with-strictly-smaller-and-greater-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */