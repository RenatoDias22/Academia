import javax.swing.JOptionPane;


public class ExercicioNotFoundException extends Exception {
	public ExercicioNotFoundException(){
		JOptionPane.showMessageDialog(null,
				"Exercício não encontrado!",
			    "Erro",
			    JOptionPane.ERROR_MESSAGE);
		System.err.println("Exercício não encontrado.");
	}
	public ExercicioNotFoundException(String msg){
		System.err.println(msg);
	}
}
