package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.VendedorDAO;
import Dominio.Vendedor;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class TelaCadastroVendedor {

	private JFrame frmCadVendedor;
	private JTextField txtNome;
	private JTextField txtUser;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JPasswordField txtSenha;
	private JPasswordField txtConfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVendedor window = new TelaCadastroVendedor();
					window.frmCadVendedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadVendedor = new JFrame();
		frmCadVendedor.setTitle("Cadastrar Vendedor");
		frmCadVendedor.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroVendedor.class.getResource("/images/logo.jpg")));
		frmCadVendedor.getContentPane().setBackground(new Color(57, 54, 70));
		frmCadVendedor.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(20, 11, 46, 14);
		frmCadVendedor.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(20, 58, 123, 14);
		frmCadVendedor.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha: ");
		lblNewLabel_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_2.setBounds(20, 108, 123, 14);
		frmCadVendedor.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setForeground(new Color(244, 238, 224));
		lblNewLabel_3.setBounds(20, 198, 102, 14);
		frmCadVendedor.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone:");
		lblNewLabel_4.setForeground(new Color(244, 238, 224));
		lblNewLabel_4.setBounds(20, 241, 123, 14);
		frmCadVendedor.getContentPane().add(lblNewLabel_4);
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(57, 54, 70));
		txtNome.setBackground(new Color(244, 238, 224));
		txtNome.setBounds(20, 27, 319, 20);
		frmCadVendedor.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(57, 54, 70));
		txtUser.setBackground(new Color(244, 238, 224));
		txtUser.setColumns(10);
		txtUser.setBounds(20, 75, 319, 20);
		frmCadVendedor.getContentPane().add(txtUser);
		
		txtCpf = new JTextField();
		txtCpf.setForeground(new Color(57, 54, 70));
		txtCpf.setBackground(new Color(244, 238, 224));
		txtCpf.setColumns(10);
		txtCpf.setBounds(20, 210, 319, 20);
		frmCadVendedor.getContentPane().add(txtCpf);
		
		txtTelefone = new JTextField();
		txtTelefone.setForeground(new Color(57, 54, 70));
		txtTelefone.setBackground(new Color(244, 238, 224));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(20, 256, 318, 20);
		frmCadVendedor.getContentPane().add(txtTelefone);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(57, 54, 70));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = String.valueOf(txtSenha.getPassword());
				String senhaConf = String.valueOf(txtConfSenha.getPassword());
				if(senha.equals(senhaConf)) {
					String nome = txtNome.getText();
					String cpf = txtCpf.getText();
					String telefone = txtTelefone.getText();
					String usuario = txtUser.getText();
					String senhaCripto = Vendedor.hashSHA256(senha);
					Vendedor v = new Vendedor(nome, usuario, senhaCripto, telefone, cpf);
					VendedorDAO dao = new VendedorDAO();
					dao.Create(v, frmCadVendedor);
					
				}else {
					JOptionPane.showMessageDialog(btnCadastrar, "As senhas não são iguais!");
				}
			}
		});
		btnCadastrar.setBounds(20, 302, 319, 23);
		frmCadVendedor.getContentPane().add(btnCadastrar);
		
		JLabel lblNewLabel_2_1 = new JLabel("Confirmar senha: ");
		lblNewLabel_2_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_2_1.setBounds(20, 153, 160, 14);
		frmCadVendedor.getContentPane().add(lblNewLabel_2_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setForeground(new Color(57, 54, 70));
		txtSenha.setBackground(new Color(244, 238, 224));
		txtSenha.setBounds(20, 123, 319, 20);
		frmCadVendedor.getContentPane().add(txtSenha);
		
		txtConfSenha = new JPasswordField();
		txtConfSenha.setForeground(new Color(57, 54, 70));
		txtConfSenha.setBackground(new Color(244, 238, 224));
		txtConfSenha.setBounds(20, 167, 319, 20);
		frmCadVendedor.getContentPane().add(txtConfSenha);
		frmCadVendedor.setBounds(100, 100, 370, 393);
		frmCadVendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
