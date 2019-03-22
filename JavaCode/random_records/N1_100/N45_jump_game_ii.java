package JavaCode.random_records.N1_100;

public class N45_jump_game_ii {

    public static void main(String[] args) {
        System.out.println(new N45_jump_game_ii().jump(new int[]{2,3,1,1,4,4,4,9,7}));
    }

    public int jump(int[] nums) {

        if(nums.length==1)return 0;

        int res=0;
        int cur=0;
        int next=nums[0];
        for (int i=0;i<nums.length;i++)
        {
            next=Math.max(next,i+nums[i]);
            if(next>=nums.length-1)return res+1;
            if(i==cur)
            {
                res++;
                cur=next;
            }
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
