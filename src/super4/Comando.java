package super4;

import java.util.Scanner;

public class Comando {
	public Comando() {
	}
	
	public String readLine(){
		Scanner scan = new Scanner(System.in);
		String test = null;
			test = scan.nextLine();
		

		return test;
	}

	public String escolheComando() {
		String comando = "";
		System.out
				.println("Escolha :\n[1] Para fazer login.\n[2] Para novo cadastro.\n[3] Para listar produtos.\n[4] Para efetuar uma comprar.\n[5] Para sair ");

		int resp = Integer.parseInt(readLine());
		comando = comando + resp;

		if (resp == 1) {

			System.out.println("Entre com o login :");
			String lg = readLine();
			System.out.println("Entre com a senha :");
			String sn = readLine();
			comando = comando + "," + lg;
			comando = comando + "," + sn;

		} else if (resp == 2) {

			System.out.println("Entre com o login :");
			String aux = readLine();
			comando = comando + "," + aux;
			System.out.println("Entre com o endereco :");
			aux = readLine();
			comando = comando + "," + aux;
			System.out.println("Entre com o telefone :");
			aux = readLine();
			comando = comando + "," + aux;
			System.out.println("Entre com o email :");
			aux = readLine();
			comando = comando + "," + aux;
			System.out.println("Entre com a senha :");
			aux = readLine();
			comando = comando + "," + aux;

		} else if (resp == 3 || resp == 5) {

			return comando;

		} else if (resp == 4) {

			System.out.println("Entre com o nome do produto :");
			String aux = readLine();
			comando = comando + "," + aux;
			System.out.println("Entre com a quantidade :");
			aux = readLine();
			comando = comando + "," + aux;

		}

		return comando;
	}
}
