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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.ProdutoDAO;
import Dominio.Produto;

public class TelaAlterarProduto extends JFrame {

	private JFrame frmTelaDeAlterar;
	
	public JFrame getFrmTelaDeCadastro() {
		return frmTelaDeAlterar;
	}

	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtCodbarras;
	private JTextField txtVenda;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarProduto window = new TelaAlterarProduto();
					window.frmTelaDeAlterar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeAlterar = new JFrame();
		frmTelaDeAlterar.setResizable(false);
		frmTelaDeAlterar.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAlterarProduto.class.getResource("/images/logo.jpg")));
		frmTelaDeAlterar.setTitle("Alterar Produto");
		frmTelaDeAlterar.setBounds(100, 100, 366, 297);
		frmTelaDeAlterar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmTelaDeAlterar.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 350, 258);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar de produto");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 11, 198, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição:");
		lblNewLabel_1.setBounds(131, 72, 71, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Código de barras:");
		lblNewLabel_2.setBounds(232, 72, 118, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Preço de custo:");
		lblNewLabel_3.setBounds(54, 139, 118, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Preço de venda:");
		lblNewLabel_4.setBounds(197, 139, 118, 14);
		panel_1.add(lblNewLabel_4);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(131, 97, 86, 20);
		panel_1.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtCusto = new JTextField();
		txtCusto.setColumns(10);
		txtCusto.setBounds(54, 164, 86, 20);
		panel_1.add(txtCusto);
		
		txtCodbarras = new JTextField();
		txtCodbarras.setColumns(10);
		txtCodbarras.setBounds(232, 97, 86, 20);
		panel_1.add(txtCodbarras);
		
		txtVenda = new JTextField();
		txtVenda.setColumns(10);
		txtVenda.setBounds(197, 164, 86, 20);
		panel_1.add(txtVenda);
		
		JButton btnAltProduto = new JButton("Alterar");
		btnAltProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descricao = txtDescricao.getText();
				String codBarras = txtCodbarras.getText();
				Float custo = Float.parseFloat(txtCusto.getText());
				Float venda = Float.parseFloat(txtVenda.getText());
				Produto p = new Produto(descricao, codBarras, custo, venda);
				p.setIdProduto(Long.parseLong(txtId.getText()));
				ProdutoDAO dao = new ProdutoDAO();
				dao.update(p, frmTelaDeAlterar);
				
				frmTelaDeAlterar.dispose();
				
				
			}
		});
		btnAltProduto.setBounds(123, 206, 101, 23);
		panel_1.add(btnAltProduto);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(24, 97, 86, 20);
		panel_1.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Id:");
		lblNewLabel_5.setBounds(24, 72, 46, 14);
		panel_1.add(lblNewLabel_5);
	}

	public JTextField getTxtDescricao() {
		return txtDescricao;
	}

	public void setTxtDescricao(String txtDescricao) {
		this.txtDescricao.setText(txtDescricao);
	}

	public JTextField getTxtCusto() {
		return txtCusto;
	}

	public void setTxtCusto(String txtCusto) {
		this.txtCusto.setText(txtCusto);
	}

	public JTextField getTxtCodbarras() {
		return txtCodbarras;
	}

	public void setTxtCodbarras(String txtCodbarras) {
		this.txtCodbarras.setText(txtCodbarras);
	}


	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(String txtId) {
		this.txtId.setText(txtId);
	}

	public JTextField getTxtVenda() {
		return txtVenda;
	}

	public void setTxtVenda(String txtVenda) {
		this.txtVenda.setText(txtVenda);
	}
}
