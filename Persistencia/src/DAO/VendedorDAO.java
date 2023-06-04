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
import Dominio.Vendedor;

public class VendedorDAO {
	
Connection con;
	
	public VendedorDAO() {
		ConnectionFactoryMySQL.getInstancia();
		con = ConnectionFactoryMySQL.getConexao();
		
	}
	
	public void Create(Vendedor vendedor, JFrame j) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO vendedor(nome, cpf, usuario, telefone, senha) Values(?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, vendedor.getNome());
			stmt.setString(2, vendedor.getCpf());
			stmt.setString(3, vendedor.getUsuario());
			stmt.setString(4, vendedor.getTelefone());
			stmt.setString(5, vendedor.getSenha());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(j, "Vendedor cadastrado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Vendedor não cadastrado, erro: "+ e.getMessage());
		}
	}
	
	public ArrayList<Vendedor> GetVendedorNome(String nome, JFrame j) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Vendedor> vendedores = new ArrayList<>();
		String sql = "SELECT * FROM vendedor WHERE nome LIKE '%"+ nome +"%'";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Vendedor v  = new Vendedor();
				v.setIdVendedor(rs.getInt("idVendedor"));
				v.setNome(rs.getString("nome"));
				v.setTelefone(rs.getString("telefone"));
				v.setCpf(rs.getString("cpf"));
				v.setUsuario(rs.getString("usuario"));
				v.setSenha(rs.getString("senha"));
				vendedores.add(v);
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Falha ao consultar dados, erro: " + e.getMessage());
		}
		
		return vendedores;
	}

	public void update(Vendedor v, JFrame frame) {
		PreparedStatement stmt;
		String sql = "UPDATE vendedor SET nome = ?, usuario = ? , telefone = ?, cpf = ? WHERE idVendedor=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getUsuario());
			stmt.setString(3, v.getTelefone());
			stmt.setString(4, v.getCpf());
			stmt.setLong(5, v.getIdVendedor());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(frame, "Dados atualizado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro ao atualizar dados: " + e.getMessage());
		}
	}

	public void delete(Long id, JFrame frmConsultarVendedor) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "DELETE FROM vendedor WHERE idVendedor = ?";
		String busca = "SELECT * FROM pedido WHERE idVendedor = ?";
		try {
			int confirma = JOptionPane.showConfirmDialog(frmConsultarVendedor, "Confirma a exclusão?", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
			if(confirma==0) {
				stmt = con.prepareStatement(busca);
				stmt.setLong(1, id);
				rs = stmt.executeQuery();
				if(!rs.next()) {
					stmt = con.prepareStatement(sql);
					stmt.setLong(1, id);
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(frmConsultarVendedor, "Vendedor excluido com sucesso!");
				}else {
					JOptionPane.showMessageDialog(frmConsultarVendedor, "Operação cancelada, o vendedor está vinculado a um pedido!");
				}
				
			}else {
				JOptionPane.showMessageDialog(frmConsultarVendedor, "Operação cancelada!");
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(frmConsultarVendedor, "Erro ao excluir: " + e.getMessage());
		}
		
	}
	
	public String getSenha(Long id, JFrame j) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String senha = null;
		String sql = "SELECT senha FROM vendedor WHERE idVendedor ="+ id +";";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				senha = rs.getString("senha");
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Falha ao consultar dados, erro: " + e.getMessage());
		}
		
		return senha;
	}
	
	public Vendedor getVendedorId(Long id, JFrame j) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Vendedor vendedor = new Vendedor();
		String sql = "SELECT * FROM vendedor WHERE idVendedor ="+ id +";";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				vendedor.setIdVendedor(rs.getInt("idVendedor"));
				vendedor.setNome(rs.getString("nome"));
				vendedor.setTelefone(rs.getString("telefone"));
				vendedor.setCpf(rs.getString("cpf"));
				vendedor.setUsuario(rs.getString("usuario"));
				vendedor.setSenha(rs.getString("senha"));
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Falha ao consultar dados, erro: " + e.getMessage());
		}
		
		return vendedor;
	}

	public void updateSenha(String senhaCripto, Long id, JFrame frame) {
		PreparedStatement stmt;
		String sql = "UPDATE vendedor SET senha = ? WHERE idVendedor=?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, senhaCripto);
			stmt.setLong(2, id);
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(frame, "Senha alterada com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro ao atualizar dados: " + e.getMessage());
		}
	}
	
}
