import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Actor {
  private final char symbol;
  final Scanner in = new Scanner(System.in);

  public Human(char symbol) {
    this.symbol = symbol;
  }

  @Override
  public void move(char[][] grid) {
      System.out.print("Enter the coordinates: ");
      int y = 0;
      int x = 0;
      try {
        y = in.nextInt() - 1;
        x = in.nextInt() - 1;
      } catch (InputMismatchException ie) {
        System.out.println("You should enter numbers!");
        in.nextLine();
        this.move(grid);
      }

      boolean outOfBounds = x < 0 || x > 2 ||
                            y < 0 || y > 2;

      if (outOfBounds) {
        System.out.println("Coordinates should be from 1 to 3!");
        this.move(grid);
      }

      boolean cellIsTaken = grid[y][x] != ' ';
      if (cellIsTaken) {
        System.out.println("This cell is occupied! Choose another one!");
        this.move(grid);
      }
      grid[y][x] = symbol;
  }

}
