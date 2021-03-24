package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;


public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.println();// só pra saltar uma linha
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(scan);
				
				System.out.println();// só pra saltar uma linha
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				ChessPiece capturedPiece= chessMatch.performChessMove(source, target);
			}
			catch(InputMismatchException e){
				System.out.println(e.getMessage());
				scan.nextLine();// para o programa aguardar aperta o enter
			}
			catch(ChessException e){
				System.out.println(e.getMessage());
				scan.nextLine();// para o programa aguardar aperta o enter
			}
		}
		
		
		
	}

}
