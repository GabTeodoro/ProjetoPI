package model;

public class CartaoCredito {
	
	private int idcartao;
	private String nomeTit;
	private String numero;
	private String dataVenc;
	private String codSeg;
	//Construtores
	public CartaoCredito() {
		
	}
	public CartaoCredito(int idcartao,String numero, String dataVenc, String codSeg, String nomeTit) {
		this.idcartao = idcartao;
		this.numero = numero;
		this.dataVenc = dataVenc;
		this.codSeg = codSeg;
		this.nomeTit = nomeTit;
		
	}

	//seters
	public void setIdcartao(int idcartao) {
		this.idcartao = idcartao;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setCodSeg(String codSeg) {
		this.codSeg = codSeg;
	}
	public void setDataVenc(String dataVenc) {
		this.dataVenc = dataVenc;
	}
	public void setNomeTit(String nomeTit) {
		this.nomeTit = nomeTit;
	}
	//getters
	public int getIdcartao() {
		return idcartao;
	}
	public String getDataVenc() {
		return dataVenc;
	}
	
	public String getCodSeg() {
		return codSeg;
	}
	public String getNumero() {
		return numero;
	}
	public String getNomeTit() {
		return nomeTit;
	}
	@Override
	public String toString() {
		return "CartaoCredito [Nome do Titular= " + nomeTit + "Numero= " + numero + ", Data de Vencimento= " + dataVenc + ", Cod Segurança =" + codSeg + "]";
	
	}
	
	
	
}
