package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.PedidoDAO;
import Dominio.ItemPedido;

public class TelaVisualizarPedido extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmVisualizarPedido;
	private JTextField txtPrecoFinal;

	private JTable table;
	private JTextField txtVendedor;
	private JTextField txtCliente;
	private JTextField txtDataPedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVisualizarPedido window = new TelaVisualizarPedido(null);
					window.frmVisualizarPedido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaVisualizarPedido(Long idPedido) {
		initialize();
		if (idPedido != null) {
			loadTela(idPedido);
		}
	}

	private void loadTela(Long idPedido) {
		PedidoDAO dao = new PedidoDAO();

		var pedidos = dao.search("", "", null, null, idPedido, frmVisualizarPedido);
		var itensPedidos = dao.getAllItensPedidosByPedido(idPedido, frmVisualizarPedido);
		itensPedidos.forEach(x -> x.setPedido(pedidos.get(0)));

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);
		for (ItemPedido ip : itensPedidos) {
			tableModel.addRow(new Object[] { 
				ip.getProduto().getDescricao(), 
				ip.getProduto().getVenda(),
				ip.getQuantidade(), 
				ip.getPrecoTotalItem(),
			});
		}

		txtPrecoFinal.setText(Float.toString(pedidos.get(0).getPrecoTotalPedido()));
		// txtCliente.setText(pedidos.get(0).getCliente().getNome());
		// txtVendedor.setText(pedidos.get(0).getVendedor().getNome());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
		String data = pedidos.get(0).getDataPedido().format(formatter);
		txtDataPedido.setText(data);

	}

	public JFrame getFrmVisualizarPedido() {
		return frmVisualizarPedido;
	}

	public void setFrmVisualizarPedido(JFrame frmVisualizarPedido) {
		this.frmVisualizarPedido = frmVisualizarPedido;
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
		frmVisualizarPedido = new JFrame();
		frmVisualizarPedido.setTitle("Cadastro de Pedido");
		frmVisualizarPedido.setResizable(false);
		frmVisualizarPedido.getContentPane().setBackground(new Color(57, 54, 70));
		frmVisualizarPedido.setBounds(100, 100, 787, 544);
		frmVisualizarPedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVisualizarPedido.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Visualizar Pedido");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(0, 11, 761, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmVisualizarPedido.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 47, 761, 447);
		frmVisualizarPedido.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Cliente:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1.setBounds(45, 55, 54, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vendedor:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1_1.setBounds(28, 15, 71, 14);
		panel.add(lblNewLabel_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(105, 137, 618, 117);
		panel.add(panel_1);
		panel_1.setLayout(null);

		table = new JTable();

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(0, 0, 618, 117);
		panel_1.add(barraRolagem);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Produto", "Pre\u00E7o uni.", "Qtd", "Pre\u00E7o" }));

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

		txtVendedor = new JTextField();
		txtVendedor.setEditable(false);
		txtVendedor.setBounds(115, 12, 608, 20);
		panel.add(txtVendedor);
		txtVendedor.setColumns(10);

		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setColumns(10);
		txtCliente.setBounds(115, 52, 608, 20);
		panel.add(txtCliente);

		JLabel lblNewLabel_2 = new JLabel("Data do pedido:");
		lblNewLabel_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_2.setBounds(10, 95, 108, 14);
		panel.add(lblNewLabel_2);

		txtDataPedido = new JTextField();
		txtDataPedido.setEditable(false);
		txtDataPedido.setColumns(10);
		txtDataPedido.setBounds(115, 92, 215, 20);
		panel.add(txtDataPedido);

	}
}
