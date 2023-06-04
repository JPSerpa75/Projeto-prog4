package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.cj.result.StringValueFactory;

import DAO.VendedorDAO;
import Dominio.Vendedor;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAlterarVendedor {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtUser;
	private JTextField txtCpf;
	private JButton btnSalvar;
	private JLabel lblNewLabel_1_2;
	private JTextField txtTelefone;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarVendedor window = new TelaAlterarVendedor();
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
	public TelaAlterarVendedor() {
		initialize();
	}
	
	

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(57, 54, 70));
		frame.setBackground(new Color(57, 54, 70));
		frame.setBounds(100, 100, 450, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(10, 105, 119, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(10, 164, 119, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuário:");
		lblNewLabel_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1.setBounds(10, 225, 119, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_1_1.setBounds(10, 343, 119, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		txtId.setForeground(new Color(57, 54, 70));
		txtId.setBackground(new Color(244, 238, 224));
		txtId.setBounds(10, 119, 414, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(57, 54, 70));
		txtNome.setBackground(new Color(244, 238, 224));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 183, 414, 20);
		frame.getContentPane().add(txtNome);
		
		txtUser = new JTextField();
		txtUser.setForeground(new Color(57, 54, 70));
		txtUser.setBackground(new Color(244, 238, 224));
		txtUser.setColumns(10);
		txtUser.setBounds(10, 240, 414, 20);
		frame.getContentPane().add(txtUser);
		
		txtCpf = new JTextField();
		txtCpf.setForeground(new Color(57, 54, 70));
		txtCpf.setBackground(new Color(244, 238, 224));
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 357, 414, 20);
		frame.getContentPane().add(txtCpf);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String usuario = txtUser.getText();
				String telefone = getTxtTelefone().getText();
				String cpf = txtCpf.getText();
				Vendedor v = new Vendedor(nome, usuario, telefone, cpf);
				v.setIdVendedor(Long.parseLong(txtId.getText()));
				VendedorDAO dao = new VendedorDAO();
				dao.update(v, frame);				
				frame.dispose();
			}
		});
		btnSalvar.setBounds(10, 402, 414, 23);
		frame.getContentPane().add(btnSalvar);
		
		lblNewLabel_1_2 = new JLabel("Telefone:");
		lblNewLabel_1_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_1_2.setBounds(10, 288, 119, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtTelefone = new JTextField();
		txtTelefone.setForeground(new Color(57, 54, 70));
		txtTelefone.setBackground(new Color(244, 238, 224));
		txtTelefone.setBounds(10, 302, 414, 20);
		frame.getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		
		lblNewLabel_2 = new JLabel("EDITAR VENDEDOR");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_2.setBounds(10, 45, 414, 49);
		frame.getContentPane().add(lblNewLabel_2);
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

	public JTextField getTxtUser() {
		return txtUser;
	}

	public void setTxtUser(String txtUser) {
		this.txtUser.setText(txtUser);
	}

	public JTextField getTxtCpf() {
		return txtCpf;
	}

	public void setTxtCpf(String txtCpf) {
		this.txtCpf.setText(txtCpf);
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public void setTxtTelefone(String txtTelefone) {
		this.txtTelefone.setText(txtTelefone);
	}

}
