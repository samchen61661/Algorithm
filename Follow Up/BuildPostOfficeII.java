public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        // BFS
        // Time complexity: O((mn)^2)   Space complexity: O(mn)          
        int row = grid.length;
        int col = grid[0].length;
        int[][] dis = new int[row][col];
        int[][] reach = new int[row][col];
        final int[] deltaX = {0, 1, 0, -1};
        final int[] deltaY = {1, 0, -1, 0};
        int cntOffice = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    Queue<Integer> queue = new LinkedList<>();
                    boolean[][] isVisited = new boolean[row][col];
                    int level = 0;
                    
                    cntOffice++;
                    queue.offer(i * col + j);
                    isVisited[i][j] = true;
                    
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        
                        for (int k = 0; k < size; k++) {
                            int index = queue.poll();
                            int x = index / col;
                            int y = index % col;
                            
                            for (int m = 0; m < 4; m++) {
                                int new_x = x + deltaX[m];
                                int new_y = y + deltaY[m];
                                
                                // You cannot pass through wall and house, 
                                // but can pass through empty.
                                if (new_x >= 0 && new_y >= 0 
                                        && new_x < row && new_y < col 
                                        && !isVisited[new_x][new_y] && grid[new_x][new_y] == 0) {
                                    queue.offer(new_x * col + new_y);
                                    isVisited[new_x][new_y] = true;
                                    reach[new_x][new_y]++;
                                    dis[new_x][new_y] += level + 1;
                                }
                            }
                        }
                        
                        level++;
                    }
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == cntOffice) {
                    min = Math.min(min, dis[i][j]);
                }
            }
        }
        
        return (min == Integer.MAX_VALUE) ? -1 : min;
    }
}
