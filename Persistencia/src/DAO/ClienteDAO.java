package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Connection.ConnectionFactoryMySQL;
import Dominio.Cliente;
import Dominio.Produto;
import Dominio.Vendedor;

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
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getEmail());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(j, "Cliente cadastrado com sucesso!");
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(j, "Cliente não cadastrado, erro: "+ e.getMessage());
		}
	}
	
	//Método READ
		public ArrayList<Cliente> Read(){
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM cliente";
			ArrayList<Cliente> clientes = new ArrayList<>();
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				System.out.println("Dados capturados com sucesso!");
				while(rs.next()) {
					Cliente c  = new Cliente();
					c.setIdCliente(rs.getLong("idCliente"));
					c.setNome(rs.getString("Nome"));
					c.setCpf(rs.getString("CPF"));
					c.setEndereco(rs.getString("Endereco"));
					c.setTelefone(rs.getString("Telefone"));
					c.setEmail(rs.getString("email"));
					clientes.add(c);
				}
			}catch(SQLException e) {
				System.out.println("Falha ao consultar dados, erro: " + e.getMessage());
			}
			
			return clientes;
			
		}
		
		
		//Método consultar por descrição
		public ArrayList<Cliente> ConsultarPorNome(String nome, JFrame j){
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM cliente WHERE Nome LIKE '%"+ nome +"%'";
			ArrayList<Cliente> clientes = new ArrayList<>();
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				System.out.println("Dados capturados com sucesso!");
				while(rs.next()) {
					Cliente c  = new Cliente();
					c.setIdCliente(rs.getLong("idCliente"));
					c.setNome(rs.getString("Nome"));
					c.setCpf(rs.getString("CPF"));
					c.setEndereco(rs.getString("Endereco"));
					c.setTelefone(rs.getString("Telefone"));
					c.setEmail(rs.getString("email"));
					clientes.add(c);
				}
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(j, "Falha ao consultar dados, erro: " + e.getMessage());
			}
			
			return clientes;
			
		}
		
		//Operação de delete (exclusão)
		public void delete(Long id, JFrame j) {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "DELETE FROM cliente WHERE idCliente = ?";
			String busca = "SELECT * FROM pedido WHERE idCliente = ?";
			try {
				int confirma = JOptionPane.showConfirmDialog(j, "Confirma a exclusão?", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
				if(confirma==0) {
					stmt = con.prepareStatement(busca);
					stmt.setLong(1, id);
					rs = stmt.executeQuery();
					if(!rs.next()) {
						stmt = con.prepareStatement(sql);
						stmt.setLong(1, id);
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(j, "Cliente excluido com sucesso!");
					}else {
						JOptionPane.showMessageDialog(j, "Operação cancelada, o cliente está vinculado a um pedido!");
					}
					
				}else {
					JOptionPane.showMessageDialog(j, "Operação cancelada!");
				}
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(j, "Erro ao excluir: " + e.getMessage());
			}
		}
		
		//Método de update
		public void update(Cliente c, JFrame j) {
			PreparedStatement stmt;
			String sql = "UPDATE cliente SET Nome = ?, email = ? , Endereco = ?,  CPF = ?, Telefone = ? WHERE idCliente=?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, c.getNome());
				stmt.setString(2, c.getEmail());
				stmt.setString(3, c.getEndereco());
				stmt.setString(4, c.getCpf());
				stmt.setString(5, c.getTelefone());
				stmt.setFloat(6, c.getIdCliente());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(j, "Dado atualizado com sucesso!");
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(j, "Erro ao atualizar dado: " + e.getMessage());
			}
			
		}
		
		public Cliente getClienteId(Long id, JFrame j) {
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Cliente cliente = new Cliente();
			String sql = "SELECT * FROM cliente WHERE idCliente ="+ id +";";
			try {
				stmt = con.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					cliente.setIdCliente(rs.getLong("idCliente"));
					cliente.setNome(rs.getString("Nome"));
					cliente.setCpf(rs.getString("CPF"));
					cliente.setEndereco(rs.getString("Endereco"));
					cliente.setTelefone(rs.getString("Telefone"));
					cliente.setEmail(rs.getString("email"));
				}
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(j, "Falha ao consultar dados, erro: " + e.getMessage());
			}
			
			return cliente;
		}
	
}
