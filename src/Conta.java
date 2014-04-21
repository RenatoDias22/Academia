
public class Conta {
	public Conta(int mat, String senha) {
		super();
		this.mat = mat;
		this.senha = senha;
	}
	private static String Ins = "ins";
	private static String senhaIns = "ins";
	private static String Adm = "adm";
	private static String senhaAdm = "adm";
	private int mat;
	private String senha;
	
	public static String getIns(){
		return Ins;
	}
	public static String getSenhaIns(){
		return senhaIns;
	}
	
	public static String getAdm(){
		return Adm;
	}
	
	public static String getSenhaAdm(){
		return senhaAdm;
	}
	
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
