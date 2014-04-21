import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {
	private static final String FILENAME = "exercicios";

	static{
		try {
			new File(FILENAME).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> lerExercicios() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			ArrayList<String> exercicios = new ArrayList<>();
			String linha;

			linha = br.readLine();

			while (linha != null) {

				exercicios.add(linha);
				linha = br.readLine();
			}

			return exercicios;

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void adicionarExercicio(String nomeExercicio) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME, true);
			fw.write(nomeExercicio+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void remExercicio(String nome) throws ExercicioNotFoundException {
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		ArrayList<String> s = new ArrayList<>();
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String linha = br.readLine();
			boolean rem = false;
			while (linha != null) {
				if (!nome.equals(linha)) {
					s.add(linha);
				} else {
					rem = true;
				}
				linha = br.readLine();

			}			
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			for (String st : s) {
				bw.write(st);
				bw.newLine();
			}
			if(!rem) {
				throw new ExercicioNotFoundException();
			}
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
				br.close();
				fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
