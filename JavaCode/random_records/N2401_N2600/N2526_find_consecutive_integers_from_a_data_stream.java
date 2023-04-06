package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/31 14:39
 * @description N2526_find_consecutive_integers_from_a_data_stream
 */
public class N2526_find_consecutive_integers_from_a_data_stream {
    public static void main(String[] args) {
        //["DataStream", "consec", "consec", "consec", "consec"]
        //[[4, 3], [4], [4], [4], [3]]
        //输出：
        //[null, false, false, true, false]
        final DataStream ds = new DataStream(4, 3);
        CheckUtil.check(ds.consec(4), false);
        CheckUtil.check(ds.consec(4), false);
        CheckUtil.check(ds.consec(4), true);
        CheckUtil.check(ds.consec(3), false);
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
class DataStream {

    private int count;

    private final int value;

    private final int k;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.count = 0;
    }

    public boolean consec(int num) {
        return (count = num == value ? count + 1 : 0) >= k;
    }
}



/*
给你一个整数数据流，请你实现一个数据结构，检查数据流中最后 k 个整数是否 等于 给定值 value 。

请你实现 DataStream 类：

DataStream(int value, int k) 用两个整数 value 和 k 初始化一个空的整数数据流。
boolean consec(int num) 将 num 添加到整数数据流。如果后 k 个整数都等于 value ，返回 true ，否则返回 false 。如果少于 k 个整数，条件不满足，所以也返回 false 。
 

示例 1：

输入：
["DataStream", "consec", "consec", "consec", "consec"]
[[4, 3], [4], [4], [4], [3]]
输出：
[null, false, false, true, false]

解释：
DataStream dataStream = new DataStream(4, 3); // value = 4, k = 3
dataStream.consec(4); // 数据流中只有 1 个整数，所以返回 False 。
dataStream.consec(4); // 数据流中只有 2 个整数
                      // 由于 2 小于 k ，返回 False 。
dataStream.consec(4); // 数据流最后 3 个整数都等于 value， 所以返回 True 。
dataStream.consec(3); // 最后 k 个整数分别是 [4,4,3] 。
                      // 由于 3 不等于 value ，返回 False 。
 

提示：

1 <= value, num <= 109
1 <= k <= 105
至多调用 consec 次数为 105 次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-consecutive-integers-from-a-data-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
