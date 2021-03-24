package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) { // construtor para repasasr a chamada para a superclasse
		super(board, color);

	}

	@Override
	public String toString() {// convertendo uma torre para String

		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// above my piece // marcando verdadeiro as posicoes acima da minha peca
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {// enquanto a posicao p existir e nao
																				// tiver uma peça la
																				// ou seja se a posicao estiver vaga
			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
		}

		// left// marcando verdadeiro as posicoes a esquerda da minha peca
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {// enquanto a posicao p existir e nao
																				// tiver uma peça la
																				// ou seja se a posicao estiver vaga
			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
			p.setColum(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
		}

		// Right// marcando verdadeiro as posicoes a direita da minha peca
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {// enquanto a posicao p existir e nao
																				// tiver uma peça la
																				// ou seja se a posicao estiver vaga
			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
			p.setColum(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
		}
		
		// Below my piece // marcando verdadeiro as posicoes a baixo da minha peca
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {// enquanto a posicao p existir e nao
																				// tiver uma peça la
																				// ou seja se a posicao estiver vaga
			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;// marcando a posicao como verdadeira
		}

		return mat;

	}

}
