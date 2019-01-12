package JavaCode.top_interview_questions_easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ten {
    class Solution {

        /**
         * 坐标数据封装类
         */
        class Point
        {
            public Point(int x,int y)
            {
                this.x=x;
                this.y=y;
            }
            int x,y;
        }

        private Map<Integer, List<Point>> map;//储存每个数字的坐标,key为数字，value为坐标集合
        public boolean isValidSudoku(char[][] board) {

            //存储坐标
            map=new HashMap<>();
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[i].length;j++)
                {
                    if(board[i][j]>='0'&&board[i][j]<='9')
                    {
                        int x=board[i][j]-'0';
                        if(map.containsKey(x))
                        {
                            map.get(x).add(new Point(i,j));
                        }
                        else
                        {
                            List<Point> list=new ArrayList<>();
                            list.add(new Point(i,j));
                            map.put(x,list);
                        }
                    }
                }
            }

            //遍历判断
            for(int key:map.keySet())
            {
                List<Point> list=map.get(key);
                for(int i=0;i<list.size()-1;i++)
                {
                    Point a=list.get(i);
                    for(int j=i+1;j<list.size();j++)
                    {
                        Point b=list.get(j);
                        if(!judge(a,b))
                        {
                            return false;
                        }
                    }
                }
            }

            return true;
        }

        /**
         * 判断两个坐标是否符合规则
         * @param a
         * @param b
         * @return
         */
        boolean judge(Point a,Point b)
        {
            if(a.x==b.x||a.y==b.y)
            {
                return false;
            }

            if(a.x/3==b.x/3&&a.y/3==b.y/3)
            {
                return false;
            }
            return true;

        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 上图是一个部分填充的有效的数独。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例 1:
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 */
