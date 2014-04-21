import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	private static final String FILENAME = "clientes";
	private static ArrayList<Cliente> clientes = new ArrayList<>();

	static {
		try {
			new File(FILENAME).createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
		lerLista();
	}

	public static void inserir(Cliente c) {
		for (Cliente cliente : clientes)
			if (cliente.getMatricula() == c.getMatricula())
				return;

		clientes.add(c);
		escreverLista();
	}

	public static void alterar(Cliente c) throws ClienteNotFoundException {
		for (Cliente cliente : clientes)
			if (cliente.getMatricula() == c.getMatricula()) {
				int aux = clientes.indexOf(cliente);
				clientes.remove(cliente);
				clientes.add(aux, c);
				return;
			}
		throw new ClienteNotFoundException();
	}

	public static void excluir(int matricula) {
		for (Cliente c : clientes)
			if (c.getMatricula() == matricula) {
				clientes.remove(c);
				break;
			}
		escreverLista();
	}

	public static Cliente buscar(int matricula) throws ClienteNotFoundException {
		for (Cliente c : clientes)
			if (c.getMatricula() == matricula)
				return c;
		throw new ClienteNotFoundException();
	}

	public static List<Cliente> buscar(String nome)
			throws ClienteNotFoundException {
		List<Cliente> aux = new ArrayList<>();
		for (Cliente c : clientes)
			if (c.getNome().contains(nome))
				aux.add(c);
		if (aux.isEmpty()) {
			throw new ClienteNotFoundException();
		}
			return aux;
		
		
	}

	public static List<Cliente> listar() {
		return clientes;
	}

	public static void lerLista() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String linha = br.readLine();
			while (linha != null) {
				String[] dados = linha.split(";");
				clientes.add(new Cliente(dados[0], Integer.parseInt(dados[1]),
						Integer.parseInt(dados[2]), decifrarFicha(dados[3]),
						dados[4].charAt(0), dados[5], dados[6], dados[7],
						dados[8], dados[9], dados[10], dados[11], dados[12],
						dados[13], dados[14], dados[15], dados[16],
						new SimpleDateFormat("dd/MM/yyyy").parse(dados[17])));
				linha = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static Ficha decifrarFicha(String dados) {
		if (dados.equals("") || dados.equals("null"))
			return null;
		Ficha f = new Ficha();
		String[] treinos = dados.split("-");
		int i = 1;
		for (String s : treinos) {
			Treino t = new Treino();
			t.setNome("Treino " + i);
			String[] exercs = s.split(",");
			if (!exercs[0].equals("")) {
				for (String s2 : exercs) {
					String[] exerc = s2.split("_");
					t.add(new Exercicio(exerc[0], Integer.parseInt(exerc[1])));
				}
				f.adicionarTreino(t);
				i++;
			}
		}
		return f;
	}

	public static void escreverLista() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);

			for (Cliente c : clientes) {
				bw.write(c.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int proximaMatricula() {
		if (clientes.isEmpty())
			return 1;
		return clientes.get(clientes.size() - 1).getMatricula() + 1;
	}
}
