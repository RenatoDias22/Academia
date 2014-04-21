public class Instrutor {
	public Instrutor(String nome, int matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
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
