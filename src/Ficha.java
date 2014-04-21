import java.util.ArrayList;


public class Ficha {
		ArrayList<Treino> treinos;
		public Ficha (){
			treinos = new ArrayList<>();
		}
		
		public void adicionarTreino(Treino t){
			treinos.add(t);
		}
		public void remTreino(int t){
			treinos.remove(t);
		}
		public Treino treinoAt(int i){
			return treinos.get(i);
		}
		public String toString(){
			String s = "";
			for(Treino t : treinos){
				s +=t +"-";
				
			}
			if (s.length() != 0)
				s = s.substring(0, s.length()-1);
			return s;
		}
}
