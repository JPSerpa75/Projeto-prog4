package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Connection.ConnectionFactoryMySQL;
import Dominio.Cliente;

public class ClienteDAO {

	Connection con;
	
	public ClienteDAO() {
		ConnectionFactoryMySQL.getInstancia();
		con = ConnectionFactoryMySQL.getConexao();
		
	}
	
	//Método CREATE
	public void Create(Cliente cliente, JFrame j) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO cliente(nome, cpf, endereco, telefone, email) Values(?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getEmail());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(j, "Cliente cadastrado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Cliente não cadastrado, erro: "+ e.getMessage());
		}
	}
	
}
