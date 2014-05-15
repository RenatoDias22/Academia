import java.text.SimpleDateFormat;
import java.util.Date;


public class Cliente extends Cadastro {
	String nome;
	private Ficha ficha;
	private int mensalidadeVencimento;
	public Cliente(){ ficha = new Ficha(); }
	
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
		super(nome, matricula, sexo, rG, cPF, endereco, cEP, numeroCasa, bairro, complemento, cidade,
				estado, eMail, telefone, celular, dataNascimento);
		if(ficha != null) this.ficha = ficha;
		else this.ficha = new Ficha();
		this.mensalidadeVencimento = mensalidadeVencimento;
	}

	public String toString(){
		return nome+";"+matricula+";"+mensalidadeVencimento+";"+ficha +";"+sexo+";"+RG+";"+CPF+";"+endereco+";"+CEP+";"+numeroCasa+";"+bairro+";"+complemento+";"+Cidade+";" +Estado+";" +eMail+";"+telefone+ ";" +Celular+";"+new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento);
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
	
}