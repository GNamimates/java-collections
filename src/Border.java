public class Border {
    public static void main(String[] args) {
        printBorder();
        System.out.println("Java rocks!");
        printBorder();
    }
    public static void printBorder() {
        int x;
        for (int i = 0; i <=10; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
