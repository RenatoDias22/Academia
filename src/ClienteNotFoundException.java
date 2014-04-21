import javax.swing.JOptionPane;


public class ClienteNotFoundException extends Exception {
	public ClienteNotFoundException(){
		System.err.println("Cliente não encontrado!");
	}
	public ClienteNotFoundException(String msg){
		System.err.println(msg);
	}
}
