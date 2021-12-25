import java.util.Arrays;
import java.util.Scanner;

public class Game {
  private final char[][] grid = new char[3][3];
  {
    for (char[] chars : grid) {
      Arrays.fill(chars, ' ');
    }
  }
  final Scanner in = new Scanner(System.in);

  private void printState() {
    System.out.println("---------");
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 0) {
          System.out.print("| ");
        }
        System.out.print(grid[i][j] + " ");
        if (j == 2) {
          System.out.println("|");
        }
      }
    }
    System.out.println("---------");
  }

  void execute() throws InterruptedException {
    Actor[] players = choosePlayers();
    printState();

    MAINLOOP:
    while (true) {
      for (final Actor actor : players) {
        actor.move(grid);
        printState();
        if (isOver()) {
          break MAINLOOP;
        }
        Thread.sleep(200);
      }
    }
  }

  private Actor[] choosePlayers() {

    Actor[] players = new Actor[2];
    String[] input;

    System.out.print("Input command: ");
    input = in.nextLine().toLowerCase().trim().split(" ");
    boolean badParam = true;

    switch (input.length) {
      case 1:
        if (input[0].equals("exit")) {
          System.exit(0);
        }
        break;
      case 3:
        if (input[0].equals("start")) {
          if ((input[1].equals("user") || input[1].equals("easy") ||
              input[1].equals("medium") || input[1].equals("hard")) &&
              (input[2].equals("user") || input[2].equals("easy") ||
                  input[2].equals("medium") || input[2].equals("hard"))) {
            badParam = false;
          }
        }
        break;
    }
    if (badParam) {
      System.out.println("Bad parameters!");
      return choosePlayers();
    } else {
      for (int i = 1; i <= 2; i++) {
        switch (input[i]) {
          case "user":
            players[i - 1] = new Human(i == 1 ? 'X' : 'O');
            break;
          case "easy":
            players[i - 1] = new EasyComputer(i == 1 ? 'X' : 'O');
            break;
          case "medium":
            players[i - 1] = new MediumComputer(i == 1 ? 'X' : 'O');
            break;
          case "hard":
            players[i - 1] = new HardComputer(i == 1 ? 'X' : 'O');
            break;
        }
      }
    }
    return players;
  }

  private boolean isOver() {
    if (hasWon(grid, 'X')) {
      System.out.println("X wins");
    } else if (hasWon(grid, 'O')) {
      System.out.println("O wins");
    } else if (isTie(grid)) {
      System.out.println("Draw");
    } else {
      return false;
    }
    return true;
  }

  static boolean hasWon(char[][] grid, char symbol) {
    return (grid[0][0] == symbol && grid[0][1] == symbol && grid[0][2] == symbol) ||
        (grid[1][0] == symbol && grid[1][1] == symbol && grid[1][2] == symbol) ||
        (grid[2][0] == symbol && grid[2][1] == symbol && grid[2][2] == symbol) ||
        (grid[0][0] == symbol && grid[1][0] == symbol && grid[2][0] == symbol) ||
        (grid[0][1] == symbol && grid[1][1] == symbol && grid[2][1] == symbol) ||
        (grid[0][2] == symbol && grid[1][2] == symbol && grid[2][2] == symbol) ||
        (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
        (grid[2][0] == symbol && grid[1][1] == symbol && grid[0][2] == symbol);
  }

  static boolean isTie(char[][] grid) {
    int freeSpaces = 9;

    for (char[] row : grid) {
      for (char ch : row) {
        if (ch != ' ') {
          --freeSpaces;
        }
      }
    }
    return freeSpaces == 0;
  }
}
