import java.util.*;
public class Treino {
	public ArrayList<Exercicio> exercs;
	public String nome;
	public Treino(){
		exercs = new ArrayList<>();
	}
	public void add(Exercicio e){
		exercs.add(e);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString(){
		String s = "";
		for(Exercicio e : exercs){
			s += e+",";
			
		}
		if (s.length() != 0)
		s = s.substring(0, s.length()-1);
		//System.out.println(s);
		return s;
	}
	
}
