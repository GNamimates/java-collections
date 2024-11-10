import java.util.Scanner;

public class TicTacToe {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String playerA = ANSI_RED + "X" + ANSI_RESET;
    public static final String playerB = ANSI_BLUE + "O" + ANSI_RESET;

    static int size = 3;
    static int[][] board = new int[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Reset the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
        boolean turn = false;
        String player;
        for (int i = 0; i < (size*size); i++) {
            turn = !turn; // flip turn
            int selectedSlot;

            if (turn) {
                player = playerA;
            }else{
                player = playerB;
            }
            System.out.println("\nIts " + player + "'s Turn.");
            drawBoard();
            // Selecting the slot to place
            while (true){
                System.out.print("Pick a number slot: ");
                selectedSlot = sc.nextInt();
                sc.nextLine();
                if (selectedSlot > 0 && selectedSlot <= size*size && getSlot(selectedSlot) == 0) {break;}
                else {
                    System.out.println("Invalid slot, pick another one.");
                }
            }
            // plot the selected slot
            int id;
            if (turn) {id = 1;}else{id = 2;}
            setSlot(selectedSlot, id);
        }
        drawBoard(); // draw one last time
    }

    // Draws the board
    private static void drawBoard() {
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c++; // get it?
                int slot = board[i][j];
                String display;
                switch (slot) {
                    case 1: display = playerA; break;
                    case 2: display = playerB; break;
                    default: display = (ANSI_PURPLE+c+ANSI_RESET); break;
                }
                System.out.print(display);
                if (j != 2){System.out.print("|");}
            }
            if (i != 2){
                System.out.print("\n"+"-+".repeat(board.length-1));
                System.out.println("-");
            }
        }
        System.out.println();
    }
    private static int getSlot(int i){
        i--;return board[i/size][i%size];
    }
    private static void setSlot(int i, int j){
        i--;board[i/size][i%size] = j;
    }
}
