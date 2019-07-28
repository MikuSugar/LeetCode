package JavaCode.contest.n147;

import java.util.LinkedList;
import java.util.Queue;

public class N2 {

    //board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
    static String[] b={"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};
    static char[][] map;
    static
    {
        map=new char[b.length][];
        for (int i=0;i<b.length;i++)
        {
            map[i]=new char[b[i].length()];
            System.arraycopy(b[i].toCharArray(),0,map[i],0,b[i].length());
        }
    }
    class Node
    {
        StringBuilder road;
        int x,y;
        int next;
        public Node(int x, int y,int next,String s) {
            this.x = x;
            this.y = y;
            this.next=next;
            road=new StringBuilder(s);
        }
    }
    static int[][] cur={{-1,0},{0,-1},{0,1},{1,0}};
    static String[] s={"U","L","R","D"};
    public String alphabetBoardPath(String target) {
        StringBuilder sb=new StringBuilder();
        Queue<Node> queue=new LinkedList<>();
        char[] tar = target.toCharArray();
        int len=0;
        if(tar[0]==map[0][0])
        {
            Node node = new Node(0, 0, 1,"!");
            queue.add(node);
            len=1;
            if(len==tar.length)return "!";
        }
        else
        {
            queue.add(new Node(0,0,0,""));
        }

        while (!queue.isEmpty())
        {
            Node poll = queue.poll();
            if(map[poll.x][poll.y]==tar[poll.next])
            {
                poll.next++;
                poll.road.append("!");
                len++;
                queue.add(poll);
                if(poll.next==tar.length)return poll.road.toString();
                continue;
            }
            if(poll.next<len)continue;
            String rode = poll.road.toString();
            boolean isok=false;
            for (int k=0;k<4;k++)
            {
                if(isok)continue;
                int x=poll.x+cur[k][0];
                int y=poll.y+cur[k][1];
                if(x<0||x>=map.length||y<0||y>=b[x].length())continue;
                Node next=null;
                if(map[x][y]==tar[poll.next])
                {
                    next=new Node(x,y,poll.next+1,rode+s[k]+"!");
                    if(next.next==tar.length)return next.road.toString();
                    len=next.next;
                    isok=true;
                }
                else
                {
                    next=new Node(x,y,poll.next,rode+s[k]);
                }
                queue.add(next);
            }
        }
        return null;
    }
}
/**
 *我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 *
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
 *
 * 我们可以按下面的指令规则行动：
 *
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 * 示例 2：
 *
 * 输入：target = "code"
 * 输出："RR!DDRR!UUL!R!"
 *
 *
 * 提示：
 *
 * 1 <= target.length <= 100
 * target 仅含有小写英文字母。
 */
