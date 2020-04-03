package model;

public class Endereco {
	private int idCliente;
	private String estado;
	private String cidade;
	private String bairro;
	private int tel;
	private String comp;
	private String num;
	private String rua;
	private int cep;
	//construtores
	public Endereco() {
	
	}
	public Endereco(int idCliente, String estado, String cidade, String bairro, int tel, String comp, String num,
			String rua, int cep) {
		this.idCliente = idCliente;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.tel = tel;
		this.comp = comp;
		this.num = num;
		this.rua = rua;
		this.cep = cep;
	}

	//setters
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public void setComp(String comp) {
		this.comp = comp;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public void setCep(int cep) {
		this.cep = cep;
	}
	//getters
	public int getIdCliente() {
		return idCliente;
	}
	public String getEstado() {
		return estado;
	}
	public String getCidade() {
		return cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public int getTel() {
		return tel;
	}
	public String getComp() {
		return comp;
	}
	public String getNum() {
		return num;
	}
	public String getRua() {
		return rua;
	}
	public int getCep() {
		return cep;
	}
	@Override
	public String toString() {
		return "Endereco [idCliente=" + idCliente + ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro
				+ ", tel=" + tel + ", comp=" + comp + ", num=" + num + ", rua=" + rua + ", cep=" + cep + "]";
	}
	
}
