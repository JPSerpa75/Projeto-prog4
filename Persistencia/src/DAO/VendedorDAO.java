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
			JOptionPane.showMessageDialog(frame, "Dado atualizado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(frame, "Erro ao atualizar dados: " + e.getMessage());
		}
		
		
	}
	
	
}
