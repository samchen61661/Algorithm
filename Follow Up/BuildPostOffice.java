public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        final int[] deltaX = {0, -1, -1, -1, 0, 1, 1, 1};
        final int[] deltaY = {1, 1, 0, -1, -1, -1, 0, 1};
        
        ArrayList<Integer> xIdx = new ArrayList<>();
        ArrayList<Integer> yIdx = new ArrayList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    xIdx.add(i);
                    yIdx.add(j);
                }
            }
        }
        
        if (xIdx.size() == row * col) {
            return -1;
        } 
        if (xIdx.size() == 0) {
            return 0;
        }
        
        int xMedian = getMedian(xIdx);
        int yMedian = getMedian(yIdx);
        boolean[][] isVisited = new boolean[row][col];
        int dis = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(xMedian * col + yMedian);
        isVisited[xMedian][yMedian] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                int x = index / col;
                int y = index % col;
                
                if (grid[x][y] == 1) {
                    for (int j = 0; j < 8; j++) {
                        int new_x = x + deltaX[j];
                        int new_y = y + deltaY[j];
                        
                        if (new_x >= 0 && new_y >= 0 && new_x < row 
                                && new_y < col && !isVisited[new_x][new_y]) {
                            queue.offer(new_x * col + new_y);
                            isVisited[new_x][new_y] = true;
                        }
                    }
                    
                } else {
                    dis = Math.min(dis, getDistance(xIdx, yIdx, x, y));
                }
            }
            
            if (dis != Integer.MAX_VALUE) {
                return dis;
            }
            
        }
        
        
        return -1;
    }
    
    private int getDistance (ArrayList<Integer> xIdx, ArrayList<Integer> yIdx, 
            int x, int y) {
        int dis = 0;
        
        for (int i = 0; i < xIdx.size(); i++) {
            dis += Math.abs(xIdx.get(i) - x) + Math.abs(yIdx.get(i) - y);
        }
        
        return dis;
    }
    
    private int getMedian (ArrayList<Integer> list) {
        // Sort to array to get median
        Collections.sort(list);
        int size = list.size();
        int val = 0;
        
        if (size % 2 == 0) {
            val = (list.get(size / 2) + list.get(size / 2 - 1)) / 2; 
        } else {
            val = list.get(size / 2);
        }
        
        return val;
    }
}
