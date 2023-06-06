package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import DAO.ClienteDAO;
import Dominio.Cliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarCliente {

	public JFrame getFrmCadastroCliente() {
		return frame;
	}

	public JFrame getFrame() {
		return frame;
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
		return txtEnd;
	}

	public void setTxtEnd(String txtEnd) {
		this.txtEnd.setText(txtEnd);
	}

	public JTextField getTxtTel() {
		return txtTel;
	}

	public void setTxtTel(String txtTel) {
		this.txtTel.setText(txtTel);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(String txtEmail) {
		this.txtEmail.setText(txtEmail);
	}



	private JFrame frame;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEnd;
	private JTextField txtTel;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarCliente window = new TelaAlterarCliente();
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
	public TelaAlterarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 460);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Alterar Cliente");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitle.setBounds(176, 10, 101, 13);
		panel.add(lblTitle);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(10, 89, 96, 19);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 66, 45, 13);
		panel.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 118, 45, 13);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 141, 96, 19);
		panel.add(txtNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 170, 45, 13);
		panel.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(10, 193, 96, 19);
		panel.add(txtCPF);
		
		JLabel lblEnd = new JLabel("Endereço");
		lblEnd.setBounds(10, 222, 45, 13);
		panel.add(lblEnd);
		
		txtEnd = new JTextField();
		txtEnd.setColumns(10);
		txtEnd.setBounds(10, 245, 96, 19);
		panel.add(txtEnd);
		
		JLabel lblTel = new JLabel("Telefone");
		lblTel.setBounds(10, 274, 45, 13);
		panel.add(lblTel);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(10, 297, 96, 19);
		panel.add(txtTel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 326, 45, 13);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 349, 96, 19);
		panel.add(txtEmail);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cpf = txtCPF.getText();
				String telefone = txtTel.getText();
				String endereco = txtEnd.getText();
				String email = txtEmail.getText();
				Cliente c = new Cliente(nome, cpf, endereco, telefone,  email);
				c.setIdCliente(Long.parseLong(txtId.getText()));
				ClienteDAO cd = new ClienteDAO();
				cd.update(c, frame);
			}
		});
		btnAlterar.setBounds(10, 405, 85, 21);
		panel.add(btnAlterar);
	}
}
