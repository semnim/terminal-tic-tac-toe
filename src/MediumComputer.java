public class MediumComputer extends Computer {

  public MediumComputer(char symbol) {
    super(symbol);
  }

  @Override
  void move(char[][] grid) {

    if (!canAttackOrDefend(grid)) {
      super.move(grid);
    }

    System.out.println("Making move level \"medium\"");
  }
  private boolean canAttackOrDefend(char[][] grid) {

    char opponentSymbol = super.getSymbol() == 'X' ? 'O' : 'X';

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grid[i][j] == ' ') {
          grid[i][j] = super.getSymbol();

          if (Game.hasWon(grid, super.getSymbol())) {
            return true;
          } else {
            grid[i][j] = opponentSymbol;
            if (Game.hasWon(grid, opponentSymbol)) {
              grid[i][j] = super.getSymbol();
              return true;
            }
          }
          grid[i][j] = ' ';
        }
      }
    }
    return false;
  }
}
