package Connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryMySQL {

	private static String banco = "mercado";
	private static String usuario = "root";
	private static String senha = "128712";
	private static String url ="jdbc:mysql://localhost:3306/";
	
	//Atributo que garante a criação de uma única instância do banco de dados
	//Singleton
	private static  ConnectionFactoryMySQL instancia = null;
	
	//atributo que realiza a conexão com o banco
	private static Connection conexao = null;
	//Construtor vazio
	public ConnectionFactoryMySQL() {
		conectar();
	}
	
	//método público que permite o uso de apenas uma instância da conexão com o banco, 
	//se ainda nao houver ativa cria e retorna para quem está chamando a instância
	//Faz parte do padrão Singleton
	
	public static ConnectionFactoryMySQL getInstancia() {
		if(instancia==null) {
			instancia = new ConnectionFactoryMySQL();
			conectar();
		}
		return instancia;
	}
	
	//Método que  efetivamente conecta com o banco 
	private static void  conectar() {
		try {
			conexao = DriverManager.getConnection(url+banco, usuario, senha);
			System.out.println("conexão bem sucedida!");
		}catch (SQLException e) {
			Logger.getLogger(ConnectionFactoryMySQL.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//Método que  efetivamente desconecta o banco 
	public static void  desconectar() {
		try {
			conexao.close();
			System.out.println("desconexão bem sucedida!");
		}catch (SQLException e) {
			Logger.getLogger(ConnectionFactoryMySQL.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	//metedod que irá "pegar" a conexão criada e retornar para quem está chamando
	//ele que nos permitirá incluir, excluir, alterar...
	public static Connection getConexao() {
		return conexao;
	}
}
