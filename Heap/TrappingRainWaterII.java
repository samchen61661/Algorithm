public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        if (heights == null) {
            return 0;
        }
        int row = heights.length;
        if (row == 0) {
            return 0;
        }
        int col = heights[0].length;
        if (col == 0) {
            return 0;
        }
        
        PriorityQueue<Cell> heap = new PriorityQueue<>(1, new Comparator<Cell>(){
            @Override
            public int compare (Cell c1, Cell c2) {
                return c1.height - c2.height;
            }
        });
        boolean[][] isVisited = new boolean[row][col];
        int sum = 0;
        int[] deltaX = {-1, 0, 1, 0};
        int[] deltaY = {0, 1, 0, -1};
        
        for (int i = 0; i < row; i++) {
            isVisited[i][0] = true;
            heap.offer(new Cell(i, 0, heights[i][0]));
            
            isVisited[i][col - 1] = true;
            heap.offer(new Cell(i, col - 1, heights[i][col - 1]));
        }
        
        for (int i = 1; i < col - 1; i++) {
            isVisited[0][i] = true;
            heap.offer(new Cell(0, i, heights[0][i]));
            
            isVisited[row - 1][i] = true;
            heap.offer(new Cell(row - 1, i, heights[row - 1][i]));
        }
        
        while (!heap.isEmpty()) {
            Cell cell = heap.poll();
            
            for (int i = 0; i < 4; i++) {
                int new_row = cell.row + deltaX[i]; 
                int new_col = cell.col + deltaY[i];
                
                if (new_row >= 0 && new_col >= 0 && new_row < row && new_col < col     && !isVisited[new_row][new_col]) {
                    // dirty cell 
                    isVisited[new_row][new_col] = true;
                    // store the maximum value in the new cell
                    heap.offer(new Cell(new_row, new_col, 
                            Math.max(cell.height, heights[new_row][new_col])));
                            
                    sum += Math.max(0, cell.height - heights[new_row][new_col]);
                }
            }
        }
        
        return sum;
    }
};

class Cell {
    public int row;
    public int col;
    public int height;
    
    public Cell (int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
}
