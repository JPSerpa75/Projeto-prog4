package Dominio;

public class ItemPedido {
	
	private Long idItemPedido;
	private Pedido pedido;
	private Produto produto;
	private Float precoTotalItem;
	private Float quantidade;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido(Long idItemPedido, Pedido pedido, Produto produto, Float precoTotalItem, Float quantidade) {
		super();
		this.idItemPedido = idItemPedido;
		this.pedido = pedido;
		this.produto = produto;
		this.precoTotalItem = precoTotalItem;
		this.quantidade = quantidade;
	}
	
	
	public Long getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Float getPrecoTotalItem() {
		return precoTotalItem;
	}
	public void setPrecoTotalItem(Float precoTotalItem) {
		this.precoTotalItem = precoTotalItem;
	}
	public Float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	
	
	
}
