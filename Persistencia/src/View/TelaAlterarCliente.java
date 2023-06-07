package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.ClienteDAO;
import Dominio.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaAlterarCliente {

	public JFrame getFrmCadastroCliente() {
		return frmAlterarCliente;
	}

	public JFrame getFrame() {
		return frmAlterarCliente;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(String txtId) {
		this.txtId.setText(txtId);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(String txtNome) {
		this.txtNome.setText(txtNome);
	}

	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public void setTxtCPF(String txtCPF) {
		this.txtCPF.setText(txtCPF);
	}

	public JTextField getTxtEnd() {
		return txtEndereco;
	}

	public void setTxtEnd(String txtEnd) {
		this.txtEndereco.setText(txtEnd);
	}

	public JTextField getTxtTel() {
		return txtTelefone;
	}

	public void setTxtTel(String txtTel) {
		this.txtTelefone.setText(txtTel);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}



	private JFrame frmAlterarCliente;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarCliente window = new TelaAlterarCliente();
					window.frmAlterarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlterarCliente = new JFrame();
		frmAlterarCliente.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaAlterarCliente.class.getResource("/images/logo.jpg")));
		frmAlterarCliente.setResizable(false);
		frmAlterarCliente.setTitle("Alterar cliente");
		frmAlterarCliente.setBounds(100, 100, 450, 497);
		frmAlterarCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAlterarCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 436, 460);
		frmAlterarCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Alterar Cliente");
		lblTitle.setForeground(new Color(244, 238, 224));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(176, 10, 141, 13);
		panel.add(lblTitle);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(244, 238, 224));
		txtId.setEnabled(false);
		txtId.setBounds(10, 89, 416, 19);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(new Color(244, 238, 224));
		lblId.setBounds(10, 66, 45, 13);
		panel.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(244, 238, 224));
		lblNome.setBounds(10, 118, 45, 13);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(244, 238, 224));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 141, 416, 19);
		panel.add(txtNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(new Color(244, 238, 224));
		lblCpf.setBounds(10, 170, 45, 13);
		panel.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setBackground(new Color(244, 238, 224));
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 193, 416, 19);
		panel.add(txtCPF);
		
		JLabel lblEnd = new JLabel("Endereço");
		lblEnd.setForeground(new Color(244, 238, 224));
		lblEnd.setBounds(10, 222, 66, 13);
		panel.add(lblEnd);
		
		txtEndereco = new JTextField();
		txtEndereco.setBackground(new Color(244, 238, 224));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 245, 416, 19);
		panel.add(txtEndereco);
		
		JLabel lblTel = new JLabel("Telefone");
		lblTel.setForeground(new Color(244, 238, 224));
		lblTel.setBounds(10, 274, 85, 13);
		panel.add(lblTel);
		
		txtTelefone = new JTextField();
		txtTelefone.setBackground(new Color(244, 238, 224));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 297, 416, 19);
		panel.add(txtTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(244, 238, 224));
		lblEmail.setBounds(10, 326, 45, 13);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(244, 238, 224));
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 349, 416, 19);
		panel.add(txtEmail);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().isEmpty() || txtCPF.getText().isEmpty() || 
						txtEndereco.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frmAlterarCliente, "Preencha os campos");
					return;
				}
				String nome = txtNome.getText();
				String cpf = txtCPF.getText();
				String telefone = txtTelefone.getText();
				String endereco = txtEndereco.getText();
				String email = txtEmail.getText();
				Cliente c = new Cliente(nome, cpf, endereco, telefone,  email);
				c.setIdCliente(Long.parseLong(txtId.getText()));
				ClienteDAO cd = new ClienteDAO();
				cd.update(c, frmAlterarCliente);
			}
		});
		btnAlterar.setBounds(341, 402, 85, 21);
		panel.add(btnAlterar);
	}
}
