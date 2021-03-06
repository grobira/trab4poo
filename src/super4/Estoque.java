package super4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	public Produto searchProduto(String nome){
		for(Produto p : produtosCadastrados){
			if(p.getNome().equals(nome)){
				return p;
			}
		}
		return null;
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
	
	public void rewrite(){
		File file = new File("src/produtos.csv");
		file.delete();
		
		try {
			FileWriter arq = new FileWriter("src/produtos.csv");
			arq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(
					"src/produtos.csv"));
			for (Produto p : produtosCadastrados) {
				pw.println(p.toString());
			}
			pw.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void novoProduto(Scanner scan){
		
		System.out.println("Entre com o nome do produto :");
		String nome = scan.nextLine();
		System.out.println("Entre com o preco do produto :");
		String preco = scan.nextLine();
		System.out.println("Entre com a data de validade (dd/mm/aaaa) :");
		String data = scan.nextLine();
		System.out.println("Entre com o fornecedor do produto :");
		String forn = scan.nextLine();	
		
		adicionaProduto(new Produto(nome, Double.parseDouble(preco), data, forn));
	}
	
	public int repoemEstoque(Scanner scan){
		
		System.out.println("Entre com o nome do produto para repor :");
		String nome = scan.nextLine();
		
		Produto p = searchProduto(nome);
		if(p != null){
			System.out.println("Entre com a quantidade que irá ser adicionada :");
			String quant = scan.nextLine();
			
			p.setQuantidade(p.getQuantidade() + Integer.parseInt(quant));
			System.out.println("Estoque reposto com sucesso!");
			rewrite();
			return 1;
		}else{
			System.out.println("Produto não cadastrado!");
			return 0;
		}
	}
}
