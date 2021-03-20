package boardgame;

public class BoardException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BoardException(String msg) {
		
		super(msg);// repassa a mensagem para o contrutor que é o Runtime 
	}
 
}
