import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

	public static void main(String[] args) {
		Comando op = new Comando();
		
		
		String command = op.escolheComando();
		Socket socket;
		PrintWriter pw;
		BufferedReader br;
		String resp;
		
		try {
			
			socket = new Socket("127.0.0.1", 12345);
			pw = new PrintWriter(socket.getOutputStream(), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw.println(command);
			pw.flush();
			
			while((resp = br.readLine()) != null){
				System.out.println(resp);
			}
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
