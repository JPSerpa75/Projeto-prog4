package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Connection.ConnectionFactoryMySQL;
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
}
