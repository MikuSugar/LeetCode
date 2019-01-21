package JavaCode.top_interview_questions_medium.backtracking;

public class WordSearch
{
    class Solution
    {
        private char[][] board;
        private int[][] book;
        private char[] word;
        public boolean exist(char[][] board, String word)
        {
            this.board=board;
            if(board.length==0) return false;
            this.book=new int[board.length][board[0].length];
            this.word=word.toCharArray();
            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board[i].length;j++)
                {
                    if(dfs(0,i,j)) return true;
                }
            }
            return false;

        }

        /**
         * dfs搜索
         * @param index 为当前需要判断的字母指针
         * @param i 纵坐标
         * @param j 横坐标
         * @return 判断结果
         */
        boolean dfs(int index,int i,int j)
        {
            if(index==word.length) return true;
            if(i<0||j<0||i==board.length||j==board[0].length||book[i][j]==1)
            {
                return false;
            }
            char c=word[index];
            if(c!=board[i][j])return false;
            book[i][j]=1;
            if(dfs(index+1,i,j+1)||dfs(index+1,i+1,j)||dfs(index+1,i-1,j)||dfs(index+1,i,j-1))
            {
                book[i][j]=0;
                return true;
            }
            else
            {
                book[i][j]=0;
                return false;
            }

        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/95/
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
