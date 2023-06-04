package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import DAO.VendedorDAO;
import Dominio.Vendedor;

public class TelaAlterarSenhaVendedor {

	private JFrame frmAlterarSenha;
	private JPasswordField txtSenhaAtual;
	private JPasswordField txtNovaSenha;
	private JPasswordField txtConfSenha;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlterarSenhaVendedor window = new TelaAlterarSenhaVendedor();
					window.frmAlterarSenha.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAlterarSenhaVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlterarSenha = new JFrame();
		frmAlterarSenha.setResizable(false);
		frmAlterarSenha.setTitle("Alterar senha");
		frmAlterarSenha.getContentPane().setBackground(new Color(57, 54, 70));
		frmAlterarSenha.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar senha");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(0, 34, 286, 14);
		frmAlterarSenha.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha atual: ");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(10, 82, 89, 14);
		frmAlterarSenha.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nova senha:");
		lblNewLabel_2.setForeground(new Color(244, 238, 224));
		lblNewLabel_2.setBounds(10, 127, 89, 14);
		frmAlterarSenha.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirma senha: ");
		lblNewLabel_3.setForeground(new Color(244, 238, 224));
		lblNewLabel_3.setBounds(10, 176, 124, 14);
		frmAlterarSenha.getContentPane().add(lblNewLabel_3);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendedorDAO dao = new VendedorDAO();
				Long id = Long.parseLong(txtId.getText());
				String novaSenha = String.valueOf(txtNovaSenha.getPassword());
				String confSenha = String.valueOf(txtConfSenha.getPassword());
				String senhaBanco = dao.getSenha(id, frmAlterarSenha);
				String senhaAtual = Vendedor.hashSHA256(String.valueOf(txtSenhaAtual.getPassword()));
				if( senhaAtual.isEmpty() || novaSenha.isEmpty() || confSenha.isEmpty()) {
					JOptionPane.showMessageDialog(frmAlterarSenha, "Preencha todos os campos!");
				}else {
					if(senhaAtual.equals(senhaBanco)) {
						if(novaSenha.equals(confSenha)) {
							String senhaCripto = Vendedor.hashSHA256(novaSenha);
							dao.updateSenha(senhaCripto, id, frmAlterarSenha);
							frmAlterarSenha.dispose();
							
						}else {
							JOptionPane.showMessageDialog(frmAlterarSenha, "As senhas digitadas não são iguais!");
						}
					}else {
						JOptionPane.showMessageDialog(frmAlterarSenha, "A senha atual está incorreta");
					}	
				}	
			}
		});
		btnSalvar.setBounds(97, 263, 89, 23);
		frmAlterarSenha.getContentPane().add(btnSalvar);
		
		txtSenhaAtual = new JPasswordField();
		txtSenhaAtual.setBackground(new Color(244, 238, 224));
		txtSenhaAtual.setForeground(new Color(57, 54, 70));
		txtSenhaAtual.setBounds(10, 96, 266, 20);
		frmAlterarSenha.getContentPane().add(txtSenhaAtual);
		
		txtNovaSenha = new JPasswordField();
		txtNovaSenha.setBackground(new Color(244, 238, 224));
		txtNovaSenha.setForeground(new Color(57, 54, 70));
		txtNovaSenha.setBounds(10, 139, 266, 20);
		frmAlterarSenha.getContentPane().add(txtNovaSenha);
		
		txtConfSenha = new JPasswordField();
		txtConfSenha.setBackground(new Color(244, 238, 224));
		txtConfSenha.setForeground(new Color(57, 54, 70));
		txtConfSenha.setBounds(10, 190, 266, 20);
		frmAlterarSenha.getContentPane().add(txtConfSenha);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setEnabled(false);
		txtId.setBounds(10, 221, -3, 20);
		frmAlterarSenha.getContentPane().add(txtId);
		frmAlterarSenha.setBounds(100, 100, 302, 373);
		frmAlterarSenha.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}

	public JPasswordField getPasswordField() {
		return txtSenhaAtual;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.txtSenhaAtual = passwordField;
	}

	public JPasswordField getPasswordField_1() {
		return txtNovaSenha;
	}

	public void setPasswordField_1(JPasswordField passwordField_1) {
		this.txtNovaSenha = passwordField_1;
	}

	public JPasswordField getPasswordField_2() {
		return txtConfSenha;
	}

	public void setPasswordField_2(JPasswordField passwordField_2) {
		this.txtConfSenha = passwordField_2;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(String txtId) {
		this.txtId.setText(txtId);
	}

	public JFrame getFrame() {
		return frmAlterarSenha;
	}

}
