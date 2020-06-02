package suanfa.march1th;

/**
 * @auther eleme
 * @time 2020/6/2 12:01 上午
 * @desc
 */
public class NumIslands {

    public static void main(String[] args) {
        NumIslands client = new NumIslands();


    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if (grid[i][i1] != '0' && !visited[i][i1]) {
                    helper(grid, visited, i, i1);
                    res++;
                }

            }
        }
        return res;
    }

    public void helper(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i > grid.length || j < 0 || j > grid[0].length
                || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        helper(grid, visited, i - 1, j);
        helper(grid, visited, i + 1, j);
        helper(grid, visited, i, j - 1);
        helper(grid, visited, i, j + 1);
    }
}
