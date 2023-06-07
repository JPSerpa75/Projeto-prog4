package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.ProdutoDAO;
import Dominio.Produto;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastroProduto extends JFrame {

	private JFrame frmTelaDeCadastro;
	
	public JFrame getFrmTelaDeCadastro() {
		return frmTelaDeCadastro;
	}

	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtCodbarras;
	private JTextField txtVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto window = new TelaCadastroProduto();
					window.frmTelaDeCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeCadastro = new JFrame();
		frmTelaDeCadastro.setResizable(false);
		frmTelaDeCadastro.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroProduto.class.getResource("/images/logo.jpg")));
		frmTelaDeCadastro.setTitle("Cadastro de Produto");
		frmTelaDeCadastro.setBounds(100, 100, 366, 336);
		frmTelaDeCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmTelaDeCadastro.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(57, 54, 70));
		panel_1.setBounds(0, 0, 350, 304);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de produto");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 11, 198, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(20, 59, 71, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código de barras:");
		lblNewLabel_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_2.setBounds(20, 102, 118, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Preço de custo");
		lblNewLabel_3.setForeground(new Color(244, 238, 224));
		lblNewLabel_3.setBounds(20, 189, 118, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Preço de venda");
		lblNewLabel_4.setForeground(new Color(244, 238, 224));
		lblNewLabel_4.setBounds(20, 148, 118, 14);
		panel_1.add(lblNewLabel_4);
		
		txtDescricao = new JTextField();
		txtDescricao.setForeground(new Color(57, 54, 70));
		txtDescricao.setBackground(new Color(244, 238, 224));
		txtDescricao.setBounds(20, 71, 305, 20);
		panel_1.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtCusto = new JTextField();
		txtCusto.setForeground(new Color(57, 54, 70));
		txtCusto.setBackground(new Color(244, 238, 224));
		txtCusto.setColumns(10);
		txtCusto.setBounds(20, 203, 305, 20);
		panel_1.add(txtCusto);
		
		txtCodbarras = new JTextField();
		txtCodbarras.setForeground(new Color(57, 54, 70));
		txtCodbarras.setBackground(new Color(244, 238, 224));
		txtCodbarras.setColumns(10);
		txtCodbarras.setBounds(20, 117, 305, 20);
		panel_1.add(txtCodbarras);
		
		txtVenda = new JTextField();
		txtVenda.setForeground(new Color(57, 54, 70));
		txtVenda.setBackground(new Color(244, 238, 224));
		txtVenda.setColumns(10);
		txtVenda.setBounds(20, 162, 305, 20);
		panel_1.add(txtVenda);
		
		JButton btnCadProduto = new JButton("Cadastrar");
		btnCadProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDescricao.getText().isEmpty() || txtCodbarras.getText().isEmpty() || 
						txtCusto.getText().isEmpty() || txtVenda.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmTelaDeCadastro, "Preencha os campos");
					return;
				}
				String descricao = txtDescricao.getText();
				String codBarras = txtCodbarras.getText();
				Float custo = Float.parseFloat(txtCusto.getText());
				Float venda = Float.parseFloat(txtVenda.getText());
				Produto p = new Produto(descricao, codBarras, custo, venda);
				ProdutoDAO dao = new ProdutoDAO();
				dao.Create(p, frmTelaDeCadastro);
				frmTelaDeCadastro.dispose();
			}
		});
		btnCadProduto.setBounds(20, 244, 305, 23);
		panel_1.add(btnCadProduto);
	}
}
