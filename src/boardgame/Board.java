package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if(rows< 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}


	//retirado o set da linha e coluna pq o valor e fixo
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
	//Retornar a pe�a por posi��o
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColum()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ther is already a piece on position:"+position);
		}
		pieces[position.getRow()][position.getColum()]= piece;
		piece.position= position;
	}
	//Para verificar se a posi��o existe
	private boolean positionExists(int row, int column) {
		 return row>=0 && row<rows && column >= 0 && column < columns;
	}
	
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColum());
	}
	
	//valida��o se tem uma pe�a esta nessa posi��o
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
