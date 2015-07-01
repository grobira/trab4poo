package super4;


public class SistemaCaixa {

	public static void main(String[] args) {
		Estoque armazem = new Estoque();
		Cadastros cads = new Cadastros();
		
		Thread t = new Thread(new serverManager(armazem, cads));
		t.start();
		
		
		
		

	}

}
