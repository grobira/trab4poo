import java.util.Scanner;


public class Comando {
	public Comando(){}
	
	public String escolheComando(){
		String comando = "";
		System.out.println("1 fazer login 2 cadastrar user 3 listar produtos 4 comprar");
		Scanner scan = new Scanner(System.in);
		int resp = Integer.parseInt(scan.nextLine());
		comando = comando + resp;		
		if(resp == 1){
			System.out.println("Entre com o login:");
			String lg = scan.nextLine();
			System.out.println("Entre com a senha:");
			String sn = scan.nextLine();
			comando = comando + "," + lg;
			comando = comando + "," + sn;
		}else if(resp == 2){
			System.out.println("Entre com o login:");
			comando = ","+ scan.nextLine();
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
			
		}else if(resp == 3){
			scan.close();
			return comando;
		}
		
		scan.close();
		return comando;
	}
}
