package super4;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SistemaCaixa {

	public static void main(String[] args) {
		Estoque armazen = new Estoque();
		Cadastros cads = new Cadastros();
		
		ServerSocket listener;
		Socket socket;
		
		try{
			listener = new ServerSocket(12345);

			while(true){
				socket = listener.accept();
				Thread t = new Thread(new ConectServer(armazen, cads, socket));
				t.start();			
			}
		}catch (IOException e) {
            System.err.println("Unable to process client request");
            e.printStackTrace();
        }
		
		

	}

}
