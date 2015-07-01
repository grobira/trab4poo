package super4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverManager implements Runnable {

	Estoque e;
	Cadastros c;
	
	public serverManager(Estoque e, Cadastros c){
		this.e = e;
		this.c = c;
	}
	@Override
	public void run() {
		ServerSocket listener;
		Socket socket;
		
		try{
			listener = new ServerSocket(12345);

			while(true){
				socket = listener.accept();
				Thread t = new Thread(new ConectServer(e, c, socket));
				t.start();			
			}
		}catch (IOException e) {
            System.err.println("Unable to process client request");
            e.printStackTrace();
        }

	}

}
