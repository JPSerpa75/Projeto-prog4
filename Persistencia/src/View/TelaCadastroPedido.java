package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import DAO.VendedorDAO;
import Dominio.Cliente;
import Dominio.ItemPedido;
import Dominio.Pedido;
import Dominio.Produto;
import Dominio.Vendedor;

public class TelaCadastroPedido extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmCadastroDePedido;
	private JTextField txtQtd;
	private JTextField txtPrecoFinal;

	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPedido window = new TelaCadastroPedido();
					window.frmCadastroDePedido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroPedido() {
		initialize();
	}

	private void atualizaBusca(List<ItemPedido> ItensPedidos, Pedido pedido) {

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);

		Float soma = (float) 0;

		for (ItemPedido ip : ItensPedidos) {
			soma += ip.getPrecoTotalItem();

			tableModel.addRow(new Object[] { 
				ip.getProduto().getDescricao(), 
				ip.getProduto().getVenda(),
				ip.getQuantidade(), 
				ip.getPrecoTotalItem(), 
			});
		}

		pedido.setPrecoTotalPedido(soma);
		txtPrecoFinal.setText(Float.toString(pedido.getPrecoTotalPedido()));

		if (tableModel.getRowCount() == 0) {
			JOptionPane.showMessageDialog(frmCadastroDePedido, "Nenhum produto foi encontrado!");
		}
	}

	public JFrame getFrmCadastroDePedido() {
		return frmCadastroDePedido;
	}

	public void setFrmCadastroDePedido(JFrame frmCadastroDePedido) {
		this.frmCadastroDePedido = frmCadastroDePedido;
	}

	public JTextField getTextField() {
		return txtQtd;
	}

	public void setTextField(JTextField textField) {
		this.txtQtd = textField;
	}

	public JTextField getTextField_1() {
		return txtPrecoFinal;
	}

	public void setTextField_1(JTextField textField_1) {
		this.txtPrecoFinal = textField_1;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDePedido = new JFrame();
		frmCadastroDePedido.setTitle("Cadastro de Pedido");
		frmCadastroDePedido.setResizable(false);
		frmCadastroDePedido.getContentPane().setBackground(new Color(57, 54, 70));
		frmCadastroDePedido.setBounds(100, 100, 787, 544);
		frmCadastroDePedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDePedido.getContentPane().setLayout(null);

		List<ItemPedido> ItensProdutos = new ArrayList<>();
		Pedido pedido = new Pedido();

		JLabel lblNewLabel = new JLabel("Cadastro de Pedido");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(0, 11, 761, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmCadastroDePedido.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 47, 761, 447);
		frmCadastroDePedido.getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox<Produto> cbbProdutos = new JComboBox<Produto>();
		cbbProdutos.setBackground(new Color(244, 238, 224));
		ProdutoDAO pDAO = new ProdutoDAO();
		for (Produto p : pDAO.Read()) {
			cbbProdutos.addItem(p);
		}

		cbbProdutos.setBounds(84, 95, 345, 22);
		panel.add(cbbProdutos);

		JComboBox<Cliente> cbbClientes = new JComboBox<Cliente>();
		ClienteDAO cDAO = new ClienteDAO();
		for (Cliente c : cDAO.Read()) {
			cbbClientes.addItem(c);
		}
		cbbClientes.setBounds(84, 51, 618, 22);
		panel.add(cbbClientes);

		JLabel lblNewLabel_1_1 = new JLabel("Cliente:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1.setBounds(0, 55, 71, 14);
		panel.add(lblNewLabel_1_1);

		JComboBox<Vendedor> cbbVendedor = new JComboBox<Vendedor>();
		cbbVendedor.setBackground(new Color(244, 238, 224));
		VendedorDAO vDAO = new VendedorDAO();
		for (Vendedor c : vDAO.GetVendedorNome("", frmCadastroDePedido)) {
			cbbVendedor.addItem(c);
		}
		cbbVendedor.setBounds(84, 11, 618, 22);
		panel.add(cbbVendedor);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vendedor:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1_1.setBounds(0, 15, 71, 14);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Produto:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1_2.setBounds(0, 99, 71, 14);
		panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Quantidade:");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1_2_1.setBounds(439, 99, 71, 14);
		panel.add(lblNewLabel_1_1_2_1);

		txtQtd = new JTextField();
		txtQtd.setBounds(520, 96, 49, 20);
		panel.add(txtQtd);
		txtQtd.setColumns(10);

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtQtd.getText().trim().length() > 0) {
					ItemPedido ip = new ItemPedido();
					ip.setProduto((Produto) cbbProdutos.getSelectedItem());
					ip.setQuantidade(Float.valueOf(txtQtd.getText()));
					ip.setPrecoTotalItem(ip.getProduto().getVenda() * ip.getQuantidade());
					ItensProdutos.add(ip);
					atualizaBusca(ItensProdutos, pedido);
					txtQtd.setText("");
				} else {
					JOptionPane.showMessageDialog(frmCadastroDePedido, "Quantidade não pode ser vazia!");
				}

			}
		});
		btnNewButton.setBounds(612, 95, 90, 23);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(84, 138, 618, 117);
		panel.add(panel_1);
		panel_1.setLayout(null);

		table = new JTable();

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(0, 0, 618, 117);
		panel_1.add(barraRolagem);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Produto", "Pre\u00E7o uni.", "Qtd", "Pre\u00E7o" }));


		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = table.getSelectedRow();
				if (id >= 0) {
					ItensProdutos.remove(id);
					atualizaBusca(ItensProdutos, pedido);
				} else {
					JOptionPane.showMessageDialog(frmCadastroDePedido, "Selecione uma linha da tabela para excluir!");
				}

			}
		});
		btnRemover.setBounds(455, 348, 94, 23);
		panel.add(btnRemover);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = table.getSelectedRow();
				if (id >= 0) {
					Produto p = ItensProdutos.get(id).getProduto();
					cbbProdutos.setSelectedItem(p);
					txtQtd.setText(Float.toString(ItensProdutos.get(id).getQuantidade()));
					ItensProdutos.remove(id);
					atualizaBusca(ItensProdutos, pedido);
				} else {
					JOptionPane.showMessageDialog(frmCadastroDePedido, "Selecione uma linha da tabela para editar!");
				}
			}
		});
		btnEditar.setBounds(351, 348, 94, 23);
		panel.add(btnEditar);

		JButton btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPrecoFinal.getText().trim().length() > 0 || cbbClientes.getSelectedItem() == null
						|| cbbVendedor.getSelectedItem() == null) {
					PedidoDAO pDAO = new PedidoDAO();
					pedido.setDataPedido(LocalDateTime.now());
					pedido.setCliente((Cliente) cbbClientes.getSelectedItem());
					pedido.setVendedor((Vendedor) cbbVendedor.getSelectedItem());
					pedido.setPrecoTotalPedido(Float.valueOf(txtPrecoFinal.getText()));

					pDAO.Create(pedido, ItensProdutos, frmCadastroDePedido);
				} else {
					JOptionPane.showMessageDialog(frmCadastroDePedido, "Campos Obrigatorios não preenchidos!");
				}

			}
		});
		btnFinalizarPedido.setBounds(575, 348, 127, 23);
		panel.add(btnFinalizarPedido);

		txtPrecoFinal = new JTextField();
		txtPrecoFinal.setEditable(false);
		txtPrecoFinal.setBounds(551, 284, 151, 20);
		panel.add(txtPrecoFinal);
		txtPrecoFinal.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Preço Total:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(464, 287, 85, 14);
		panel.add(lblNewLabel_1);

	}
}
