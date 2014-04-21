import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ContasDAO {
	private static final String FILENAME = "contas";


	static{
		try {
			new File(FILENAME).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Cliente login(int mat, String senha)throws ClienteNotFoundException {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String linha = br.readLine();
			while (linha != null ) {
				String[] dados = linha.split(";");
				if(mat == Integer.parseInt(dados[0])){
					if(dados[1].equals(senha)) return ClienteDAO.buscar(mat);
					else break;
				}
				linha = br.readLine();
			}
			throw new ClienteNotFoundException();

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

	public static void addConta(int mat, String senha) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME, true);
			fw.write(mat + ";" + senha+"\n");
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
	public static void remConta(int mat)throws ClienteNotFoundException {
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br = null;
		BufferedWriter bw=null;
		ArrayList<Conta> contas = new ArrayList<>();
		try {
			
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String linha = br.readLine();
			boolean rem=false;
			while (linha != null) {
				String[] dados = linha.split(";");
				if (mat != Integer.parseInt(dados[0])){
					contas.add(new Conta(Integer.parseInt(dados[0]), dados[1]));
				}else{
					rem=true;
				}
				linha = br.readLine();
			}
			fw = new FileWriter(FILENAME);
			bw= new BufferedWriter(fw);
			if(rem){
			for(Conta c:contas){
				bw.write(c.getMat()+";"+c.getSenha());
				bw.newLine();
			}
			}else{
				throw new ClienteNotFoundException();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
