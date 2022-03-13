package JavaCode.contest.other.cnunionpay_2022spring;

import java.util.*;

/**
 * @author mikusugar
 */
public class N2 {
}

class DiscountSystem {

    static class Act {
        int actId;
        int priceLimit;
        int discount;
        int number;
        int userLimit;

        public Act(int actId, int priceLimit, int discount, int number, int userLimit) {
            this.actId = actId;
            this.priceLimit = priceLimit;
            this.discount = discount;
            this.number = number;
            this.userLimit = userLimit;
        }
    }

    private final Map<Integer, Act> actMap;
    private final Map<Integer, Map<Integer, Integer>> userMap;

    public DiscountSystem() {
        actMap = new HashMap<>(2000);
        userMap = new HashMap<>(2000);
    }

    public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        actMap.put(actId, new Act(actId, priceLimit, discount, number, userLimit));
    }

    public void removeActivity(int actId) {
        actMap.remove(actId);
    }


    public int consume(int userId, int cost) {
        if (!userMap.containsKey(userId)) userMap.put(userId, new HashMap<>());
        final Map<Integer, Integer> map = userMap.get(userId);
        List<Act> canList = new ArrayList<>();
        for (Act act : actMap.values()) {
            if (act.priceLimit <= cost && act.number > 0) {
                if (map.getOrDefault(act.actId, 0) < act.userLimit) {
                    canList.add(act);
                }
            }
        }
        canList.sort((o1, o2) -> {
            if (o1.discount != o2.discount) return Integer.compare(o1.discount, o2.discount);
            else return Integer.compare(o2.actId, o1.actId);
        });
        if (canList.size() == 0) return cost;
        else {
            final Act act = canList.get(canList.size() - 1);
            act.number--;
            if (act.number == 0) actMap.remove(act.actId);
            map.put(act.actId, map.getOrDefault(act.actId, 0) + 1);
            return cost - act.discount;
        }
    }
}

/**
 * Your DiscountSystem object will be instantiated and called as such:
 * DiscountSystem obj = new DiscountSystem();
 * obj.addActivity(actId,priceLimit,discount,number,userLimit);
 * obj.removeActivity(actId);
 * int param_3 = obj.consume(userId,cost);
 */
/*
「云闪付」作为各方联手打造的全新移动端统一入口，致力成为消费者省钱省心的移动支付管家。
请你设计一个「云闪付」优惠活动管理系统 DiscountSystem，具体功能如下：

AddActivity(int actId, int priceLimit, int discount, int number, int userLimit) -- 表示创建编号为 actId 的优惠减免活动：

单笔消费的原价不小于 priceLimit 时，可享受 discount 的减免
每个用户最多参与该优惠活动 userLimit 次
该优惠活动共有 number 数量的参加名额
RemoveActivity(actId) -- 表示结束编号为 actId 的优惠活动

Consume(int userId, int cost) -- 表示用户 userId 产生了一笔原价为 cost 的消费。请返回用户的实际支付金额。

单次消费最多可参加一份优惠活动
若可享受优惠减免，则 「支付金额 = 原价 - 优惠减免」
若同时满足多个优惠活动时，则优先参加优惠减免最大的活动
注：若有多个优惠减免最大的活动，优先参加 actId 最小的活动

注意：

actId 全局唯一
示例 1：

输入：
["DiscountSystem","addActivity","consume","removeActivity","consume"]
[[],[1,15,5,7,2],[101,16],[1],[102,19]]

输出：[null,null,11,null,19]

解释：
DiscountSystem obj = DiscountSystem(); // 初始化系统
obj.addActicity(1,15,5,7,2); //创建编号 1 的优惠活动，单笔消费原价不小于 15 时，
可享受 5 的减免，优惠活动共有 7 个名额，每个用户最多参与该活动 2 次
obj.consume(101,16); //用户 101 消费了 16，满足优惠活动 1 条件，返回实际支付 16 - 5 = 11
obj.removeActivity(1); // 结束编号为 1 的优惠活动
obj.consume(102,19); //用户 101 消费了 19，目前不存在任何优惠活动，需按原价支付，返回 19

示例 2：

输入：
["DiscountSystem","addActivity","addActivity","consume","removeActivity","consume","consume","consume","consume"]
[[],[1,10,6,3,2],[2,15,8,8,2],[101,13],[2],[101,17],[101,11],[102,16],[102,21]]

输出：[null,null,null,7,null,11,11,10,21]

解释：
DiscountSystem obj = DiscountSystem(); // 初始化系统
obj.addActivity(1,10,6,3,2); // 创建编号 1 的优惠活动，单笔消费原价不小于 10 时，
可享受 6 的减免，优惠活动共有 3 个名额，每个用户最多参与该活动 2 次
obj.addActivity(2,15,8,8,2); // 创建编号 2 的优惠活动，单笔消费原价不小于 15 时，
可享受 8 的减免，优惠活动共有 8 个名额，每个用户最多参与该活动 2 次
obj.consume(101,13); // 用户 101 消费了 13，仅满足优惠活动 1 条件，返回实际支付 13 - 6 = 7
用户 101 参加 1 次活动 1，活动 1 剩余 2 个名额
obj.consume(101,8); // 用户 101 消费了 8，不满足任何活动，返回支付原价 8
obj.removeActivity(2); // 结束编号为 2 的活动
obj.consume(101,17); // 用户 101 消费了 17，满足优惠活动 1 条件，返回实际支付 17 - 6 = 11
用户 101 参加 2 次活动 1，活动 1 剩余 1 个名额
obj.consume(101,11); // 用户 101 消费了 11，满足优惠活动 1 条件，但已达到参加次数限制，返回支付原价 11
obj.consume(102,16); // 用户 102 消费了 16，满足优惠活动 1 条件，返回实际支付 16 - 6 = 10
用户 102 参加 1 次活动 1，活动 1 无剩余名额
obj.consume(102,21); // 用户 102 消费了 21，满足优惠活动 1 条件，但活动 1 已无剩余名额，返回支付原价 21

提示：

1 <= addActicity, removeActivity, consume 累计操作数 <= 10^3
0 <= actId, userId <= 1000
1 <= discount < priceLimit <= 10^5
1 <= cost <= 10^5
1 <= number <= 1000
1 <= userLimit <= 10
 */
