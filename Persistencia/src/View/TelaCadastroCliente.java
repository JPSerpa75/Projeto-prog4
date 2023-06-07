package View;

import java.awt.Color;
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

import DAO.ClienteDAO;
import Dominio.Cliente;

public class TelaCadastroCliente extends JFrame {

	private JFrame frmCadastroCliente;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtTelefone;

	public JFrame getFrmCadastroCliente() {
		return frmCadastroCliente;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroCliente = new JFrame();
		frmCadastroCliente.setResizable(false);
		frmCadastroCliente.setTitle("Cadastro cliente");
		frmCadastroCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/images/logo.jpg")));
		frmCadastroCliente.setBounds(100, 100, 363, 375);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 351, 363);
		frmCadastroCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro cliente");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 23, 351, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(25, 79, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_2.setBounds(25, 116, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone:");
		lblNewLabel_4.setForeground(new Color(244, 238, 224));
		lblNewLabel_4.setBounds(23, 233, 81, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail:");
		lblNewLabel_5.setForeground(new Color(244, 238, 224));
		lblNewLabel_5.setBounds(25, 193, 46, 14);
		panel.add(lblNewLabel_5);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(244, 238, 224));
		txtNome.setForeground(new Color(0, 0, 0));
		txtNome.setBounds(114, 73, 152, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBackground(new Color(244, 238, 224));
		txtCPF.setBounds(114, 114, 152, 20);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(244, 238, 224));
		txtEmail.setBounds(114, 191, 152, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBackground(new Color(244, 238, 224));
		txtTelefone.setBounds(114, 231, 152, 20);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(114, 153, 152, 20);
		panel.add(txtEndereco);
		txtEndereco.setBackground(new Color(244, 238, 224));
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endereco:");
		lblNewLabel_3.setBounds(25, 155, 115, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(244, 238, 224));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(25, 285, 298, 23);
		panel.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().isEmpty() || txtCPF.getText().isEmpty() || 
						txtEndereco.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmCadastroCliente, "Preencha os campos");
					return;
				}
					
				String nome = txtNome.getText();
				String cpf = txtCPF.getText();
				String endereco = txtEndereco.getText();
				String telefone = txtTelefone.getText();
				String email = txtEmail.getText();
				Cliente c = new Cliente(nome, cpf, endereco, telefone, email);
				ClienteDAO dao = new ClienteDAO();
				dao.Create(c, frmCadastroCliente);
				frmCadastroCliente.dispose();
				
			}
		});
	}

}
