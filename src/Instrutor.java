import java.util.Date;

public class Instrutor extends Cadastro {
	public Instrutor(String nome, int matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}
	
	public Instrutor( String nome, int matricula, 
			char sexo, String rG, String cPF, String endereco,
			String cEP, String numeroCasa, String bairro, String complemento,
			String cidade, String estado, String eMail, String telefone,
			String celular, Date dataNascimento) {
		super(nome, matricula, sexo, rG, cPF, endereco, cEP, numeroCasa, bairro, complemento, cidade,
				estado, eMail, telefone, celular, dataNascimento);
	}

	private String nome;
	private int matricula;
	
	public void addTreino(int mat, Treino t) {
		for (Cliente c : ClienteDAO.listar()) {
			if (mat == c.getMatricula()) {
				Ficha f = c.getFicha();
				f.adicionarTreino(t);
				c.setFicha(f);
				ClienteDAO.escreverLista();
			}
		}

	}

	public void excTreino(int mat, Treino t) {
		for (Cliente c : ClienteDAO.listar()) {
			if (mat == c.getMatricula()) {
				Ficha f = c.getFicha();
				f.treinos.remove(t);
				c.setFicha(f);
				ClienteDAO.escreverLista();
			}
		}

	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}
}
