package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece [][] pieces;
	
	
	public Board(int rows, int columns) {

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		
		return pieces[position.getRow()][position.getColumn()]; 
	}
	
	public void placePiece(Piece piece, Position position) {
		
		pieces[position.getRow()][position.getColumn()]= piece; // pieces � a matriz de pe�a lembrando, estou pegando aqui a matriz 
		                                                        // na posicao informada e atribuindo a pe�a que informei
		piece.position= position;//a pe�a na posicao recebe a posicao informada no m�todo
	}

}
