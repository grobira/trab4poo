package super4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

	public static void main(String[] args) {
		Comando op = new Comando();
		
		
		String command = "";
		Socket socket;
		PrintWriter pw;
		BufferedReader br;
		String resp = "";
		boolean logado = false;
		
		while(!command.equals("5")){
			command = op.escolheComando();
			try {
			
				socket = new Socket("127.0.0.1", 12345);
				if(command.equals("5")){
					socket.close();
					break;
				}else if((command.charAt(0) == '3' || command.charAt(0) == '4') && logado == false)
					System.out.println("Você precisa estar logado para efetuar essas ações!");
				else{
					
					pw = new PrintWriter(socket.getOutputStream(), true);
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pw.println(command);
					pw.flush();
			
					while((resp = br.readLine()) != null){
						if(resp.equals("ok"))
							break;
						System.out.println(resp);
						if(resp.equals("Login aceito!!")){
							logado = true;
						}
					}

				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		

	}
}
