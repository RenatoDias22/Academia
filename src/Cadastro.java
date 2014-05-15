import java.util.Date;

public class Cadastro {

	protected String nome;
	protected char sexo;
	protected int matricula;
	protected String RG;
	protected String CPF;
	protected String endereco;
	protected String CEP;
	protected String numeroCasa;
	protected String bairro;
	protected String complemento;
	protected String Cidade;
	protected String Estado;
	protected String eMail;
	protected String telefone;
	protected String Celular;
	protected Date dataNascimento;
	
	public Cadastro() { }

	public Cadastro(String nome, int matricula, char sexo,
			String rG, String cPF, String endereco, String cEP,
			String numeroCasa, String bairro, String complemento,
			String cidade, String estado, String eMail, String telefone,
			String celular, Date dataNascimento) {
		this.nome = nome;
		this.sexo = sexo;
		this.matricula = matricula;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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