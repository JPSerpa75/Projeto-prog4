package Dominio;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Vendedor {
	private long idVendedor;
	private String nome;
	private String usuario;
	private String senha;
	private String telefone;
	private String cpf;
	
	public Vendedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vendedor(String nome, String usuario, String senha, String telefone, String cpf) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	public Vendedor(String nome, String usuario, String telefone, String cpf) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	public long getIdVendedor() {
		return idVendedor;
	}
	
	public void setIdVendedor(long idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
    public String toString() {
        return nome;
    }
	
	   public static String hashSHA256(String password) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

	            StringBuilder hexString = new StringBuilder();
	            for (byte b : encodedHash) {
	                String hex = String.format("%02x", b);
	                hexString.append(hex);
	            }

	            return hexString.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
