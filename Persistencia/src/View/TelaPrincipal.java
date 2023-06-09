package View;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		frmTelaPrincipal.setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/images/logo.jpg")));
		frmTelaPrincipal.setResizable(false);
		frmTelaPrincipal.setBounds(100, 100, 553, 346);
		frmTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaPrincipal.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 544, 311);
		frmTelaPrincipal.getContentPane().add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(244, 238, 224));
		menuBar.setBounds(0, 0, 543, 22);
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
		mntmConCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaCliente tcc = new TelaConsultaCliente();
				tcc.getFrame().setVisible(true);
			}
		});
		mntmConCliente.setBackground(new Color(244, 238, 224));
		mntmConCliente.setForeground(new Color(57, 54, 70));
		mnCliente.add(mntmConCliente);

		JMenu mnFuncionarios = new JMenu("Vendedor");
		mnFuncionarios.setBackground(new Color(244, 238, 224));
		mnFuncionarios.setForeground(new Color(57, 54, 70));
		menuBar.add(mnFuncionarios);

		JMenuItem mntmCadFuncionario = new JMenuItem("Cadastrar");
		mntmCadFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroVendedor tc = new TelaCadastroVendedor();
				tc.getFrmCadVendedor().setVisible(true);
			}
		});
		mntmCadFuncionario.setForeground(new Color(57, 54, 70));
		mntmCadFuncionario.setBackground(new Color(244, 238, 224));
		mnFuncionarios.add(mntmCadFuncionario);

		JMenuItem mntmConFuncionario = new JMenuItem("Consultar");
		mntmConFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaVendedor tc = new TelaConsultaVendedor();
				tc.getFrmConsultarVendedor().setVisible(true);
			}
		});
		mntmConFuncionario.setForeground(new Color(57, 54, 70));
		mntmConFuncionario.setBackground(new Color(244, 238, 224));
		mnFuncionarios.add(mntmConFuncionario);

		JMenu mnAbout = new JMenu("Sobre");
		mnAbout.setForeground(new Color(57, 54, 70));
		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frmTelaPrincipal,
						"Desenvolvido por \nJoão Pedro Serpa \nGuilherme Oliveira \nPaulo Henrique \nSandeiro Rebaixado Ditzz \nGerenciamento de pedidos \nVersão 1.0");
			}
		});

		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);

		JMenuItem mntmCadPedido = new JMenuItem("Cadastrar");
		mntmCadPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPedido tp = new TelaCadastroPedido();
				tp.getFrmCadastroDePedido().setVisible(true);
			}
		});
		mnPedido.add(mntmCadPedido);

		JMenuItem mntmConPedido = new JMenuItem("Consultar");
		mntmConPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaPedido tp = new TelaConsultaPedido();
				tp.getFrmConsultaPedido().setVisible(true);
			}
		});
		mnPedido.add(mntmConPedido);
		menuBar.add(mnAbout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/sand.jpg")));
		lblNewLabel.setBounds(0, 21, 543, 290);
		panel.add(lblNewLabel);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
