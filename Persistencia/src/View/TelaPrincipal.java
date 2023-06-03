package View;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	private JFrame frmTelaPrincipal;

	public JFrame getFrmTelaPrincipal() {
		return frmTelaPrincipal;
	}

	public void setFrmTelaPrincipal(JFrame frmTelaPrincipal) {
		this.frmTelaPrincipal = frmTelaPrincipal;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmTelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaPrincipal = new JFrame();
		frmTelaPrincipal.setTitle("Home");
		frmTelaPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/images/logo.jpg")));
		frmTelaPrincipal.setResizable(false);
		frmTelaPrincipal.setBounds(100, 100, 450, 300);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaPrincipal.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 434, 261);
		frmTelaPrincipal.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(244, 238, 224));
		menuBar.setBounds(0, 0, 434, 22);
		panel.add(menuBar);
		
		JMenu mnProduto = new JMenu("Produto");
		mnProduto.setForeground(new Color(57, 54, 70));
		menuBar.add(mnProduto);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(433, 258, -431, -236);
		panel.add(desktopPane);
		
		JMenuItem mntmCadProduto = new JMenuItem("Cadastrar");
		mntmCadProduto.setBackground(new Color(244, 238, 224));
		mntmCadProduto.setForeground(new Color(57, 54, 70));
		mntmCadProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProduto cp = new TelaCadastroProduto();
				cp.getFrmTelaDeCadastro().setVisible(true);
//				TelaCadastroProdutoMDI tc = new TelaCadastroProdutoMDI();
//				desktopPane.setVisible(true);
//				desktopPane.add(tc);
//				frmTelaPrincipal.add(desktopPane);
			}
		});
		mnProduto.add(mntmCadProduto);
		
		JMenuItem mntmConProduto = new JMenuItem("Consultar");
		mntmConProduto.setBackground(new Color(244, 238, 224));
		mntmConProduto.setForeground(new Color(57, 54, 70));
		mntmConProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaProduto tc = new TelaConsultaProduto();
				tc.getFrmConsultaProduto().setVisible(true);
			}
		});
		mnProduto.add(mntmConProduto);
		
		JMenuItem mntmAltProduto = new JMenuItem("Alterar");
		mntmAltProduto.setBackground(new Color(244, 238, 224));
		mntmAltProduto.setForeground(new Color(57, 54, 70));
		mnProduto.add(mntmAltProduto);
		
		JMenuItem mntmExcProduto = new JMenuItem("Excluir");
		mntmExcProduto.setBackground(new Color(244, 238, 224));
		mntmExcProduto.setForeground(new Color(57, 54, 70));
		mnProduto.add(mntmExcProduto);
		
		JMenu mnCliente = new JMenu("Cliente");
		mnCliente.setBackground(new Color(244, 238, 224));
		mnCliente.setForeground(new Color(57, 54, 70));
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadCliente = new JMenuItem("Cadastrar");
		mntmCadCliente.setBackground(new Color(244, 238, 224));
		mntmCadCliente.setForeground(new Color(57, 54, 70));
		mntmCadCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente tc = new TelaCadastroCliente();
				tc.getFrmCadastroCliente().setVisible(true);
				
			}
		});
		mnCliente.add(mntmCadCliente);
		
		JMenuItem mntmConCliente = new JMenuItem("Consultar");
		mntmConCliente.setBackground(new Color(244, 238, 224));
		mntmConCliente.setForeground(new Color(57, 54, 70));
		mnCliente.add(mntmConCliente);
		
		JMenuItem mntmAltCliente = new JMenuItem("Alterar");
		mntmAltCliente.setBackground(new Color(244, 238, 224));
		mntmAltCliente.setForeground(new Color(57, 54, 70));
		mnCliente.add(mntmAltCliente);
		
		JMenuItem mntmExcCliente = new JMenuItem("Excluir");
		mntmExcCliente.setBackground(new Color(244, 238, 224));
		mntmExcCliente.setForeground(new Color(57, 54, 70));
		mnCliente.add(mntmExcCliente);
		
		JMenu mnFuncionarios = new JMenu("Funcionários");
		mnFuncionarios.setBackground(new Color(244, 238, 224));
		mnFuncionarios.setForeground(new Color(57, 54, 70));
		menuBar.add(mnFuncionarios);
		
		JMenuItem mntmCadFuncionario = new JMenuItem("Cadastrar");
		mntmCadFuncionario.setForeground(new Color(57, 54, 70));
		mntmCadFuncionario.setBackground(new Color(244, 238, 224));
		mnFuncionarios.add(mntmCadFuncionario);
		
		JMenuItem mntmConFuncionario = new JMenuItem("Consultar");
		mntmConFuncionario.setForeground(new Color(57, 54, 70));
		mntmConFuncionario.setBackground(new Color(244, 238, 224));
		mnFuncionarios.add(mntmConFuncionario);
		
		JMenuItem mntmAltFuncionario = new JMenuItem("Alterar");
		mntmAltFuncionario.setForeground(new Color(57, 54, 70));
		mntmAltFuncionario.setBackground(new Color(244, 238, 224));
		mnFuncionarios.add(mntmAltFuncionario);
		
		JMenuItem mntmExcFuncionario = new JMenuItem("Excluir");
		mntmExcFuncionario.setForeground(new Color(57, 54, 70));
		mntmExcFuncionario.setBackground(new Color(244, 238, 224));
		mnFuncionarios.add(mntmExcFuncionario);
		
		JMenu mnAbout = new JMenu("Sobre");
		mnAbout.setForeground(new Color(57, 54, 70));
		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frmTelaPrincipal, "Desenvolvido por João Pedro Serpa \nSoftware de gerenciamento génerico \nVersão 1.0");
			}
		});
		menuBar.add(mnAbout);
		
		
		

	}
}
