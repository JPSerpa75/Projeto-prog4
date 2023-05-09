package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.LoginDAO;
import Dominio.Login;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class TelaLogin extends JFrame {

	private JFrame frmLogin;
	private JTextField txtUser;
	private JPasswordField pswPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		//setVisible(true);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/images/logo.jpg")));
		frmLogin.setTitle("Login");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 258, 301);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(38, 75, 61, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lbl = new JLabel("Senha:");
		lbl.setForeground(new Color(244, 238, 224));
		lbl.setBounds(38, 133, 46, 14);
		panel.add(lbl);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Segoe UI Semilight", Font.BOLD, 13));
		txtUser.setBackground(new Color(244, 238, 224));
		txtUser.setForeground(new Color(57, 54, 70));
		txtUser.setBounds(38, 89, 170, 22);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(38, 193, 170, 23);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = txtUser.getText();
				String pass = String.valueOf(pswPass.getPassword());
				
				Login l = new Login(user, pass);
				LoginDAO ld = new LoginDAO();
				ld.autenticar(l, frmLogin);
				

			}
		});
		panel.add(btnLogin);
		
		pswPass = new JPasswordField();
		pswPass.setBackground(new Color(244, 238, 224));
		pswPass.setForeground(new Color(57, 54, 70));
		pswPass.setBounds(38, 147, 170, 22);
		panel.add(pswPass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBounds(61, 11, 123, 78);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/login2.png")));
	}
}
