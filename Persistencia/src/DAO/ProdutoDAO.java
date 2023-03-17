package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Connection.ConnectionFactoryMySQL;
import Dominio.Produto;

public class ProdutoDAO {

	Connection con;
	
	public ProdutoDAO() {
		ConnectionFactoryMySQL.getInstancia();
		con = ConnectionFactoryMySQL.getConexao();
	}
	
	//Método CREATE

	public void Create(Produto produto, JFrame j) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO produto(descricao, codBarras, custo, venda) Values(?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getDescricao());
			stmt.setString(2, produto.getCodBarras());
			stmt.setFloat(3, produto.getCusto());
			stmt.setFloat(4, produto.getVenda());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(j, "Produto cadastrado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Produto não cadastrado, erro: "+ e.getMessage());
		}
	}
	
	//Método READ
	public ArrayList<Produto> Read(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM produto";
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			while(rs.next()) {
				Produto p  = new Produto();
				p.setIdProduto(rs.getLong("idProduto"));
				p.setDescricao(rs.getString("descricao"));
				p.setCodBarras(rs.getString("codBarras"));
				p.setCusto(rs.getFloat("custo"));
				p.setVenda(rs.getFloat("venda"));
				produtos.add(p);
			}
		}catch(SQLException e) {
			System.out.println("Falha ao consultar dados, erro: " + e.getMessage());
		}
		
		return produtos;
		
	}
	
	
	//Método consultar por descrição
	public ArrayList<Produto> ConsultarPorDescricao(String descricao){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM produto WHERE descricao LIKE '%"+ descricao +"%'";
		ArrayList<Produto> produtos = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			while(rs.next()) {
				Produto p  = new Produto();
				p.setIdProduto(rs.getLong("idProduto"));
				p.setDescricao(rs.getString("descricao"));
				p.setCodBarras(rs.getString("codBarras"));
				p.setCusto(rs.getFloat("custo"));
				p.setVenda(rs.getFloat("venda"));
				produtos.add(p);
			}
		}catch(SQLException e) {
			System.out.println("Falha ao consultar dados, erro: " + e.getMessage());
		}
		
		return produtos;
		
	}
	
	//Operação de delete (exclusão)
	public void delete(String codBarras) {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM produto WHERE codBarras = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, codBarras);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dado excluido com sucesso!");
			
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage() + " codigo lido: " + codBarras);
		}
	}
	
	//Método de update
	public void update(Produto p) {
		PreparedStatement stmt;
		String sql = "UPDATE produto SET descricao = ?, codBarras = ? , custo = ?, venda = ? WHERE idProduto=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getDescricao());
			stmt.setString(2, p.getCodBarras());
			stmt.setFloat(3, p.getCusto());
			stmt.setFloat(4, p.getVenda());
			stmt.setLong(5, p.getIdProduto());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Dado atualizado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar dado: " + e.getMessage());
		}
		
	}
	
	
}
