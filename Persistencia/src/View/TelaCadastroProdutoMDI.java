package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroProdutoMDI extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProdutoMDI frame = new TelaCadastroProdutoMDI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public TelaCadastroProdutoMDI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de produto");
		lblNewLabel.setBounds(0, 42, 434, 22);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setBounds(97, 90, 71, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(97, 115, 86, 20);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Código de barras:");
		lblNewLabel_2.setBounds(254, 88, 118, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(254, 115, 86, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Preço de custo");
		lblNewLabel_3.setBounds(97, 163, 118, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 188, 86, 20);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Preço de venda");
		lblNewLabel_4.setBounds(254, 163, 118, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(254, 188, 86, 20);
		getContentPane().add(textField_3);
		
		JButton btnCadProduto = new JButton("Cadastrar");
		btnCadProduto.setBounds(165, 236, 101, 23);
		getContentPane().add(btnCadProduto);

	}
}
