import java.text.SimpleDateFormat;
import java.util.Date;


public class Cliente {
	private char sexo;
	private String nome;
	private int matricula;
	private Ficha ficha;
	private int mensalidadeVencimento;
	private String RG;
	private String CPF;
	//Informações de contato.
	private String endereco; private String CEP;private String numeroCasa;private String bairro;private String complemento;private String Cidade;
	private String Estado; private String eMail;private String telefone;private String Celular;
	private Date dataNascimento;
	
	public Cliente(){ficha = new Ficha();}
	
	public Cliente(char sexo, String nome, int matricula, Ficha ficha,
			int mensalidadeVencimento, String rG, String cPF, String endereco,
			String cEP, String numeroCasa, String bairro, String cidade,
			String estado, String eMail, Date dataNascimento) {
		super();
		this.sexo = sexo;
		this.nome = nome;
		this.matricula = matricula;
		if(ficha != null) this.ficha = ficha;
		else this.ficha = new Ficha();
		this.mensalidadeVencimento = mensalidadeVencimento;
		RG = rG;
		CPF = cPF;
		this.endereco = endereco;
		CEP = cEP;
		this.numeroCasa = numeroCasa;
		this.bairro = bairro;
		Cidade = cidade;
		Estado = estado;
		this.eMail = eMail;
		this.dataNascimento = dataNascimento;
	}

	public Cliente( String nome, int matricula,int mensalidadeVencimento, Ficha ficha, 
			char sexo, String rG, String cPF, String endereco,
			String cEP, String numeroCasa, String bairro, String complemento,
			String cidade, String estado, String eMail, String telefone,
			String celular, Date dataNascimento) {
		super();
		this.sexo = sexo;
		this.nome = nome;
		this.matricula = matricula;
		if(ficha != null) this.ficha = ficha;
		else this.ficha = new Ficha();
		this.mensalidadeVencimento = mensalidadeVencimento;
		RG = rG;
		CPF = cPF;
		this.endereco = endereco;
		CEP = cEP;
		this.numeroCasa = numeroCasa;
		this.bairro = bairro;
		this.complemento = complemento;
		Cidade = cidade;
		Estado = estado;
		this.eMail = eMail;
		this.telefone = telefone;
		Celular = celular;
		this.dataNascimento = dataNascimento;
	}

	public String toString(){
		return nome+";"+matricula+";"+mensalidadeVencimento+";"+ficha +";"+sexo+";"+RG+";"+CPF+";"+endereco+";"+CEP+";"+numeroCasa+";"+bairro+";"+complemento+";"+Cidade+";" +Estado+";" +eMail+";"+telefone+ ";" +Celular+";"+new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento);
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public int getMensalidadeVencimento() {
		return mensalidadeVencimento;
	}

	public void setMensalidadeVencimento(int mensalidadeVencimento) {
		this.mensalidadeVencimento = mensalidadeVencimento;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}



	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getCelular() {
		return Celular;
	}

	public void setCelular(String celular) {
		Celular = celular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
	
}