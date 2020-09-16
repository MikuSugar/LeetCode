package JavaCode.contest.fall_2020

import scala.collection.mutable


/**
 * author: fangjie 
 * email: syfangjie@live.cn
 * date: 2020/9/16 10:12 上午
 */
object N4 {
    def main(args: Array[String]): Unit = {
        //980632
        //2933
        //5626
        //[6061,5876,6528,6680,5580,2772,6619,7365,9474,2136]
        //[1792,6103,9708,6519,2305,8327,7393,9533,269,7938]
        println(busRapidTransit(980632,2933,5626
            ,Array(6061,5876,6528,6680,5580,2772,6619,7365,9474,2136)
            ,Array(1792,6103,9708,6519,2305,8327,7393,9533,269,7938)))
    }
    import scala.collection.mutable.HashMap
    private val MOD:BigInt=(1e9+7).asInstanceOf[Int]

    def busRapidTransit(target: Int, inc: Int, dec: Int, jump: Array[Int], cost: Array[Int]): Int = {
        val map = new mutable.HashMap[Int, BigInt]()
        (slove(target, inc, dec, jump, cost, map)%MOD).intValue
    }

    def slove(tar: Int, inc: Int, dec: Int, jump: Array[Int], cost: Array[Int], map: HashMap[Int, BigInt]) :BigInt= {
        if(tar==0) 0
        else if(tar==1) inc
        else if(map.contains(tar))map(tar)
        else {
            var res:BigInt=BigInt(tar)*BigInt(inc)
            for (i<-jump.indices){
                val next: Int =tar/jump(i)
                val m:Int =tar%jump(i)
                val costNum = BigInt(cost(i))
                if(m==0){
                    res=min(res,slove(next,inc, dec, jump, cost, map)+costNum)
                }
                else {
                    res=min(res,slove(next,inc, dec, jump, cost, map)+costNum+BigInt(inc)*m)
                    res=min(res,slove(next+1,inc, dec, jump, cost, map)+costNum+BigInt(jump(i)-m)*BigInt(dec))
                }
            }

            map.put(tar,res)
            res
        }
    }

    def min(a:BigInt,b:BigInt):BigInt={
        if(a>b)b
        else a
    }
}
/*
小扣打算去秋日市集，由于游客较多，小扣的移动速度受到了人流影响：

小扣从 x 号站点移动至 x + 1 号站点需要花费的时间为 inc；
小扣从 x 号站点移动至 x - 1 号站点需要花费的时间为 dec。
现有 m 辆公交车，编号为 0 到 m-1。小扣也可以通过搭乘编号为 i 的公交车，从 x 号站点移动至 jump[i]*x 号站点，耗时仅为 cost[i]。小扣可以搭乘任意编号的公交车且搭乘公交次数不限。

假定小扣起始站点记作 0，秋日市集站点记作 target，请返回小扣抵达秋日市集最少需要花费多少时间。由于数字较大，最终答案需要对 1000000007 (1e9 + 7) 取模。

注意：小扣可在移动过程中到达编号大于 target 的站点。

示例 1：

输入：target = 31, inc = 5, dec = 3, jump = [6], cost = [10]

输出：33

解释：
小扣步行至 1 号站点，花费时间为 5；
小扣从 1 号站台搭乘 0 号公交至 6 * 1 = 6 站台，花费时间为 10；
小扣从 6 号站台步行至 5 号站台，花费时间为 3；
小扣从 5 号站台搭乘 0 号公交至 6 * 5 = 30 站台，花费时间为 10；
小扣从 30 号站台步行至 31 号站台，花费时间为 5；
最终小扣花费总时间为 33。

示例 2：

输入：target = 612, inc = 4, dec = 5, jump = [3,6,8,11,5,10,4], cost = [4,7,6,3,7,6,4]

输出：26

解释：
小扣步行至 1 号站点，花费时间为 4；
小扣从 1 号站台搭乘 0 号公交至 3 * 1 = 3 站台，花费时间为 4；
小扣从 3 号站台搭乘 3 号公交至 11 * 3 = 33 站台，花费时间为 3；
小扣从 33 号站台步行至 34 站台，花费时间为 4；
小扣从 34 号站台搭乘 0 号公交至 3 * 34 = 102 站台，花费时间为 4；
小扣从 102 号站台搭乘 1 号公交至 6 * 102 = 612 站台，花费时间为 7；
最终小扣花费总时间为 26。

提示：

1 <= target <= 10^9
1 <= jump.length, cost.length <= 10
2 <= jump[i] <= 10^6
1 <= inc, dec, cost[i] <= 10^6


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/meChtZ
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
