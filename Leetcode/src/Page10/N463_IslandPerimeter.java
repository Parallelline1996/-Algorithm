package Page10;

/*
* You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally).
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
* */
public class N463_IslandPerimeter {

    public static void main(String[] args) {
        System.out.println(new N463_IslandPerimeter().islandPerimeter(new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}}
        ));
    }

    private int sum = 0;

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count(i, j, grid);
                    break;
                }
            }
        }
        return sum;
    }

    private void count(int i, int j, int[][] gird) {
        if (i >= gird.length || i < 0 || j >= gird[0].length || j < 0 || gird[i][j] == 0) {
            sum++;
            return;
        }
        if (gird[i][j] == -1) {
            return;
        }
        gird[i][j] = -1;
        count(i - 1, j , gird);
        count(i + 1, j , gird);
        count(i, j + 1, gird);
        count(i, j - 1, gird);
    }

    // faster
    public int islandPerimeter_(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int perimeter = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if(grid[i][j]==1) {
                    perimeter += 4;
                    if (i>0 && grid[i-1][j]==1)
                        perimeter -= 2;
                    if (j>0 && grid[i][j-1]==1)
                        perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
}
