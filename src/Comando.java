import java.util.Scanner;


public class Comando {
	public Comando(){}
	
	public String escolheComando(){
		String comando = "";
		System.out.println("1 fazer login 2 cadastrar user 3 listar produtos 4 comprar");
		Scanner scan = new Scanner(System.in);
		int resp = scan.nextInt();
		comando = comando + resp;		
		if(resp == 1){
			scan.close();
			comando = comando + fazerLogin();
		}else if(resp == 2){
			scan.close();
			comando = comando + cadastrarUser();
		}else if(resp == 3){
			scan.close();
			return comando;
		}
				
		return comando;
	}
	
	public String fazerLogin(){
		Scanner scan = new Scanner(System.in);
		String comando = "";
		
		
		System.out.println("login:");
		comando.concat(","+ scan.nextLine());
		System.out.println("senha:");
		comando.concat("," + scan.nextLine());
		
		scan.close();
		return comando;
	}
	
	public String cadastrarUser(){
		Scanner scan = new Scanner(System.in);
		String comando = "";
		
		System.out.println("Entre com o login:");
		comando.concat(","+ scan.nextLine());
		System.out.println("Entre com o endereco:");
		comando.concat("," + scan.nextLine());
		System.out.println("Entre com o telefone:");
		comando.concat(","+ scan.nextLine());
		System.out.println("Entre com o email:");
		comando.concat("," + scan.nextLine());
		System.out.println("Entre com o ID:");
		comando.concat(","+ scan.nextLine());
		System.out.println("Entre com a senha:");
		comando.concat("," + scan.nextLine());
		
		scan.close();
		return comando;
	}
}
