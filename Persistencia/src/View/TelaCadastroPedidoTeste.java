package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;

import DAO.ProdutoDAO;
import Dominio.Produto;

import javax.swing.JComboBox;

public class TelaCadastroPedidoTeste {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPedidoTeste window = new TelaCadastroPedidoTeste();
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
	public TelaCadastroPedidoTeste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox<Produto> comboBox = new JComboBox<Produto>();
		comboBox.setBounds(173, 28, 183, 22);
		ProdutoDAO dao = new ProdutoDAO();
		for (Produto p : dao.Read()) {
			comboBox.addItem(p);
		}
		panel.add(comboBox);

	}
}
