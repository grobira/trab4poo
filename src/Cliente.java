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
		
		
		try {
			Socket socket = new Socket("127.0.0.1", 12345);
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			pw.println(command);
			pw.flush();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String resp = "";
		String aux;
		Socket socket;
		
		try {
			socket = new Socket("127.0.0.1", 12345);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while((aux = br.readLine()) != null){
				resp.concat(aux);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  

	}
}
