package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {

		if(rows < 1 || columns < 1) {
			
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column.");//lançãndo exceção personalisada
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {

		if(!positionExists(row,column)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {

		if(thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece; // pieces é a matriz de peça lembrando, estou pegando
																	// aqui a matriz
																	// na posicao informada e atribuindo a peça que
																	// informei
		piece.position = position;// a peça na posicao recebe a posicao informada no método
	}
	
	public Piece removePiece(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		if (piece(position)== null) {
			return null;
		}
		
		Piece aux = piece(position);
		aux.position= null;// retirei a peça auxiliar
		pieces[position.getRow()][position.getColumn()]= null;// agora não tem mais peça na matriz de peças
		
		return aux;
		
	}

	private boolean positionExists(int row, int column) {

		return row >= 0 && row < rows && column >= 0 && column < columns;

	}

	public boolean positionExists(Position position) {

		return positionExists(position.getRow(), position.getColumn());
	}

	public boolean thereIsAPiece(Position position) {

		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return piece(position) != null; 

	}

}
