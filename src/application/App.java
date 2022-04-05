package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while(true){
            try{
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces()); 
                System.out.print("\nSource: ");
                ChessPosition source = UI.readChessPosition(input);
                System.out.print("\nTarget: ");
                ChessPosition target = UI.readChessPosition(input);
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }catch(ChessException e){
                System.out.print(e.getMessage());
                input.nextLine();input.nextLine();
            }catch(InputMismatchException e){
                System.out.print(e.getMessage());
                input.nextLine();input.nextLine();
            }
        }
    }
}
