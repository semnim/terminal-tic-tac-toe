public class HardComputer extends Computer {

  public HardComputer(char symbol) {
    super(symbol);
  }

  @Override
  void move(char[][] grid) {
    int bestScore = -1000;
    int x = -1;
    int y = -1;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == ' ') {
          grid[i][j] = super.getSymbol();
          int score = minimax(grid, 0, false);

          if (score > bestScore) {
            bestScore = score;
            y = i;
            x = j;
          }

          grid[i][j] = ' ';
        }
      }
    }
    System.out.println("Making move level \"hard\"");
    grid[y][x] = super.getSymbol();

  }

  int minimax(char[][] grid, int depth, boolean isMax) {
    if (Game.hasWon(grid, super.getSymbol())) {
      return 10 - depth;
    } else if (Game.hasWon(grid, super.getSymbol() == 'X' ? 'O' : 'X')) {
      return -10 - depth;
    } else if (Game.isTie(grid)) {
      return -depth;
    }
    int bestMove;
    if (isMax) {
      bestMove = -1000;

      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == ' ') {
            grid[i][j] = super.getSymbol();
            bestMove = Math.max(minimax(grid, depth + 1, false), bestMove);
            grid[i][j] = ' ';
          }
        }
      }
    } else {
      bestMove = 1000;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == ' ') {
            grid[i][j] = super.getSymbol() == 'X' ? 'O' : 'X';
            bestMove = Math.min(minimax(grid, depth + 1, true), bestMove);
            grid[i][j] = ' ';
          }
        }
      }
    }
    return bestMove;
  }
}
