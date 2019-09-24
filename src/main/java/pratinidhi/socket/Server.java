package pratinidhi.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

	public static void startListening(int port) {
		new Thread( new Runnable() {
			@Override
			public void run() {
				ServerSocket serverSocket=null; 
				Socket socket = null;
				VirtualSocket virtualSocket = null;
				try {
					serverSocket=new ServerSocket(port);
					
					while(true)
					{
						socket=serverSocket.accept();
						virtualSocket=new VirtualSocket(""+socket.getLocalPort(), port);
						//sockets.add(socket);
						SocketBindThread.bind(virtualSocket, socket,false);
						
					}
				}
				catch(IOException e)
				{
					try {
						socket.close();
						virtualSocket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
		},""+port).start();;
	}
}
