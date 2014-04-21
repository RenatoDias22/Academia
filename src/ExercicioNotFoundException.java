import javax.swing.JOptionPane;


public class ExercicioNotFoundException extends Exception {
	public ExercicioNotFoundException(){
		JOptionPane.showMessageDialog(null,
				"Exerc�cio n�o encontrado!",
			    "Erro",
			    JOptionPane.ERROR_MESSAGE);
		System.err.println("Exerc�cio n�o encontrado.");
	}
	public ExercicioNotFoundException(String msg){
		System.err.println(msg);
	}
}
