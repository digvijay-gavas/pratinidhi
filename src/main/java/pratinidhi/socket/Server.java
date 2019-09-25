package pratinidhi.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import pratinidhi.runtime.Global;

public class Server implements Runnable{
	int port;
	public Server(int port) {
		this.port=port;
	}

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
				virtualSocket=new VirtualSocket(""+socket.getPort(), port);
				Global.virtualSockets.put(""+socket.getLocalPort(), virtualSocket);
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
}
