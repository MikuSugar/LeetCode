package JavaCode.random_records.N601_700

/**
 * author:fangjie
 * time:2019/9/20
 */
class N633_sum_of_square_numbers {
  def judgeSquareSum(c: Int): Boolean = {
      var left=0
      var right=Math.sqrt(c).toInt
      var sum=0
      while (left<=right){
        sum=left*left+right*right
        if(sum>c) right-=1
        else if(sum<c)left+=1
        else return true
      }
      false
  }
}
