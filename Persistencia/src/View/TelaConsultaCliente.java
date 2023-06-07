package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import Dominio.Cliente;
import Dominio.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class TelaConsultaCliente {

	private JFrame frmConsultaDeClientes;
	private JTextField txtNome;
	private JTable table;
	
	

	public JFrame getFrame() {
		return frmConsultaDeClientes;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaCliente window = new TelaConsultaCliente();
					window.frmConsultaDeClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void atualizaBusca() {
		ClienteDAO dao = new ClienteDAO();
		String nome = txtNome.getText();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setNumRows(0);
		for(Cliente c:dao.ConsultarPorNome(nome, frmConsultaDeClientes)) {
			tableModel.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getCpf(),
					c.getTelefone(),
					c.getEndereco(),
					c.getEmail()	
			});
		}
		
		if(tableModel.getRowCount()==0) {
			JOptionPane.showMessageDialog(frmConsultaDeClientes, "Nenhum cliente foi encontrado!");
			txtNome.setText("");
		}
	}

	/**
	 * Create the application.
	 */
	public TelaConsultaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultaDeClientes = new JFrame();
		frmConsultaDeClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaConsultaCliente.class.getResource("/images/logo.jpg")));
		frmConsultaDeClientes.setResizable(false);
		frmConsultaDeClientes.setTitle("Consulta de clientes");
		frmConsultaDeClientes.setBounds(100, 100, 450, 403);
		frmConsultaDeClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultaDeClientes.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(57, 54, 70));
		panel.setBounds(0, 0, 434, 364);
		frmConsultaDeClientes.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Consultar Clientes");
		lblTitle.setForeground(new Color(244, 238, 224));
		lblTitle.setBounds(155, 11, 170, 14);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblTitle);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(244, 238, 224));
		lblNome.setBounds(10, 46, 39, 14);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(244, 238, 224));
		txtNome.setBounds(10, 71, 414, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaBusca();
			}
		});
		btnFiltrar.setBounds(335, 102, 89, 23);
		panel.add(btnFiltrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 414, 131);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(57, 54, 70));
		table.setForeground(new Color(244, 238, 224));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "CPF", "Telefone", "Endere\u00E7o", "Email"
			}
		));
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(frmConsultaDeClientes, "Selecione a linha a ser alterada!");
					return;
				}
				Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
				String nome = (String) table.getValueAt(table.getSelectedRow(), 1);
				String cpf = (String) table.getValueAt(table.getSelectedRow(), 2);
				String telefone = (String) table.getValueAt(table.getSelectedRow(), 3);
				String endereco = (String) table.getValueAt(table.getSelectedRow(), 4);
				String email = (String) table.getValueAt(table.getSelectedRow(), 5);
				TelaAlterarCliente ta = new TelaAlterarCliente();
				ta.setTxtId(id.toString());
				ta.setTxtNome(nome);
				ta.setTxtCPF(cpf);
				ta.setTxtEnd(endereco);
				ta.setTxtTel(telefone);
				ta.setTxtEmail(email);
				ta.getFrame().setVisible(true);
				atualizaBusca();
		}
		});
		btnAlterar.setBounds(236, 290, 89, 23);
		panel.add(btnAlterar);
		
		JButton btnNewButton = new JButton("Excluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(frmConsultaDeClientes, "Selecione a linha a ser excluída!");
					return;
				}
				Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
				ClienteDAO dao = new ClienteDAO();
				dao.delete(id, frmConsultaDeClientes);
				atualizaBusca();
			}
		});
		btnNewButton.setBounds(335, 290, 89, 23);
		panel.add(btnNewButton);
	}
}
