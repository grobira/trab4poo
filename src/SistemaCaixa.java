
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SistemaCaixa {

	public static void main(String[] args) {
		Estoque armazen = new Estoque();
		Cadastros cads = new Cadastros();
		
		//armazen.adicionaProduto(new Produto("veja,10.9,20/10/2015,mercado,10"));
		
		ServerSocket listener;
		Socket socket;
		
		try{
			listener = new ServerSocket(12345);

			while(true){
				System.out.println("Waiting...");
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
