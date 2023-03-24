package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.ProdutoDAO;
import Dominio.Produto;

import javax.swing.ListSelectionModel;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaConsultaProduto {

	private JFrame frmConsultaProduto;
	private JTextField txtDesc;
	
	public JFrame getFrmConsultaProduto() {
		return frmConsultaProduto;
	}

	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaProduto window = new TelaConsultaProduto();
					window.frmConsultaProduto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaProduto = new JFrame();
		frmConsultaProduto.setResizable(false);
		frmConsultaProduto.setTitle("Consulta produto");
		frmConsultaProduto.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultaProduto.class.getResource("/images/logo.jpg")));
		frmConsultaProduto.setBounds(100, 100, 450, 300);
		frmConsultaProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultaProduto.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frmConsultaProduto.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta Produto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 414, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição: ");
		lblNewLabel_1.setBounds(30, 44, 68, 14);
		panel.add(lblNewLabel_1);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(30, 66, 370, 23);
		panel.add(txtDesc);
		txtDesc.setColumns(10);
		
		JButton btnBuscaDescricao = new JButton("Filtrar");
		btnBuscaDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoDAO dao = new ProdutoDAO();
				String desc = txtDesc.getText();
				DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
				tableModel.setNumRows(0);
				for(Produto p:dao.ConsultarPorDescricao(desc)) {
					tableModel.addRow(new Object[] {
							p.getDescricao(),
							p.getCodBarras(),
							p.getCusto(),
							p.getVenda()
					});
				}
				
				if(tableModel.getRowCount()==0) {
					JOptionPane.showMessageDialog(frmConsultaProduto, "Nenhum produto foi encontrado!");
					txtDesc.setText("");
				}
				
				
			}
		});
		btnBuscaDescricao.setBounds(296, 100, 89, 23);
		panel.add(btnBuscaDescricao);
		
		JButton btnMostrarTodos = new JButton("Mostrar todos");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoDAO dao = new ProdutoDAO();
				DefaultTableModel tabelaModelo = (DefaultTableModel) table_1.getModel();
				tabelaModelo.setNumRows(0);
				for(Produto p: dao.Read() ) {
					tabelaModelo.addRow(new Object[] {
							p.getDescricao(),
							p.getCodBarras(),
							p.getCusto(),
							p.getVenda()
					});
				}
				if(tabelaModelo.getRowCount()==0) {
					JOptionPane.showMessageDialog(frmConsultaProduto, "Nenhum produto foi cadastrado!");
				}
				
			}
		});
		btnMostrarTodos.setBounds(184, 100, 117, 23);
		panel.add(btnMostrarTodos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 159, 370, 91);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 370, 91);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Descri\u00E7\u00E3o", "C\u00F3digo de barras", "Custo", "Venda"
			}
		));
		scrollPane_1.setViewportView(table_1);
		table_1.setAutoCreateRowSorter(true);
	}
}
