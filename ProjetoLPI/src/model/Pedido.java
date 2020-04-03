package model;
import java.util.*;;

public class Pedido {
	private int id;
	private String nome;
	private int idProduto;
	private int idCliente;
	private int quantidade;
	private Date data;
	private String obs;
	//private List<Item> itens = new ArrayList<Item>();

	
	//construtores
	public Pedido () {
		
	}
	
	public Pedido (int id, String nome, int idProduto, int idCliente, int quantidade, Date data, String obs) {
		this.nome = nome;
		this.id = id;
		this.idProduto = idProduto;
		this.idCliente = idCliente;
		this.quantidade = quantidade;
		this.data = data;
		this.obs = obs;
	}
	
	//metodos de acesso
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	/*public int getIdProduto () {
		return idProduto;
	}*/
	
	/*public int getIdCliente () {
		return idCliente;
	}*/
	
	public int getQuantidade () {
		return quantidade;
	}
	
	public Date getData () {
		return data;
	}
	
	public String getObs () {
		return obs;
	}
	
	//metodos modificadores
	public void setId (int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/*public void setIdProduto (int idProduto) {
		this.idProduto = idProduto;
	}*/
	
	/*public void setIdCliente (int idCliente) {
		this.idCliente = idCliente;
	}*/
	
	public void setQuantidade (int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setData (Date data) {
		this.data = data;
	}
	
	public void setObs(String obs) {
		this.obs = obs;
	}
	
	//adicionar itens
	/*public void adiciona(Item item) {
	    itens.add(item);   
	}*/
	
	//tostring
	public String toString () {
		return "Informcoes do Pedido: \n Id: " + id + "\n nome: " + nome + "\n idProduto: " + idProduto + "\n idCliente:" + idCliente + "\n Quantidade: " + "\n Data:" + data + "\n Observacao:" + obs;
	}
}
