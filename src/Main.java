public class Main {
    public static void main(String[] args) {
        try {
            new Game().execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
