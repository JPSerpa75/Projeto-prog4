package Dominio;

public class Produto {

	private Long idProduto;
	private String descricao;
	private String codBarras;
	private Float custo;
	private Float venda;

	public Produto() {
	}
	
	public Produto( String descricao, String codBarras, Float custo, Float venda) {
		this.descricao = descricao;
		this.codBarras = codBarras ;
		this.custo = custo;
		this.venda = venda;
	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public Float getCusto() {
		return custo;
	}
	public void setCusto(Float custo) {
		this.custo = custo;
	}
	public Float getVenda() {
		return venda;
	}
	public void setVenda(Float venda) {
		this.venda = venda;
	}
	
	
}
