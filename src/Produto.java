

public class Produto {
	
	String nome;
	double preco;
	String dataDeValidade;
	String fornecedor;
	int quantidade;
	
	public Produto(String nome, double preco, String dataDeValidade,String fornecedor){
		
		this.nome = nome;
		this.preco = preco;
		this.dataDeValidade = dataDeValidade;
		this.fornecedor = fornecedor;
		this.quantidade = 0;
		
	}
	
	public Produto(String csv){
		
		String[] values = csv.split(",");
		this.nome = values[0];
		this.preco = Double.parseDouble(values[1]);
		this.dataDeValidade = values[2];
		this.fornecedor = values[3];
		this.quantidade = Integer.parseInt(values[4]);
		
	}
	
	public Produto(String nome, double preco, String dataDeValidade,String fornecedor, int quantidade){
		
		this.nome = nome;
		this.preco = preco;
		this.dataDeValidade = dataDeValidade;
		this.fornecedor = fornecedor;
		this.quantidade = quantidade;
		
	}
	
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public String getDataDeValidade() {
		return dataDeValidade;
	}

	public String getFornecedor() {
		return fornecedor;
	}
	
	public String print(){
		String str = "Nome : " + nome + "\nPreço : " + preco + "\nValidade : " + dataDeValidade + "\nFornecedor : " + fornecedor + "\nQuantidade : " + quantidade + "\n";
		return str;
	}

	public String toStringCSV(){
		String str = nome + "," + preco + "," + dataDeValidade + "," + fornecedor + "," + quantidade;
		return str;
	}
}
