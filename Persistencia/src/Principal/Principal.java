package Principal;

import java.util.ArrayList;

import javax.swing.JFrame;

import DAO.ProdutoDAO;
import Dominio.Produto;

public class Principal {
	
	public static void main(String[] args) {
		
		Produto p = new Produto();
		p.setDescricao("teste");
		p.setCodBarras("123");
		p.setCusto((float) 5.50);
		p.setVenda((float) 7.0);
		
		ProdutoDAO dao = new ProdutoDAO();
		
		//dao.Create(p);
		
		
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos = dao.Read();
		for(Produto pd: produtos) {
			System.out.println("----------------------------------");
//			System.out.println("Posição do ArrayList: " + produtos.indexOf(pd));
			System.out.println("IdProduto: " + pd.getIdProduto());
			System.out.println("Descricao: " + pd.getDescricao());
			System.out.println("CodBarras: " + pd.getCodBarras());
			System.out.println("Custo: " + pd.getCusto());
			System.out.println("Venda: " + pd.getVenda());
		}		
		
//		produtos = dao.ConsultarPorDescricao("es");
//		for(Produto pd: produtos) {
//			System.out.println("----------------------------------");
////			System.out.println("Posição do ArrayList: " + produtos.indexOf(pd));
//			System.out.println("IdProduto: " + pd.getIdProduto());
//			System.out.println("Descricao: " + pd.getDescricao());
//			System.out.println("CodBarras: " + pd.getCodBarras());
//			System.out.println("Custo: " + pd.getCusto());
//			System.out.println("Venda: " + pd.getVenda());
//		}
		
		//dao.delete(p.getCodBarras());
		
		Produto prod = new Produto();
		prod.setIdProduto((long) 6);
		prod.setDescricao("teste update");
		prod.setCodBarras("123");
		prod.setCusto((float) 20.5);
		prod.setVenda((float) 40);
		
//		dao.update(prod);
		
	}

}
