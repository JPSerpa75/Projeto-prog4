package Dominio;

import java.time.LocalDateTime;

public class Pedido {

	private Long idPedido;
	private Float precoTotalPedido;
	private LocalDateTime dataPedido;
	private Cliente cliente;
	private Vendedor vendedor;

	public Pedido() {

	}

	public Pedido(Long idPedido, Float precoTotalPedido, LocalDateTime dataPedido, Cliente cliente, Vendedor vendedor) {
		super();
		this.idPedido = idPedido;
		this.precoTotalPedido = precoTotalPedido;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Float getPrecoTotalPedido() {
		return precoTotalPedido;
	}

	public void setPrecoTotalPedido(Float precoTotalPedido) {
		this.precoTotalPedido = precoTotalPedido;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

}
