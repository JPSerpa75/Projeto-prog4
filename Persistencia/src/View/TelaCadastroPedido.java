package View;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import DAO.ProdutoDAO;
import Dominio.Produto;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastroPedido {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPedido window = new TelaCadastroPedido();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(57, 54, 70));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Pedido");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(0, 0, 434, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 47, 434, 214);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Produto:");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(10, 11, 57, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox cbbProdutos = new JComboBox();
		cbbProdutos.setBackground(new Color(244, 238, 224));
		ProdutoDAO dao = new ProdutoDAO();
		for(Produto p: dao.Read()) {
			cbbProdutos.addItem(p.getDescricao());
		}
		
		cbbProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cbbProdutos.setBounds(66, 7, 340, 22);
		panel.add(cbbProdutos);
	}
}
