package View;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DAO.LoginDAO;
import Dominio.Login;

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
		frmLogin.setBounds(100, 100, 258, 400);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setBounds(38, 64, 61, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lbl = new JLabel("Senha:");
		lbl.setBounds(38, 122, 46, 14);
		panel.add(lbl);
		
		txtUser = new JTextField();
		txtUser.setBounds(38, 89, 170, 22);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(82, 193, 89, 23);
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
		pswPass.setBounds(38, 147, 170, 22);
		panel.add(pswPass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(76, 0, 95, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/login2.png")));
	}
}
