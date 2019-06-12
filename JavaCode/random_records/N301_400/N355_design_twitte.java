package JavaCode.random_records.N301_400;

import java.util.*;

public class N355_design_twitte {
    class Twitter {

        private int time;
        Map<Integer,User> map;
        PriorityQueue<int[]> queue;
        /** Initialize your data structure here. */
        public Twitter() {
            map=new HashMap<>();
            queue=new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!map.containsKey(userId))
            {
                map.put(userId,new User());
            }
            User user = map.get(userId);
            user.posts.add(new int[]{tweetId,time++});
            user.follows.add(userId);
        }



        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            queue.clear();
            for (int uid:map.getOrDefault(userId,new User()).follows)
            {
                int cnt=0;
                List<int[]> posts = map.getOrDefault(uid, new User()).posts;
                for (int i=posts.size()-1;i>=0&&cnt<10;i--,cnt++)
                {
                    queue.add(posts.get(i));
                }
            }
            List<Integer> res=new ArrayList<>(10);
            while (!queue.isEmpty())
            {
                res.add( queue.poll()[0]);
                if(res.size()==10)break;
            }
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(!map.containsKey(followerId))
            {
                map.put(followerId,new User());
            }
            map.get(followerId).follows.add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followeeId==followerId)return;
            map.getOrDefault(followerId,new User()).follows.remove(followeeId);
        }

        private class User
        {
            //用户的推文
            List<int[]> posts;

            //用户关注对象
            Set<Integer> follows;

            public User() {
                posts=new ArrayList<>();
                follows=new HashSet<>();
            }
        }

    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}
/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
