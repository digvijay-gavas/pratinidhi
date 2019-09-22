package pratinidhi.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;



public class Server {

	Vector<Socket> sockets=new Vector<Socket>();
	int port;
	public Server(int port) {
		this.port=port;
	}
	public void startListening() {
		new Thread( new Runnable() {
			@Override
			public void run() {
				ServerSocket serverSocket=null;		
				try {
					serverSocket=new ServerSocket(port);
					
					while(true)
					{
						Socket socket=serverSocket.accept();
						sockets.add(socket);
						//SocketBindThread.bind(access_socket, socket,Config.printSocketComunication);
						
					}
				}
				catch(IOException e)
				{

				}
				
			}
		},""+port).start();;
	}
}
