import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteDAO {
	

	/*static {
		
		try {
			new File(FILENAME).createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
		lerLista();
	}*/

	public static void inserir(Cliente c) {
		Connection conexao = null;
		PreparedStatement statememt = null;
		
		try{
			conexao = Conector.getConexao();
			statememt = conexao.prepareStatement("insert into Cliente values (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			statememt.setString(1, c.getNome());
			statememt.setString(2, c.getRG());
			statememt.setString(3, c.getCPF());
			statememt.setString(4, c.getSexo());
			//statememt = setString(1,getSenha());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statememt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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

	public static List<Cliente> buscar(String nome)	throws ClienteNotFoundException {
		List<Cliente> aux = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement statement = null;
		
		try {
			conexao = Conector.getConexao();
			statement = conexao.prepareStatement("select * from cliente where nome like ? ");
			statement.setString(1,"%"+nome+"%");
			ResultSet resultados = statement.executeQuery();
			while(resultados.next()){
				//String nome, int matricula,int mensalidadeVencimento, Ficha ficha, 
//				char sexo, String rG, String cPF, String endereco,
//				String cEP, String numeroCasa, String bairro, String complemento,
//				String cidade, String estado, String eMail, String telefone,
//				String celular, Date dataNascimento
				String nomeRes = resultados.getString("nome");
				int matricula = resultados.getInt("matricula");
				Cliente c = new Cliente(nomeRes, matricula, );
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
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
