public class MultiDimensionalArray {
  public static void main(String[] args) {
    int[][] grid = {
      {1, 2, 3, 4},
      {4, 5, 6, 7},
      {7, 8, 3}
    };
    grid[0][0]  = 11;
    for(int i=0; i<grid.length; i++){
      for (int j=0; j<grid[i].length; j++){
        System.out.print(grid[i][j] + "\t");  // a tab
      }
      System.out.print("\n"); // new line
    }

  }
}
