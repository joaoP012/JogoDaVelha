package br.com.unimater.aed2023;
import java.util.Scanner;

public class Jogo_velha {

    static Scanner ms = new Scanner(System.in);
    static String[] board = new String[9];
    static String currentPlayer = "X";

    public static void main(String[] args) {
        initBoard();

        while (true) {
            printBoard();
            System.out.print("Jogador " + currentPlayer + ", digite o número da posição que deseja marcar: ");
            int position = ms.nextInt();

            if (position < 1 || position > 9) {
                System.out.println("Posição inválida! Digite um número entre 1 e 9.");
                continue;
            }

            if (!board[position-1].equals(" ")) {
                System.out.println("Essa posição já está marcada! Tente novamente.");
                continue;
            }

            board[position-1] = currentPlayer;

            if (checkWin()) {
                printBoard();
                System.out.println("Parabéns, jogador " + currentPlayer + "! Você venceu o jogo!");
                break;
            }

            if (checkTie()) {
                printBoard();
                System.out.println("O jogo empatou!");
                break;
            }

            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
    }

    static void initBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = " ";
        }
    }

    static void printBoard() {
        System.out.println("|" + board[0] + "|" + board[1] + "|" + board[2] + "|");
        System.out.println("|" + board[3] + "|" + board[4] + "|" + board[5] + "|");
        System.out.println("|" + board[6] + "|" + board[7] + "|" + board[8] + "|");
    }

    static boolean checkWin() {
        
        if (board[0].equals(currentPlayer) && board[1].equals(currentPlayer) && board[2].equals(currentPlayer)) return true;
        if (board[3].equals(currentPlayer) && board[4].equals(currentPlayer) && board[5].equals(currentPlayer)) return true;
        if (board[6].equals(currentPlayer) && board[7].equals(currentPlayer) && board[8].equals(currentPlayer)) return true;

        
        if (board[0].equals(currentPlayer) && board[3].equals(currentPlayer) && board[6].equals(currentPlayer)) return true;
        if (board[1].equals(currentPlayer) && board[4].equals(currentPlayer) && board[7].equals(currentPlayer)) return true;
        if (board[2].equals(currentPlayer) && board[5].equals(currentPlayer) && board[8].equals(currentPlayer)) return true;

        
        if (board[0].equals(currentPlayer) && board[4].equals(currentPlayer) && board[8].equals(currentPlayer)) return true;
        if (board[2].equals(currentPlayer) && board[4].equals(currentPlayer) && board[6].equals(currentPlayer)) return true;

        return false;
    }

    static boolean checkTie() {
        for (String position : board) {
            if (position.equals(" ")) {
                return false;
            }
        }

        return true;
    }
}