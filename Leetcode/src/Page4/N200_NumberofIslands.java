package Page4;

/*
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
* You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
* */
public class N200_NumberofIslands {

    public static void main(String[] args) {
        System.out.println(new N200_NumberofIslands().numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}}));

        System.out.println(new N200_NumberofIslands().numIslands(new char[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}}));
    }

    // 这个数组非必要，可以直接对 gird进行修改，将遍历的从 '1' -> '0'
    boolean[][] isUse = null;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int number = 0;
        isUse = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 判断坐标点是否已被使用以及是否为土地
                if (!isUse[i][j] && grid[i][j] == '1') {
                    helper(grid, i, j);
                    number++;
                }
            }
        }
        return number;
    }

    // 将与输入点相邻的土地，全部置为已使用
    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || isUse[i][j]) return;
        if (grid[i][j] == '1') {
            isUse[i][j] = true;
            helper(grid, i - 1, j);
            helper(grid, i + 1, j);
            helper(grid, i, j + 1);
            helper(grid, i, j - 1);
        }
    }

}
