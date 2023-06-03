package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import DAO.ProdutoDAO;
import Dominio.ItemPedido;
import Dominio.Produto;

public class TelaCadastroPedido extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmCadastroDePedido;
	private JTextField txtQtd;
	private JTextField textField_1;
	
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

	private void atualizaBusca(List<ItemPedido> ItensPedidos) {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);
		for(ItemPedido ip: ItensPedidos) {
			tableModel.addRow(new Object[] {
					ip.getProduto().getDescricao(),
					ip.getProduto().getVenda(),
					ip.getQuantidade(),
					ip.getPrecoTotalItem(),
			});
		}
		
		if(tableModel.getRowCount()==0) {
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
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
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

		JComboBox<Produto> cbbProdutos = new JComboBox();
		cbbProdutos.setBackground(new Color(244, 238, 224));
		ProdutoDAO dao = new ProdutoDAO();
		for (Produto p : dao.Read()) {
			cbbProdutos.addItem(p);
		}

		cbbProdutos.setBounds(84, 95, 345, 22);
		panel.add(cbbProdutos);

		JComboBox cbbClientes = new JComboBox();
		cbbClientes.setBackground(new Color(244, 238, 224));
		cbbClientes.setBounds(84, 51, 618, 22);
		panel.add(cbbClientes);

		JLabel lblNewLabel_1_1 = new JLabel("Cliente:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1.setBounds(0, 55, 71, 14);
		panel.add(lblNewLabel_1_1);

		JComboBox cbbFuncionarios = new JComboBox();
		cbbFuncionarios.setBackground(new Color(244, 238, 224));
		cbbFuncionarios.setBounds(84, 11, 618, 22);
		panel.add(cbbFuncionarios);

		JLabel lblNewLabel_1_1_1 = new JLabel("Funcionário:");
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
				if(txtQtd.getText().trim().length() > 0) {
					ItemPedido ip = new ItemPedido();
					ip.setProduto((Produto)cbbProdutos.getSelectedItem());
					ip.setQuantidade(Float.valueOf(txtQtd.getText()));
					ip.setPrecoTotalItem(ip.getProduto().getVenda() * ip.getQuantidade());
					ItensProdutos.add(ip);
					atualizaBusca(ItensProdutos);
					txtQtd.setText("");		
				}else {
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

		DefaultTableModel model = new DefaultTableModel();

		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(455, 348, 94, 23);
		panel.add(btnRemover);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(351, 348, 94, 23);
		panel.add(btnEditar);
		
		JButton btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinalizarPedido.setBounds(575, 348, 127, 23);
		panel.add(btnFinalizarPedido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(551, 284, 151, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço Total:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(464, 287, 85, 14);
		panel.add(lblNewLabel_1);

	}
}
