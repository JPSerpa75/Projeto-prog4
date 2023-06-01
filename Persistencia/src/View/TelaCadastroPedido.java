package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import DAO.ProdutoDAO;
import Dominio.Produto;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroPedido {

	private JFrame frmCadastroDePedido;
	private JTextField textField;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDePedido = new JFrame();
		frmCadastroDePedido.setTitle("Cadastro de Pedido");
		frmCadastroDePedido.setResizable(false);
		frmCadastroDePedido.getContentPane().setBackground(new Color(57, 54, 70));
		frmCadastroDePedido.setBounds(100, 100, 602, 434);
		frmCadastroDePedido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDePedido.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Pedido");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(0, 11, 557, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmCadastroDePedido.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 47, 576, 337);
		frmCadastroDePedido.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox<Produto> cbbProdutos = new JComboBox();
		cbbProdutos.setBackground(new Color(244, 238, 224));
		ProdutoDAO dao = new ProdutoDAO();
		for(Produto p: dao.Read()) {
			cbbProdutos.addItem(p);
		}
		
		cbbProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cbbProdutos.setBounds(84, 95, 200, 22);
		panel.add(cbbProdutos);
		
		JComboBox cbbClientes = new JComboBox();
		cbbClientes.setBackground(new Color(244, 238, 224));
		cbbClientes.setBounds(84, 51, 340, 22);
		panel.add(cbbClientes);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cliente:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1.setBounds(0, 55, 71, 14);
		panel.add(lblNewLabel_1_1);
		
		JComboBox cbbFuncionarios = new JComboBox();
		cbbFuncionarios.setBackground(new Color(244, 238, 224));
		cbbFuncionarios.setBounds(84, 11, 340, 22);
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
		lblNewLabel_1_1_2_1.setBounds(294, 99, 71, 14);
		panel.add(lblNewLabel_1_1_2_1);
		
		textField = new JTextField();
		textField.setBounds(375, 96, 49, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produto teste = (Produto) cbbProdutos.getSelectedItem();
				int qtd;
			}
		});
		btnNewButton.setBounds(444, 95, 90, 23);
		panel.add(btnNewButton);
		
		JTable table = new JTable();
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 154, 462, 117);
		panel.add(panel_1);
		
		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setBounds(84, 154, 340, 117);
		panel_1.add(barraRolagem, BorderLayout.CENTER);
		
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produto", "Pre\u00E7o uni.", "Qtd", "Pre\u00E7o"
			}
		));
		
		JButton btnNewButton_1 = new JButton("Finalizar Pedido");
		btnNewButton_1.setBounds(199, 303, 143, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.setBounds(482, 246, 94, 23);
		panel.add(btnNewButton_2);

		
		
		
	}
}
