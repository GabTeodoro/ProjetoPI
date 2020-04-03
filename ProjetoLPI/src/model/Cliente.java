package model;

public class Cliente {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String obs;
	
	//construtores
	public Cliente() {
		
	}
	public Cliente(int id, String nome, String email, String senha, String cpf, String obs) {
	 this.id=id;
	 this.nome=nome;
	 this.email=email;
	 this.senha=senha;
	 this.cpf=cpf;
	 this.obs=obs;
	}
	
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}
	//getters
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getObs() {
		return obs;
	}
	public String getCpf() {
		return cpf;
	}
	public String getSenha() {
		return senha;
	}
	
	@Override
	public String toString() {
		return "Cliente [Id=" + id + ", Nome=" + nome + ", Email=" + email + ", CPF=" + cpf
				+ ", Senha=" + senha + ", Obs=" + obs + "]";
	}

}
