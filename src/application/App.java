package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        while(!chessMatch.getCheckmate()){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.print("\nSource: ");
                ChessPosition source = UI.readChessPosition(input);
                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.print("\nTarget: ");
                ChessPosition target = UI.readChessPosition(input);
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if(captured != null) {captured.add(capturedPiece);}
            }catch(ChessException e){
                System.out.print(e.getMessage());
                input.nextLine();input.nextLine();
            }catch(InputMismatchException e){
                System.out.print(e.getMessage());
                input.nextLine();input.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
