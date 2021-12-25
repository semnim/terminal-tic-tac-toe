public class EasyComputer extends Computer {

  public EasyComputer(char symbol) {
    super(symbol);
  }

  @Override
  void move(char[][] grid) {
    super.move(grid);
    System.out.println("Making move level \"easy\"");
  }

}
