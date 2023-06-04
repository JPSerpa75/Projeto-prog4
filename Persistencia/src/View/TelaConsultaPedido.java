package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.PedidoDAO;
import Dominio.Pedido;

public class TelaConsultaPedido extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame FrmConsultaPedido;
	private JTextField txtVendedor;
	private JTextField txtCliente;
	private JTextField txtPrecoMin;
	private JTable table;
	private JTextField txtPrecoMax;

	
	public JFrame getFrmConsultaPedido() {
		return FrmConsultaPedido;
	}

	public void setFrmConsultaPedido(JFrame frmConsultaPedido) {
		FrmConsultaPedido = frmConsultaPedido;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaPedido window = new TelaConsultaPedido();
					window.FrmConsultaPedido.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaPedido() {
		initialize();
		atualizaBusca();
	}

	private void atualizaBusca() {
		PedidoDAO dao = new PedidoDAO();
		Long idPedido = null;
		String vendedor = txtVendedor.getText();
		String cliente = txtCliente.getText();
		Float precoMin = null;
		Float precoMax = null;
		if(!(txtPrecoMin.getText().isEmpty())){
			precoMin = Float.valueOf(txtPrecoMin.getText());
		}
		if(!(txtPrecoMax.getText().isEmpty())){
			precoMax = Float.valueOf(txtPrecoMax.getText());
		}
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);
		for (Pedido p : dao.search(vendedor, cliente, precoMin, precoMax, idPedido, FrmConsultaPedido)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
	        String data = p.getDataPedido().format(formatter);		
			
			tableModel.addRow(new Object[] { 
				p.getIdPedido(), 
				p.getVendedor().getNome(), 
				p.getCliente().getNome(),
				data, 
				p.getPrecoTotalPedido() 		
			});
		}

		if (tableModel.getRowCount() == 0) {
			JOptionPane.showMessageDialog(FrmConsultaPedido, "Nenhum pedido foi encontrado!");
		}

		txtCliente.setText("");
		txtVendedor.setText("");
		txtPrecoMax.setText("");
		txtPrecoMin.setText("");

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FrmConsultaPedido = new JFrame();
		FrmConsultaPedido.setTitle("Consultar pedidos");
		FrmConsultaPedido.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		FrmConsultaPedido.setResizable(false);
		FrmConsultaPedido.getContentPane().setBackground(new Color(57, 54, 70));
		FrmConsultaPedido.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 603, 488);
		FrmConsultaPedido.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Consulta de pedidos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 583, 37);
		panel.add(lblNewLabel);

		txtVendedor = new JTextField();
		txtVendedor.setBounds(102, 48, 469, 20);
		panel.add(txtVendedor);
		txtVendedor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Vendedor:");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(38, 48, 65, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_2.setBounds(51, 93, 52, 14);
		panel.add(lblNewLabel_2);

		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(102, 90, 469, 20);
		panel.add(txtCliente);

		txtPrecoMin = new JTextField();
		txtPrecoMin.setColumns(10);
		txtPrecoMin.setBounds(102, 139, 163, 20);
		panel.add(txtPrecoMin);

		JLabel lblNewLabel_3 = new JLabel("Preço mínimo:");
		lblNewLabel_3.setForeground(new Color(244, 238, 224));
		lblNewLabel_3.setBounds(10, 142, 93, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Preço máximo:");
		lblNewLabel_4.setForeground(new Color(244, 238, 224));
		lblNewLabel_4.setBounds(287, 142, 102, 14);
		panel.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();
			}
		});
		btnNewButton.setBounds(368, 184, 203, 23);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(51, 242, 520, 144);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 520, 144);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Vendedor", "Cliente", "Data pedido", "Pre\u00E7o total" }));
		scrollPane.setViewportView(table);

		txtPrecoMax = new JTextField();
		txtPrecoMax.setColumns(10);
		txtPrecoMax.setBounds(388, 139, 183, 20);
		panel.add(txtPrecoMax);

		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(FrmConsultaPedido, "Selecione a linha a ser excluida!");
					return;
				}
				Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
				PedidoDAO dao = new PedidoDAO();
				dao.delete(id, FrmConsultaPedido);
				atualizaBusca();
				
			}
		});
		btnNewButton_1.setBounds(453, 415, 118, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Visualizar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(FrmConsultaPedido, "Selecione a linha a ser excluida!");
					return;
				}
				Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
				TelaVisualizarPedido tp = new TelaVisualizarPedido(id);
				tp.getFrmVisualizarPedido().setVisible(true);
				FrmConsultaPedido.dispose();
				
				
			}
		});
		btnNewButton_1_1.setBounds(307, 415, 118, 23);
		panel.add(btnNewButton_1_1);
		FrmConsultaPedido.setBounds(100, 100, 619, 521);
	}
}
