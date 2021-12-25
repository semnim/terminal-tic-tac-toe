import java.util.Random;

public abstract class Computer extends Actor {

  private final char symbol;

  public Computer(char symbol) {
    this.symbol = symbol;
  }

  @Override
  void move(char[][] grid) {
    Random generator = new Random();
    int x;
    int y;

    do {
      x = generator.nextInt(3);
      y = generator.nextInt(3);
    } while (grid[y][x] != ' ');

    grid[y][x] = symbol;
  }

  public char getSymbol() {
    return this.symbol;
  }
}
