package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.ProdutoDAO;
import DAO.VendedorDAO;
import Dominio.Produto;
import Dominio.Vendedor;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaConsultaVendedor {

	private JFrame frmConsultarVendedor;
	private JTable table;
	private JTextField txtBsucar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaVendedor window = new TelaConsultaVendedor();
					window.frmConsultarVendedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaVendedor() {
		initialize();
		atualizaBusca();
	}
	
	
	
	public JFrame getFrmConsultarVendedor() {
		return frmConsultarVendedor;
	}

	private void atualizaBusca() {
		VendedorDAO dao = new VendedorDAO();
		String nome = txtBsucar.getText();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);
		for(Vendedor v:dao.GetVendedorNome(nome, frmConsultarVendedor)) {
			tableModel.addRow(new Object[] {
					v.getIdVendedor(),
					v.getNome(),
					v.getUsuario(),
					v.getTelefone(),
					v.getCpf()
			});
		}
		
		if(tableModel.getRowCount()==0) {
			JOptionPane.showMessageDialog(frmConsultarVendedor, "Nenhum vendedor foi encontrado!");
			txtBsucar.setText("");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarVendedor = new JFrame();
		frmConsultarVendedor.setTitle("Consultar vendedor");
		frmConsultarVendedor.setBounds(100, 100, 641, 470);
		frmConsultarVendedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultarVendedor.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 625, 431);
		frmConsultarVendedor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 110, 584, 276);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(244, 238, 224));
		table.setBackground(new Color(57, 54, 70));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Usu\u00E1rio", "Telefone", "CPF"
			}
		));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(panel, "Selecione uma linha para poder alterar o vendedor!");
				}else {
					Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
					String nome = (String) table.getValueAt(table.getSelectedRow(), 1);
					String usuario = (String) table.getValueAt(table.getSelectedRow(), 2);
					String telefone = (String) table.getValueAt(table.getSelectedRow(), 3);
					String cpf = (String) table.getValueAt(table.getSelectedRow(), 4);
					TelaAlterarVendedor ta = new TelaAlterarVendedor();
					ta.setTxtId(id.toString());
					ta.setTxtNome(nome.toString());
					ta.setTxtUser(usuario.toString());
					ta.setTxtTelefone(telefone.toString());
					ta.setTxtCpf(cpf.toString());
					ta.getFrame().setVisible(true);
					atualizaBusca();
				}
			}
		});
		btnAlterar.setBounds(515, 397, 89, 23);
		panel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
				VendedorDAO dao = new VendedorDAO();
				dao.delete(id, frmConsultarVendedor);
				atualizaBusca();	
			}
		});
		btnExcluir.setBounds(271, 397, 89, 23);
		panel.add(btnExcluir);
		
		txtBsucar = new JTextField();
		txtBsucar.setForeground(new Color(57, 54, 70));
		txtBsucar.setBackground(new Color(244, 238, 224));
		txtBsucar.setBounds(20, 48, 584, 20);
		panel.add(txtBsucar);
		txtBsucar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();
			}
		});
		btnBuscar.setBounds(440, 79, 164, 23);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Nome do vendedor:");
		lblNewLabel.setForeground(new Color(244, 238, 224));
		lblNewLabel.setBackground(new Color(244, 238, 224));
		lblNewLabel.setBounds(20, 35, 135, 14);
		panel.add(lblNewLabel);
		
		JButton btnAltSenha = new JButton("Alterar Senha");
		btnAltSenha.setBounds(370, 397, 135, 23);
		panel.add(btnAltSenha);
	}
}
