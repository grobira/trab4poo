package super4;

import java.util.Scanner;


public class SistemaCaixa {

	public static void main(String[] args) {
		Estoque armazem = new Estoque();
		Cadastros cads = new Cadastros();
		
		Thread t = new Thread(new serverManager(armazem, cads));
		t.start();
		
		
		int resp = 0;
		Scanner scan = new Scanner(System.in);
		while(resp != 4){
			System.out.println("Escolha :\n[1] para cadastrar produtos.\n[2] listar produtos.\n[3] adicionar produtos ao estoque.\n[4] para fechar a aplicação.");
			resp = Integer.parseInt(scan.nextLine());
			
			if(resp == 1){
				armazem.novoProduto(scan);
			}else if(resp == 2){		
				for(Produto p : armazem.produtosCadastrados){
					System.out.print(p.print());
					scan.nextLine();
				}
			}else if(resp == 3){
				armazem.repoemEstoque(scan);
			}
		}
		scan.close();

	}

}
