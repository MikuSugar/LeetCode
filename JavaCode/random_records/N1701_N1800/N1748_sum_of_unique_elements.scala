package JavaCode.random_records.N1701_N1800

/**
 * @author mikusugar
 */
object N1748_sum_of_unique_elements {
  def sumOfUnique(nums: Array[Int]): Int = {
    nums.map(_ -> 1).groupBy(_._1).filter(_._2.map(_._2).sum == 1).keys.sum
  }
}
