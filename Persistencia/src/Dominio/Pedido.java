package Dominio;

import java.time.LocalDateTime;

public class Pedido {

	private Long idPedido;
	private Float precoTotalPedido;
	private LocalDateTime dataPedido;
	
	//Aqui vai ligação com cliente,
	//Aqui vai ligação com funcionário
	
	public Pedido() {
		
	}
	
	public Pedido(Long idPedido, Float precoTotalPedido, LocalDateTime dataPedido) {
		super();
		this.idPedido = idPedido;
		this.precoTotalPedido = precoTotalPedido;
		this.dataPedido = dataPedido;
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
