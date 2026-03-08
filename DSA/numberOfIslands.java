import java.util.LinkedList;
import java.util.Queue;

public class numberOfIslands {
    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]==1){
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    
                    grid[i][j] = 0;
                    while(!queue.isEmpty()){
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];

                        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};;
                        for(int[] d : directions){
                            int newX = x + d[0];
                            int newY = y + d[1];

                            if(newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 1){
                                queue.add(new int[]{newX, newY});
                                grid[newX][newY] = 0;
                            }
                        }
                    }
                }
            }   
        }
        System.out.println(count);
    }
}