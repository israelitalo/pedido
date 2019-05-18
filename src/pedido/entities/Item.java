package pedido.entities;

public class Item {

	private Integer quantidade;
	private Double preco;
	private Produto produto;
	
	public Item(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public Double subTotal() {
		return quantidade * preco;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Produto: " + produto.getNome() + ", " + "Quantidade: " + quantidade + ", Preço: " + preco + ", Total: R$ " + String.format("%.2f\n", subTotal());
	}

}
