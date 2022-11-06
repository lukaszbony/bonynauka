import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '+', '-', '+', '-' },
                { ' ', '|', ' ', '|', ' ' }, };

        printGameBoard(gameBoard);

        while (true) {

//*********************PLAYER****************************************
            Scanner input = new Scanner(System.in);

            System.out.println("Enter your position from 1-9 :");

            int playerPos = input.nextInt();// Entering your position

            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
                System.out.println("this place has been taken please Enter different position :");
                playerPos = input.nextInt(); // Rentering your position
            }
            playerPositions.add(playerPos);

            placePiece(gameBoard, playerPos, "player"); // send your position to put

            printGameBoard(gameBoard); // print Board after your position
            System.out.println();

            String result = checkWinner();

            if (result.length() > 0) {

                System.out.println(result);
                playerPositions.clear();
                cpuPositions.clear();
                resetGameBoard(gameBoard);
                printGameBoard(gameBoard);
                continue;

            }

//*********************CPU*******************************************
            Random rand = new Random();

            int cpuPos = rand.nextInt(9) + 1;

            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {

                cpuPos = rand.nextInt(9) + 1; // Rentering cpu position
            }

            cpuPositions.add(cpuPos);

            placePiece(gameBoard, cpuPos, "cpu");// Entering cpu position

            printGameBoard(gameBoard);
            System.out.println();

            result = checkWinner();
            if (result.length() > 0) {

                System.out.println(result);
                cpuPositions.clear();
                playerPositions.clear();
                resetGameBoard(gameBoard);
                printGameBoard(gameBoard);
                continue;
            }

        }
    }

    public static void printGameBoard(char[][] GBoard) {

        for (char[] G : GBoard) {
            for (char M : G)
                System.out.print(M);
            System.out.println();
        }

    }

    public static void resetGameBoard(char[][] gameBo) {
        char Symbol = ' ';

        gameBo[0][0] = Symbol;

        gameBo[0][2] = Symbol;

        gameBo[0][4] = Symbol;

        gameBo[2][0] = Symbol;

        gameBo[2][2] = Symbol;

        gameBo[2][4] = Symbol;

        gameBo[4][0] = Symbol;

        gameBo[4][2] = Symbol;

        gameBo[4][4] = Symbol;

    }

    public static void placePiece(char[][] Gboard, int ps, String pl) {
        char Symbol = ' ';

        if (pl.equals("player"))
            Symbol = 'X';

        else if (pl.equals("cpu"))
            Symbol = '0';

        switch (ps) {
            case 1:
                Gboard[0][0] = Symbol;
                break;
            case 2:
                Gboard[0][2] = Symbol;
                break;
            case 3:
                Gboard[0][4] = Symbol;
                break;
            case 4:
                Gboard[2][0] = Symbol;
                break;
            case 5:
                Gboard[2][2] = Symbol;
                break;
            case 6:
                Gboard[2][4] = Symbol;
                break;
            case 7:
                Gboard[4][0] = Symbol;
                break;
            case 8:
                Gboard[4][2] = Symbol;
                break;
            case 9:
                Gboard[4][4] = Symbol;
                break;

            default:
                break;

        }
    }

    public static String checkWinner() {

        List frstrow = Arrays.asList(1, 2, 3);
        List scndrow = Arrays.asList(4, 5, 6);
        List thrdrow = Arrays.asList(7, 8, 9);
        List frstclm = Arrays.asList(1, 4, 7);
        List scndclm = Arrays.asList(2, 5, 8);
        List thrdclm = Arrays.asList(3, 6, 9);
        List frstcross = Arrays.asList(1, 5, 9);
        List scndcross = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(frstrow);// 1
        winning.add(scndrow);// 2
        winning.add(thrdrow);// 3
        winning.add(frstclm);// 4
        winning.add(scndclm);// 5
        winning.add(thrdclm);// 6
        winning.add(frstcross);// 7
        winning.add(scndcross);// 8
        int i = 1;
        for (List l : winning) {
            if (playerPositions.containsAll(l))
                return "Congratulation you Won!";
        }
        for (List l : winning) {
            if (cpuPositions.containsAll(l))
                return "Sorry you lost this time :(";
        }
        for (List l : winning) {
            if (!(playerPositions.containsAll(l)) && !(cpuPositions.containsAll(l))
                    && playerPositions.size() + cpuPositions.size() == 9)
                return "CAT!";
        }

        return "";
    }
}