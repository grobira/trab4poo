package super4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
	List<Produto> produtosCadastrados;
	public Estoque(){
		produtosCadastrados = new ArrayList<Produto>();
		atualizaDoCSV();
	}
	
	private void atualizaDoCSV(){
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/produtos.csv"));
			String csv;
			while ((csv = in.readLine()) != null) {
				produtosCadastrados.add(new Produto(csv));
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File produtos.csv was not found!");
			try {
				FileWriter arq = new FileWriter("src/produtos.csv");
				System.out.println("File produtos.csv was created!");
				arq.close();
			} catch (IOException l) {
				System.out.println("Error reading/creating the file!");
			}
		} catch (IOException e) {
			System.out.println("Error reading the file!");
		}
	}
	
	
	public void adicionaProduto(Produto p){
		produtosCadastrados.add(p);
		adicionaProdutoCSV(p);
	}
	
	private void adicionaProdutoCSV(Produto p){
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(
					"src/produtos.csv", true));
			pw.println(p.toStringCSV());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
