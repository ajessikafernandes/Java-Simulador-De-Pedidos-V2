package entidades;

public class OrderItem {

	private double preco;
	private int quantidade;
	private Produto produto;
	
	public OrderItem() {
	
	}
	
	public OrderItem (double preco, int quantidade, Produto produto) {
		this.preco = preco;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double subTotal() {
		return preco * quantidade;
	}
	
}
