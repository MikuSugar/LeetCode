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
