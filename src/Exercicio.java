
public class Exercicio {
	public Exercicio(String nome) {
		super();
		this.nome = nome;
	}
	public String nome;
	public int reps;
	
	public Exercicio(){	
	}
	
	public Exercicio(String n, int r){
		nome = n;
		reps = r;
	}
	public String toString(){
		return nome+"_"+reps;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public int getReps() {
		return reps;
	}
	public void setReps(int reps){
		this.reps = reps;
	}
}
