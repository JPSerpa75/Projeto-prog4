package DAO;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Dominio.Login;
import View.TelaPrincipal;

public class LoginDAO {
	
	public void autenticar(Login l, JFrame j) {
		if(l.getUser().equals("admin") && l.getPass().equals("admin")) {
			TelaPrincipal tp = new TelaPrincipal();
			tp.getFrmTelaPrincipal().setVisible(true);
			j.dispose();

		}else {
			JOptionPane.showMessageDialog(j, "Erro na autenticação!");
		}
	}
	

}
