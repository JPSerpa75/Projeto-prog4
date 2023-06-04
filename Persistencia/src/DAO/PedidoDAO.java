package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Connection.ConnectionFactoryMySQL;
import Dominio.ItemPedido;
import Dominio.Pedido;

public class PedidoDAO {

	Connection con;

	public PedidoDAO() {
		ConnectionFactoryMySQL.getInstancia();
		con = ConnectionFactoryMySQL.getConexao();
	}

	public void Create(Pedido pedido, List<ItemPedido> itensPedido, JFrame j) {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO pedido(precoTotal, data, idCliente, idVendedor) VALUES(?, ?, ?, ?)";
			stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setFloat(1, pedido.getPrecoTotalPedido());
			stmt.setObject(2, pedido.getDataPedido());
			stmt.setLong(3, pedido.getCliente().getIdCliente());
			stmt.setLong(4, pedido.getVendedor().getIdVendedor());
			stmt.executeUpdate();

			Long idPedido;
			ResultSet generatedKeys = stmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				idPedido = generatedKeys.getLong(1);
			} else {
				throw new SQLException("Erro ao gerar id para o pedido", "");
			}
			generatedKeys.close();

			for (ItemPedido ip : itensPedido) {
				PreparedStatement stmtItem = null;
				try {
					String sqlItem = "INSERT INTO itemPedido(idPedido, idProduto, preco, quantidade) VALUES(?, ?, ?, ?)";
					stmtItem = con.prepareStatement(sqlItem, Statement.RETURN_GENERATED_KEYS);
					stmtItem.setLong(1, idPedido);
					stmtItem.setLong(2, ip.getProduto().getIdProduto());
					stmtItem.setFloat(3, ip.getPrecoTotalItem());
					stmtItem.setFloat(4, ip.getQuantidade());
					stmtItem.executeUpdate();

				} catch (SQLException e) {
					throw new SQLException(e.getMessage(), "");
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}

			}

			JOptionPane.showMessageDialog(j, "Pedido cadastrado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(j, "Pedido não cadastrado, erro: " + e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(j, "Erro interno, procure um responsável, erro: " + e.getMessage());
		}
	}

	public ArrayList<Pedido> search(String vendedor, String cliente, Float precoMin, Float precoMax, Long idPedido, JFrame j) {
		VendedorDAO vDAO = new VendedorDAO();
		ClienteDAO cDAO = new ClienteDAO();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT p.* FROM pedido p ");
		sql.append(" INNER JOIN cliente c ON c.idCliente = p.idCliente ");
		sql.append(" INNER JOIN vendedor v ON v.idVendedor = p.idVendedor ");
		sql.append(" WHERE 1=1 ");

		ArrayList<Pedido> pedidos = new ArrayList<>();

		if (!vendedor.isEmpty()) {
			sql.append(" AND v.nome LIKE '%" + vendedor + "%'");
		}
		if (!cliente.isEmpty()) {
			sql.append(" AND c.nome LIKE '%" + cliente + "%'");
		}
		if (!(precoMin == null)) {
			sql.append(" AND p.precoTotal > " + precoMin);
		}

		if (!(precoMax == null)) {
			sql.append(" AND p.precoTotal < " + precoMax);
		}
		
		if(!(idPedido == null)) {
			sql.append(" AND p.idPedido = " + idPedido);
		}

		try {
			stmt = con.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			System.out.println("Dados capturados com sucesso!");
			while (rs.next()) {
				Pedido p = new Pedido();
				p.setDataPedido((LocalDateTime) rs.getObject("data"));
				p.setPrecoTotalPedido(rs.getFloat("precoTotal"));
				p.setIdPedido(rs.getLong("idPedido"));
				p.setCliente( cDAO.getClienteId(rs.getLong("idCliente"), j));
				p.setVendedor(vDAO.getVendedorId(rs.getLong("idVendedor"), j));
				pedidos.add(p);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(j, "Falha ao consultar dados, Erro: " + e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(j, "Erro interno, procure um responsável, erro: " + e.getMessage());
		}

		return pedidos;
	}

	public void delete(Long idPedido, JFrame j) {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM itemPedido WHERE idPedido = ? ";
		try {
			int confirma = JOptionPane.showConfirmDialog(j, "Confirma a exclusão?", "Selecione uma opção",
					JOptionPane.YES_NO_OPTION);
			if (confirma == 0) {
				stmt = con.prepareStatement(sql);
				stmt.setLong(1, idPedido);
				stmt.executeUpdate();

				PreparedStatement stmtPedido = null;
				String sqlPedido = "DELETE FROM pedido WHERE idPedido = ?";
				stmtPedido = con.prepareStatement(sqlPedido);
				stmtPedido.setLong(1, idPedido);
				stmtPedido.executeUpdate();
				JOptionPane.showMessageDialog(j, "Dado excluido com sucesso!");
			} else {
				JOptionPane.showMessageDialog(j, "Operação cancelada!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(j, "Falha ao excluir pedido, Erro: " + e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(j, "Erro interno, procure um responsável, erro: " + e.getMessage());
		}

	}
	
	
	public ArrayList<ItemPedido> getAllItensPedidosByPedido(Long idPedido, JFrame j){
		ProdutoDAO pDao = new ProdutoDAO();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM itemPedido WHERE idPedido = " + idPedido;
		ArrayList<ItemPedido> itensPedidos = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ItemPedido ip = new ItemPedido();
				ip.setIdItemPedido(rs.getLong("idItemPedido"));
				ip.setPrecoTotalItem(rs.getFloat("preco"));
				ip.setQuantidade(rs.getFloat("quantidade"));
				ip.setProduto(pDao.ConsultarPorId(rs.getLong("idProduto"), j));
				itensPedidos.add(ip);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(j, "Falha ao carregar itens do pedido, Erro: " + e.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(j, "Erro interno, procure um responsável, erro: " + e.getMessage());
		}

		
		return itensPedidos;
		
		
	}
	

}
