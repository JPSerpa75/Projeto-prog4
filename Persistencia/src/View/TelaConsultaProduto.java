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
import java.awt.Color;

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

	private void atualizaBusca() {
		ProdutoDAO dao = new ProdutoDAO();
		String desc = txtDesc.getText();
		DefaultTableModel tableModel = (DefaultTableModel) table_1.getModel();
		tableModel.setNumRows(0);
		for(Produto p:dao.ConsultarPorDescricao(desc, frmConsultaProduto)) {
			tableModel.addRow(new Object[] {
					p.getIdProduto(),
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
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 434, 261);
		frmConsultaProduto.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consulta Produto");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 414, 22);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição: ");
		lblNewLabel_1.setForeground(new Color(244, 238, 224));
		lblNewLabel_1.setBounds(30, 33, 68, 14);
		panel.add(lblNewLabel_1);
		
		txtDesc = new JTextField();
		txtDesc.setBackground(new Color(244, 238, 224));
		txtDesc.setBounds(30, 58, 370, 23);
		panel.add(txtDesc);
		txtDesc.setColumns(10);
		
		JButton btnBuscaDescricao = new JButton("Filtrar");
		btnBuscaDescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();
			}
		});
		btnBuscaDescricao.setBounds(311, 92, 89, 23);
		panel.add(btnBuscaDescricao);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(30, 126, 370, 91);
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
				"Id", "Descri\u00E7\u00E3o", "C\u00F3digo de barras", "Custo", "Venda"
			}
		));
		scrollPane_1.setViewportView(table_1);
		table_1.setAutoCreateRowSorter(true);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codBarras = (String) table_1.getValueAt(table_1.getSelectedRow(), 2);
				ProdutoDAO dao = new ProdutoDAO();
				dao.delete(codBarras, frmConsultaProduto);
				atualizaBusca();	
			}
		});
		btnExcluir.setBounds(311, 228, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id = (Long) table_1.getValueAt(table_1.getSelectedRow(), 0);
				String descricao = (String) table_1.getValueAt(table_1.getSelectedRow(), 1);
				String codBarras = (String) table_1.getValueAt(table_1.getSelectedRow(), 2);
				Float custo = (Float) table_1.getValueAt(table_1.getSelectedRow(), 3);
				Float venda = (Float) table_1.getValueAt(table_1.getSelectedRow(), 4);
				TelaAlterarProduto ta = new TelaAlterarProduto();
				ta.setTxtId(id.toString());
				ta.setTxtDescricao(descricao);
				ta.setTxtCodbarras(codBarras);
				ta.setTxtCusto(custo.toString());
				ta.setTxtVenda(venda.toString());
				ta.getFrmTelaDeCadastro().setVisible(true);
				atualizaBusca();
			}
		});
		btnAlterar.setBounds(210, 228, 89, 23);
		panel.add(btnAlterar);
	}
}
