package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Connection.ConnectionFactoryMySQL;
import Dominio.Login;
import Dominio.Vendedor;
import View.TelaPrincipal;
import java.sql.Connection;



public class LoginDAO {
	
	Connection con;
	
	
	
	
	public LoginDAO() {
		ConnectionFactoryMySQL.getInstancia();
		con = ConnectionFactoryMySQL.getConexao();
	}

	public void autenticar(Login l, JFrame j) {
		if(l.getUser().equals("admin") && l.getPass().equals("admin")) {
			TelaPrincipal tp = new TelaPrincipal();
			tp.getFrmTelaPrincipal().setVisible(true);
			j.dispose();

		}else {
			JOptionPane.showMessageDialog(j, "Erro na autenticação!");
		}
	}
	
	public String getSenha(String cpf, JFrame j) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String senha = null;
		String sql = "SELECT senha FROM vendedor WHERE usuario ="+ cpf +";";
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
	
	public Vendedor getUser(String cpf, JFrame j) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Vendedor vendedor = new Vendedor();
		String sql = "SELECT * FROM vendedor WHERE cpf ="+ cpf +";";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				vendedor.setCpf(rs.getString("cpf"));
				vendedor.setSenha(rs.getString("senha"));
			}
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Usuário inválido!");
		}
		
		return vendedor;
	}
	
}
